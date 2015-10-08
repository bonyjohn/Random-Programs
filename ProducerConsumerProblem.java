package test;

/* This is a java implementatio of producer consumer problem */

import java.util.ArrayList;
import java.util.List;

public class ProducerConsumerProblem {
	final static int size = 100000;
	static List<Integer> v = new ArrayList<Integer>(size);

	public static void main(String a[]){
		Thread pro = new Thread(new Producer(v, size));
		Thread con = new Thread(new Consumer(v, size));
		pro.start();
		con.start();
	}
}

class Producer implements Runnable {
	List<Integer> v;
	int size = 0;
	Producer(List<Integer> v,int size){
		this.v = v;
		this.size = size;
	}
	public void run() {
		synchronized (v) {
			for(;;){
				if(v.size() == size){
					try {
						System.out.println("Producer Going to Wait");
						v.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				v.add(0);
				v.notify();
			}
		}
	}
}

class Consumer implements Runnable {
	List<Integer> v;
	int size = 0;

	Consumer(List<Integer> v,int size){
		this.v = v;
		this.size = size;
	}

	public void run() {
		synchronized (v) {
			for(;;){
				if(v.size() == 0){
					try {
						System.out.println("Consumer Going to Wait");
						v.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
				v.remove(0);
				v.notify();
			}
		}
	}
}
