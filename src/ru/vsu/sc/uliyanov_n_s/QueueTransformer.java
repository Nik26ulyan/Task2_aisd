package ru.vsu.sc.uliyanov_n_s;

import ru.vsu.sc.uliyanov_n_s.utils.ArrayListQueueUtils;

import java.util.LinkedList;
import java.util.Queue;

public class QueueTransformer {

    public static void transformMyQueue(MyQueue<Integer> queue) throws Exception {
        MyQueue<Integer> negativeNumbers = new MyQueue<>();
        MyQueue<Integer> positiveNumbers = new MyQueue<>();
        int zeroElementCounter = 0;
        int sizeOfQueue = queue.count();

        for (int i = 0; i < sizeOfQueue; i++) {
            int value = queue.remove();

            if (value < 0) {
                negativeNumbers.add(value);
            } else if (value > 0) {
                positiveNumbers.add(value);
            } else {
                zeroElementCounter++;
            }
        }

        queue.addAnotherQueue(negativeNumbers);

        for (int i = 0; i < zeroElementCounter; i++) {
            queue.add(0);
        }

        queue.addAnotherQueue(positiveNumbers);
    }

    public static void transformQueue(Queue<Integer> queue) {
        Queue<Integer> negativeNumbers = new LinkedList<>();
        Queue<Integer> positiveNumbers = new LinkedList<>();
        int zeroElementCounter = 0;
        int sizeOfQueue = queue.size();

        for (int i = 0; i < sizeOfQueue; i++) {
            int value = queue.remove();

            if (value < 0) {
                negativeNumbers.add(value);
            } else if (value > 0) {
                positiveNumbers.add(value);
            } else {
                zeroElementCounter++;
            }
        }

        ArrayListQueueUtils.addAnotherQueue(queue, negativeNumbers);

        for (int i = 0; i < zeroElementCounter; i++) {
            queue.add(0);
        }

        ArrayListQueueUtils.addAnotherQueue(queue, positiveNumbers);
    }
}
