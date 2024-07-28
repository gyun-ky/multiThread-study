package thread.start.test;

import static util.MyLogger.*;

public class StartTest4Main {

	public static void main(String[] args) {

		Thread thread = new Thread(new PrintWork("A", 1000), "Thread-A");
		thread.start();
		Thread thread2 = new Thread(new PrintWork("B", 500), "Thread-B");
		thread2.start();

	}

	public static class PrintWork implements Runnable {

		private final String name;
		private final int intervalTime;

		public PrintWork(String name, int intervalTime) {
			this.name = name;
			this.intervalTime = intervalTime;
		}

		@Override
		public void run() {
			while(true) {
				log(name);
				try {
					Thread.sleep(intervalTime);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}


}
