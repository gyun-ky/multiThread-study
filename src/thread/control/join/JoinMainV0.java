package thread.control.join;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinMainV0 {

	public static void main(String[] args) {
		log("Start");
		Thread thread1 = new Thread(new Job(), "thread-1");
		Thread thread2 = new Thread(new Job(), "thread-2");

		thread1.start();
		thread2.start();
		// main쓰레드가 작업을 지시하고 결과를 받아서 처리하고 싶다면??
		log("End");
	}

	static class Job implements Runnable {
		@Override
		public void run() {
			log("작업 시작");
			sleep(1000); // TIMED_WAITING 상태
			log("작업 완료");
		}
	}
}
