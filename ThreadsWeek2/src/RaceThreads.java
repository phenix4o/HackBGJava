import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.atomic.AtomicInteger;

public class RaceThreads {
	static int counter;
	public int COUNT_MAX;
	private Object lock2 = new Object();
	
	public synchronized static void increment() {
		// counter++;
	}

	public class CountThread extends Thread {
		public void run() {
			
			for (int i = 0; i < COUNT_MAX; i++) {
				// synchronized (lock2) {
				// increment();

				// }
			}
			synchronized (lock2) {
				while (counter < 2000000) {
					counter++;
				}
			}
		}
	}

	public static void main(String[] args) {

		long time = System.currentTimeMillis();
		RaceThreads r = new RaceThreads(1000000);
		System.out.println(System.currentTimeMillis() - time);

	}

	public RaceThreads(int max) {
		this.COUNT_MAX = max;
		Thread counter1 = new CountThread();
		Thread counter2 = new CountThread();
		// this.counter = new AtomicInteger();
		counter = 0;
		counter1.start();
		counter2.start();
		
		try {
			counter1.join();
			counter2.join();
		} catch (InterruptedException ie) {
			return;
		}

		System.out.println("COUNT_MAX = " + max + "\ncounter = " + counter);

	}
}
