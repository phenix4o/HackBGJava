public class ProducerThread implements Runnable {
	private Object lock;
	private boolean flag = true;

	ProducerThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			synchronized (lock) {
				if ("".equals(ConsumerProducerTest.data)
						&& ConsumerProducerTest.counter < 2000000) {
					ConsumerProducerTest.data = "Data was taken";
					ConsumerProducerTest.counter++;
					System.out.println("Producer: "
							+ ConsumerProducerTest.counter);
					lock.notifyAll();
				} else if (ConsumerProducerTest.counter == 2000000) {
					flag = false;
				} else {

					try {
						lock.wait();
					} catch (InterruptedException ie) {
					}
				}
			}
		}
	}
}
