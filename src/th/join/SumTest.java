package th.join;

public class SumTest {

	public void printSum() {
		Sum sum1 = new Sum(1, 50);
		Sum sum2 = new Sum(51, 100);
		
		Thread t1 = new Thread(sum1, "T1");
		Thread t2 = new Thread(sum2, "T2");
		
		t1.start();
		t2.start();
		
		try {
			t1.join();
			t2.join();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		if (t1.isAlive() && t2.isAlive()) {
			System.out.println("T1 or T2 thread is still alive");
		} else {
			System.out.println("Main-Thread Sum : " + (sum1.getTotal() + sum2.getTotal()));
		}
	}
	
	public static void main(String[] args) {

		SumTest t = new SumTest();
		t.printSum();
	}
}
