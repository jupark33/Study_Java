package th;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class ThreadPoolExam {

	public static void main(String args[]) {
		ExecutorService service = Executors.newFixedThreadPool(10);
		
		for (int i = 0; i < 100; i++)
			service.submit(new Task(i));
	}
}

final class Task implements Runnable {

	private int id;

	public Task(int id) {
		this.id = id;
	}

	public void run() {
		System.out.println("Task id : " + id + ", name : " + Thread.currentThread().getName());
	}
}
