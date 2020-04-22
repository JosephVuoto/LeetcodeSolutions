package com.xieyangzhe.others;

import sun.misc.Unsafe;

import java.lang.reflect.Field;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * @author Yangzhe Xie
 * @date 22/4/20
 */

public class RingBuffer<T> {

    public static void main(String[] args) {
        RingBuffer<Integer> buffer = new RingBuffer<>();
    }
    private static final int DEFAULT_SIZE = 1024;
    private Object[] elements;
    private int head;
    private int tail;
    private int size;
    private int capacity;

    private static Unsafe unsafe;

    private long valueOffset;
    private long indexScale;

    static {
        try {
            Field singletonInstanceField = Unsafe.class.getDeclaredField("theUnsafe");
            singletonInstanceField.setAccessible(true);
            unsafe = (Unsafe)singletonInstanceField.get(null);

//            valueOffset = unsafe.objectFieldOffset
////                    (RingBuffer.class.getDeclaredField("elements"));
        } catch (Exception ex) { throw new Error(ex); }
    }

    public RingBuffer() {
        this(DEFAULT_SIZE);
    }

    public RingBuffer(int capacity) {
        if (capacity < 1) {
            throw new IllegalArgumentException("The capacity argument (" + capacity +
                    ") is not a positive integer.");
        }

        this.capacity = capacity;
        elements = new Object[capacity];
        this.head = 0;
        this.tail = 0;
        size = 0;

        //TODO: init offsets
        valueOffset = unsafe.arrayBaseOffset(elements.getClass());
        indexScale = unsafe.arrayIndexScale(elements.getClass());
    }

    public void add(T element) {
        elements[tail] = element;
        if (++tail == capacity) {
            tail = 0;
        }
        if (size < capacity) {
            size++;
        } else if (++head == capacity) {
            head = 0;
        }
    }

    public T get() {
        Object ele = null;
        if (size > 0) {
            size--;
            ele = elements[head];
            if (++head == capacity) {
                head = 0;
            }
        }
        return (T) ele;
    }

    public int length() {
        return size;
    }

    public void resize(int newCapacity) {
        if (newCapacity < 0) {
            throw new IllegalArgumentException("Negative array size [" + newCapacity +
                    "] not allowed.");
        }

        if (newCapacity == size) {
            return;
        }

        Object[] temp = new Object[newCapacity];
        int loopLen = Math.min(newCapacity, size);
        for (int i = 0; i < loopLen; i++) {
            temp[i] = elements[head];
            elements[head] = null;
            if (++head == size) {
                head = 0;
            }
        }
        elements = temp;
        head = 0;
        size = loopLen;
        capacity = newCapacity;
        if (loopLen == newCapacity) {
            tail = 0;
        } else {
            tail = loopLen;
        }
    }

    public final boolean compareAndSet(long offset, int expect, int update) {
        return unsafe.compareAndSwapInt(this, offset, expect, update);
    }

}

