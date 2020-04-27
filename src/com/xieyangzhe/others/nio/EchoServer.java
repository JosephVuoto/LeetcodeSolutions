package com.xieyangzhe.others.nio;

import com.sun.security.ntlm.Server;

import java.io.BufferedReader;
import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.ServerSocketChannel;
import java.nio.channels.SocketChannel;
import java.nio.charset.StandardCharsets;
import java.util.Iterator;
import java.util.Set;

/**
 * @author Yangzhe Xie
 * @date 27/4/20
 */
public class EchoServer {
    public static final int PORT = 8888;

    private Selector selector;
    private volatile boolean stop;

    private void start() throws IOException {
        selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.socket().bind(new InetSocketAddress(PORT));
        serverSocketChannel.register(selector, SelectionKey.OP_ACCEPT);
        System.out.println("Server is started");

        while (!stop) {
            selector.select(1000);
            Set<SelectionKey> selectionKeySet = selector.selectedKeys();
            Iterator<SelectionKey> it = selectionKeySet.iterator();
            SelectionKey key = null;
            while(it.hasNext()){
                key = it.next();
                it.remove();;
                handle(key);
            }
        }
    }

    private void handle(SelectionKey key) throws IOException {
        if (key.isValid()) {
            if (key.isAcceptable()) {
                ServerSocketChannel serverSocketChannel = (ServerSocketChannel) key.channel();
                SocketChannel socketChannel = serverSocketChannel.accept();
                socketChannel.configureBlocking(false);
                socketChannel.register(selector, SelectionKey.OP_READ);
            }
            if (key.isReadable()) {
                SocketChannel socketChannel = (SocketChannel) key.channel();
                ByteBuffer readBuffer = ByteBuffer.allocate(1024);
                int readCount = socketChannel.read(readBuffer);
                if (readCount > 0) {
                    readBuffer.flip();
                    byte[] bytes = new byte[readBuffer.remaining()];
                    readBuffer.get(bytes);
                    String receiveMsg = new String(bytes, StandardCharsets.UTF_8);
                    if("bye".equals(receiveMsg)){
                        stop();
                        return;
                    }
                    String responseMsg = "Server received: " + receiveMsg;
                    System.out.println("Client: " + receiveMsg);
                    ByteBuffer responseBuffer = ByteBuffer.allocate(responseMsg.getBytes().length);
                    responseBuffer.put(responseMsg.getBytes());
                    responseBuffer.flip();
                    socketChannel.write(responseBuffer);
                }
            }
        }
    }

    public void stop(){
        this.stop = true;
    }

    public static void main(String[] args) {
        try {
            new EchoServer().start();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
