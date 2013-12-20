package th.pool;

import java.util.concurrent.Executor;
import java.util.concurrent.Executors;

public class ConsumerThread implements Runnable {

	private Thread thread;
	private int cnt = 0;
	
//	private static final Executor exec = Executors.newCachedThreadPool();
	private static final Executor exec = Executors.newFixedThreadPool(10);
	
	public void start() {
		thread = new Thread(this);
		thread.start();
	}
	
	public void run() {
		while (true) {
			if (cnt > 30) break;
			exec.execute(new Worker("Worker"));
			cnt++;
		}
	}

	public static void main(String[] args) {
		ConsumerThread con = new ConsumerThread();
		con.start();
	}
}
