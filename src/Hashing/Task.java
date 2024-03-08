package Hashing;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;

class HashTable {
    private final int size;
    private final ArrayList<LinkedList<Integer>> table;
    public HashTable(int size) {
        this.size = size;
        this.table = new ArrayList<>(size);
        for (int i = 0; i < size; i++) {
            table.add(new LinkedList<>());
        }
    }

    private int hashFunction(int key) {
        return key % size;
    }

    public void insert(int value) {
        int index = hashFunction(value);
        table.get(index).add(value);
    }

    public void sortChains() {
        for (LinkedList<Integer> chain : table) {
            Collections.sort(chain);
        }
    }

    public void display() {
        for (int i = 0; i < size; i++) {
            System.out.print("Index " + i + ": ");
            for (int value : table.get(i)) {
                System.out.print(value + " ");
            }
            System.out.println();
        }
    }
}

public class Task {
    public static void main(String[] args) {
        HashTable hashTable = new HashTable(10);

        int[] values = {3, 2, 9, 6,42, 11, 13, 7, 12, 23, 22, 26};

        for (int value : values) {
            hashTable.insert(value);
        }

        System.out.println("Before Sorting:");
        hashTable.display();

        hashTable.sortChains();

        System.out.println("\nAfter Sorting:");
        hashTable.display();
    }
}

