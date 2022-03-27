package ru.vsu.sc.uliyanov_n_s;

public class MyQueue<T> extends LinkedList<T> {

    public static MyQueue<Integer> arrayToMyQueue(int[] arr) {
        MyQueue<Integer> queue = new MyQueue<>();

        for (int i = 0; i < arr.length; i++) {
            queue.add(arr[i]);
        }

        return queue;
    }

    public static int[] myQueueToArray(MyQueue<Integer> queue) throws Exception {
        int[] arr = new int[queue.count()];

        for (int i = 0; i < arr.length; i++) {
            arr[i] = queue.remove();
        }

        return arr;
    }

    public void add(T value) {
        this.addLast(value);
    }


    public T remove() throws Exception {
        T result = this.element();
        this.removeFirst();
        return result;
    }


    public T element() throws Exception {
        if (this.empty()) {
            throw new Exception("Queue is empty");
        }
        return this.getFirst();
    }


    public int count() {
        return this.size();
    }


    public boolean empty() {
        return this.count() == 0;
    }

    public void addAnotherQueue(MyQueue<T> queue) throws Exception {
        int sizeOfQueue = queue.count();
        for (int i = 0; i < sizeOfQueue; i++) {
            this.add(queue.remove());
        }
    }
}
