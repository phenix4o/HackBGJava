public class ConsumerProducerTest {

	public static int counter;
	public static Object data;

	public static void main(String[] args) throws InterruptedException {
		final Object lock = new Object();

		final Thread readerThread = new Thread(new ConsumerThread(lock));
		final Thread writerThread = new Thread(new ProducerThread(lock));
		writerThread.start();
		readerThread.start();
		writerThread.join();
		readerThread.join();
		
	}

}
