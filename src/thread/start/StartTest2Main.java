package thread.start;

import static util.MyLogger.*;

public class StartTest2Main {

	public static void main(String[] args) {

		Thread thread = new Thread(new CounterRunnable(), "counter");
		thread.start();
	}

	public static class CounterRunnable implements Runnable {
		@Override
		public void run() {
			for(int i=1; i<= 5; i++) {
				log(i);
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}
}
