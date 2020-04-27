package com.xieyangzhe.others.nio;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Yangzhe Xie
 * @date 27/4/20
 */
public class EchoClient {
    private Selector selector;
    private SocketChannel socketChannel;
    private volatile boolean stop;

    public static void main(String[] args) {
        try {
            new EchoClient().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void start() throws IOException {
        selector = Selector.open();
        socketChannel = SocketChannel.open();
        socketChannel.configureBlocking(false);
        boolean connected = socketChannel.connect(new InetSocketAddress("127.0.0.1", EchoServer.PORT));
        if (connected) {
            socketChannel.register(selector, SelectionKey.OP_WRITE);
        } else {
            socketChannel.register(selector, SelectionKey.OP_CONNECT);
        }
        while (!stop) {
            selector.select(1000);
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeySet.iterator();
            while (it.hasNext()) {
                SelectionKey key = it.next();
                it.remove();
                handle(key);
            }
        }
    }

    private void handle(SelectionKey key) throws IOException {
        if (key.isValid()) {
            SocketChannel channel = (SocketChannel) key.channel();
            if (key.isConnectable()) {
                if (channel.finishConnect()) {
                    channel.register(selector, SelectionKey.OP_WRITE);
                }
            }
            if (key.isReadable()) {
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readCount = channel.read(readBuffer);
                if (readCount > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    System.out.println(new String(bytes, StandardCharsets.UTF_8));
                } else if (readCount < 0) {
                    key.cancel();
                    channel.close();
                }
                channel.register(selector, SelectionKey.OP_WRITE);
            }
            if (key.isWritable()) {
                BufferedReader localReader = new BufferedReader(new InputStreamReader(System.in));
                String msg;
                if (((msg = localReader.readLine()) != null)) {
                    ByteBuffer writeBuffer = ByteBuffer.allocate(msg.getBytes().length);
                    writeBuffer.put(msg.getBytes());
                    writeBuffer.flip();
                    socketChannel.write(writeBuffer);
                    socketChannel.register(selector, SelectionKey.OP_READ);
                }
            }
        }
    }
}
