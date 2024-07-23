package thread.start;

import static util.MyLogger.*;

public class StartTest1Main {

	public static void main(String[] args) {

		CounterThread counterThread = new CounterThread();
		counterThread.start();

	}

	public static class CounterThread extends Thread{

		@Override
		public void run() {
			for(int i=1; i<=5; i++) {
				try {
					log(i);
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					throw new RuntimeException(e);
				}
			}
		}
	}

}
