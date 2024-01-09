package DataStructures;

import java.util.Arrays;
import java.util.Random;

public class Heap {
    private int[] array;

    public static void main(String[] args) {
        Heap heap = new Heap(10);
        heap.setArray(generateRandomNumArray(10));
        System.out.printf("Before heapify: %s\n", heap);
        heap.maxHeapify();
        System.out.printf("After heapify: %s\n", heap);

    }

    public Heap(int size) {
        this.array = new int[size];
    }

    private void maxHeapify() {
        for (int i = array.length - 1; i >= 0; i--) {
            int parentIndex = getParentIndex(i);
            if (parentIndex < 0) { // Done once at root element
                return;
            }
            //TODO: Check children to see if they are greater than the current element
            if (array[i] > array[parentIndex]) {
                System.out.printf("Swapping %d with %d\n", array[i], array[parentIndex]);
                // Swap to maintain heap property
                swap(i, parentIndex);
                System.out.printf("%s\n", this);
            }
        }
    }

    private int getParentIndex(int currentIndex) {
        if (currentIndex % 2 == 0) {
            return (currentIndex / 2) - 1;
        } else {
            return currentIndex / 2;
        }
    }

    private void swap(int currentIndex, int newIndex) {
        int temp = array[newIndex];
        array[newIndex] = array[currentIndex];
        array[currentIndex] = temp;
    }

    @Override
    public String toString() {
        return String.format("%s", Arrays.toString(array));
    }

    /**
     * Helper method for filling a new heap with random elements
     * @param newArray Array of randomly generated elements
     */
    private void setArray(int[] newArray) {
        this.array = newArray;
    }

    /**
     * Inserts random numbers into the array. Used for testing
     * @param size The desired size of the heap
     * @return Array of randomly generated elements
     */
    private static int[] generateRandomNumArray(int size) {
        int[] array = new int[size];
        Random r = new Random();

        for (int i = 0; i < size; i++) {
            array[i] = Math.abs(r.nextInt() % 100);
        }
        return array;
    }
}
