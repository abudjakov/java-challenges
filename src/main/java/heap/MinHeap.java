package heap;

import java.util.Arrays;
import java.util.NoSuchElementException;

/*

Array Form: [ 5, 7, 6, 10, 15, 17, 12 ]
  Complete Binary Tree Form:
                   5
              /         \
          7               6
      /     \          /     \
    10      15        17      12
  Mappings:
    Parent -> (childIndex - 1) / 2
    Left Child -> 2 * parentIndex + 1
    Right Child -> 2 * parentIndex + 2

* */
public class MinHeap {

    private int capacity = 5;
    private int heap[];
    private int size;

    public MinHeap() {
        heap = new int[capacity];
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public int peek() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty");
        }

        return heap[0];
    }

    public int remove() {
        if (isEmpty()) {
            throw new NoSuchElementException("Heap is empty.");
        }

        int min = heap[0];
        heap[0] = heap[size - 1];
        size--;

        /* Restore the heap by bubbling down the top element */
        heapifyDown();

        return min;
    }

    public void add(int itemToAdd) {
        ensureExtraCapacity();

        heap[size] = itemToAdd;
        size++;

        /* Restore the heap by bubbling up the element we just put in the last position */
        siftUp();
    }

    // If heap is full then double capacity
    private void ensureExtraCapacity() {
        if (size == capacity) {
            heap = Arrays.copyOf(heap, capacity * 2);
            capacity *= 2;
        }
    }

    private void heapifyDown() {
        int index = 0;

        while (hasLeftChild(index)) {

            int smallerChildIndex = getLeftChildIndex(index);
            if (hasRightChild(index) && rightChild(index) < leftChild(index)) {
                smallerChildIndex = getRightChildIndex(index);
            }

            if (heap[index] < heap[smallerChildIndex]) {
                break;
            } else {
                swap(index, smallerChildIndex);
            }

            index = smallerChildIndex;
        }
    }

    private void siftUp() {
      /*
        We will bubble up the item just inserted into to the "bottom"
        of the heap after an insert operation. It will be at the last index
        so index 'size' - 1
      */
        int index = size - 1;

      /*
        While the item has a parent and the item beats its parent in
        smallness, bubble this item up.
      */
        while (hasParent(index) && heap[index] < parent(index)) {
            swap(getParentIndex(index), index);
            index = getParentIndex(index);
        }
    }

    private void swap(int indexOne, int indexTwo) {
        int temp = heap[indexOne];
        heap[indexOne] = heap[indexTwo];
        heap[indexTwo] = temp;
    }

    private int getLeftChildIndex(int parentIndex) {
        return 2 * parentIndex + 1;
    }

    private int getRightChildIndex(int parentIndex) {
        return 2 * parentIndex + 2;
    }

    private int getParentIndex(int childIndex) {
        return (childIndex - 1) / 2;
    }

    private boolean hasLeftChild(int index) {
        return getLeftChildIndex(index) < size;
    }

    private boolean hasRightChild(int index) {
        return getRightChildIndex(index) < size;
    }

    private boolean hasParent(int index) {
        return index != 0 && getParentIndex(index) >= 0;
    }

    private int leftChild(int index) {
        return heap[getLeftChildIndex(index)];
    }

    private int rightChild(int index) {
        return heap[getRightChildIndex(index)];
    }

    private int parent(int index) {
        return heap[getParentIndex(index)];
    }
    public static void main(String[] args) {
        int[] items = new int[]{0, 1, 3, 2, -4, 9, 1, 2};

    }

}
