package th.pool;

public class Worker implements Runnable {

	private String str;
	
	public Worker(String str) {
		this.str = str;
	}
	
	public void run() {
		System.out.println("Thread.currentThread().getId() : " + Thread.currentThread().getId() + ", str : "+ str);
		
		try {
			Thread.sleep(500);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
}
