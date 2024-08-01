package thread.control.test;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinTestMain {

	public static void main(String[] args) throws InterruptedException {
		Thread t1 = new Thread(new MyTask(), "t1");
		Thread t2 = new Thread(new MyTask(), "t2");
		Thread t3 = new Thread(new MyTask(), "t3");

		t1.start();
		t1.join();

		t2.start();
		t2.join();

		t3.start();
		t3.join();
		log("모든 쓰레드 실행 완료");
	}

	static class MyTask implements Runnable {
		@Override
		public void run() {
			for (int i = 0; i < 3; i++) {
				log(i);
				sleep(1000);
			}
		}
	}
}
