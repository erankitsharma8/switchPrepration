package codepractice.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ProducerConsumerProblem {

    private static final Queue<Integer> queue=new LinkedList<>();

    private static final int CAPACITY=10;

    private static final Runnable producer=new Runnable() {
        @Override
        public void run() {
            while(true){
                synchronized (queue){
                    while (queue.size()==CAPACITY){
                        try{
                         System.out.println("Queue is at max capacity");
                         queue.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    queue.add(10);
                    System.out.println("Added 10 in the queue");
                    queue.notifyAll();
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    };

    private static final Runnable consumer=new Runnable() {
        @Override
        public void run() {
               while (true){
                    synchronized (queue){
                    while (queue.isEmpty()){
                        try{
                            System.out.println("Queue is Empty, Waiting");
                            queue.wait();
                        }catch (InterruptedException e){
                            e.printStackTrace();
                        }
                    }
                    System.out.println("Remove from queue: "+queue.remove()+" removed");
                    queue.notifyAll();
                    try{
                        Thread.sleep(2000);
                    }catch (InterruptedException e){
                        e.printStackTrace();
                    }
                }
            }
        }
    };


    public static void main(String[] args) {
        System.out.println("Main thread started");
        Thread producerThread=new Thread(producer,"Producer");

        Thread consumerThread=new Thread(consumer,"Consumer");

        producerThread.start();
        consumerThread.start();
        System.out.println("Main thread Completed");
    }
}
