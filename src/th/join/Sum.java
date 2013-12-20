package th.join;

public class Sum implements Runnable {

	private int min;
	private int max;
	private int total;
	
	public Sum(int min, int max) {
		this.min = min;
		this.max = max;
	}
	
	public void run() {
		for (int i = min; i <= max; i++) {
			this.total += i;
			
//			try {
//				Thread.sleep(10);
//			} catch (InterruptedException e) {
//				e.printStackTrace();
//			}
//			System.out.println("This thread name : " + Thread.currentThread().getName()  + ", total : " + total + ", i : " + i );
			System.out.println("This thread name : " + Thread.currentThread().getName());
		}
			
	}

	public int getTotal() {
		return this.total;
	}
}
