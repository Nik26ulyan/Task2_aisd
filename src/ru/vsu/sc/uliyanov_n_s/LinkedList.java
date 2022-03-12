package ru.vsu.sc.uliyanov_n_s;

public class LinkedList<T extends Comparable<T>> {

    public static class LinkedListException extends Exception {
        public LinkedListException(String message) {
            super(message);
        }
    }

    private class Node {
        public T data;
        public Node next;

        public Node(T value, Node next) {
            this.data = value;
            this.next = next;
        }

        public Node(T value) {
            this(value, null);
        }

        public int compareTo(Node another) {
            return data.compareTo(another.data);
        }
    }

    private Node head = null;  // first, top
    private Node tail = null;  // last
    private int size = 0;

    public void addFirst(T value) {
        head = new Node(value, head);
        if (size == 0) {
            tail = head;
        }
        size++;
    }

    public void addLast(T value) {
        if (size == 0) {
            head = tail = new Node(value);
        } else {
            tail.next = new Node(value);
            tail = tail.next;
        }
        size++;
    }

    private void checkEmptyError() throws LinkedListException {
        if (size == 0) {
            throw new LinkedListException("Empty list");
        }
    }

    private Node getNode(int index) {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        return curr;
    }

    public void removeFirst() throws LinkedListException {
        checkEmptyError();
        head = head.next;
        if (size == 1) {
            tail = null;
        }
        size--;
    }

    public void removeLast() throws LinkedListException {
        checkEmptyError();
        if (size == 1) {
            head = tail = null;
        } else {
            tail = getNode(size - 2);
            tail.next = null;
        }
        size--;
    }

    public void remove(int index) throws LinkedListException {
        checkEmptyError();
        if (index < 0 || index >= size) {
            throw new LinkedListException("Incorrect index");
        }
        if (index == 0) {
            removeFirst();
        } else {
            Node prev = getNode(index - 1);
            prev.next = prev.next.next;
            if (prev.next == null) {
                tail = prev;
            }
            size--;
        }
    }

    public int size() {
        return size;
    }

    public T get(int index) throws LinkedListException {
        checkEmptyError();
        return getNode(index).data;
    }

    public void set(T data, int index) throws LinkedListException {
        Node curr = head;
        for (int i = 0; i < index; i++) {
            curr = curr.next;
        }
        curr.data = data;
    }

    public T getFirst() throws LinkedListException {
        checkEmptyError();
        return head.data;
    }

    public T getLast() throws LinkedListException {
        checkEmptyError();
        return tail.data;
    }

    public static LinkedList<Integer> intArrayToLinkedList(int[] arr) {
        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < arr.length; i++) {
            list.addLast(arr[i]);
        }
        return list;
    }

    public static int[] intLinkedListToArray(LinkedList<Integer> list) throws LinkedListException {
        int[] arr = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            arr[i] = list.get(i);
        }
        return arr;
    }

    public void sort() throws LinkedListException {
        boolean isSorted = false;

        while (!isSorted) {
            isSorted = true;

            for (int i = 0; i < size() - 1; i++) {
                if ((get(i).compareTo(get(i + 1))) == 1) {
                    isSorted = false;

                    T temp = get(i + 1);
                    set(get(i), i + 1);
                    set(temp, i);
                }
            }
        }
    }
}
