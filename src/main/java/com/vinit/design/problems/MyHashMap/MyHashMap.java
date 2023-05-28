package com.vinit.design.problems.MyHashMap;

public class MyHashMap<K, V> {
    private static final int MIN_SIZE = 1 << 4;
    private static final int MAXIMUM_CAPACITY = 1 << 30;
    public Entry[] hashTable;
    public MyHashMap() {
        hashTable = new Entry[MIN_SIZE];
    }

    public MyHashMap(int capacity) {
        int tableSize = tableSizeFor(capacity);
        hashTable = new Entry[tableSize];
    }

    final int tableSizeFor(int cap) {
        int n = cap - 1;
        n |= n >>> 1;
        n |= n >>> 2;
        n |= n >>> 4;
        n |= n >>> 8;
        n |= n >>> 16;
        return (n < 0) ? 0 : (n >= MAXIMUM_CAPACITY) ? MAXIMUM_CAPACITY : n + 1;
    }

    public void put(K k, V v) {
        int hashcode = k.hashCode() % hashTable.length;
        Entry node = hashTable[hashcode];
        if (node == null) {
            Entry newNode = new Entry(k, v);
            hashTable[hashcode] = newNode;
        } else {
            Entry prev = node;
            while (node != null) {
                if (node.key == k) {
                    node.value = v;
                    return;
                }
                prev = node;
                node = node.next;
            }
            Entry newNode = new Entry(k, v);
            prev.next = newNode;
        }
    }

    public V get(K k) {
        int hashCode = k.hashCode() % hashTable.length;
        Entry node = hashTable[hashCode];
        while (node != null) {
            if (node.key.equals(k)) {
                return (V) node.value;
            }
            node = node.next;
        }
        return null;
    }
    public static void main(String[] args) {
        MyHashMap<Integer, String> hashMap = new MyHashMap<>();
        hashMap.put(1, "Vinit");
        hashMap.put(2, "ankit");
        hashMap.put(3, "punit");
        hashMap.put(4, "runit");
        hashMap.put(5, "Vinit");
        System.out.println(hashMap.get(10));
    }

    class Entry<K, V> {
        public K key;
        public V value;
        public Entry next;
        Entry(K k, V v) {
            key = k;
            value = v;
            next = null;
        }
    }
}
