package thread.start;

import static util.MyLogger.*;

public class InnerRunnableMainV1 {

	public static void main(String[] args) {
		log("main() start");

		MyInnerRunnable runnable = new MyInnerRunnable();
		Thread thread = new Thread(runnable);
		thread.start();

		log("main() end");

	}

	public static class MyInnerRunnable implements Runnable{

		@Override
		public void run() {
			log("run()");
		}
	}
}
