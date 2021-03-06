package pl.sdacademy.prog.zadh;

public class QueueDemo {
    public static void main(String[] args) {
        final PriorityQueue<Integer, Integer> priorityQueue = new PriorityQueue<>(1);

        priorityQueue.offer(1,2);
        priorityQueue.offer(2);
        priorityQueue.offer(7,4);
        priorityQueue.offer(5);
        priorityQueue.offer(3,5);

        while(priorityQueue.peek() != null){
            System.out.println(priorityQueue.poll());
        }
    }
}
