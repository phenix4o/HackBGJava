public class ConsumerThread implements Runnable {
	private Object lock;
	private boolean flag = true;
	ConsumerThread(Object lock) {
		this.lock = lock;
	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		while (flag) {
			synchronized (lock) {
				if ("".equals(ConsumerProducerTest.data)) {
					try {
						lock.wait();
					} catch (InterruptedException e) {

					}
				} else {
					if (ConsumerProducerTest.counter < 2000000) {
						ConsumerProducerTest.counter++;
						ConsumerProducerTest.data = "";
						System.out.println("Consumer: "+ConsumerProducerTest.counter);
					}
					else{
						flag = false;
					}
					
					lock.notifyAll();
				}
			}
		}
	}
}
