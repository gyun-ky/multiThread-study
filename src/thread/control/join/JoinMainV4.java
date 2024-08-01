package thread.control.join;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinMainV4 {

	public static void main(String[] args) throws InterruptedException {
		log("Start");
		Task task1 = new Task(1, 50);
		Task task2 = new Task(51, 100);
		Thread thread1 = new Thread(task1, "thread-1");

		thread1.start();

		log("join(1000) - main 쓰레드가 thread1 종료까지 특정 시간만 대기");
		thread1.join(1000); // Main은 TIMED_WAITING cf. WAITING - 무기한 대기
		log("main 쓰레드 대기 완료");

		log("task1.result = "+ task1.result);
		log("task2.result = " + task2.result);

		int sumAll = task1.result + task2.result;
		log("task1 + teask2 = " + sumAll);
		log("End");

	}

	static class Task implements Runnable {

		int startNum;
		int endNum;
		int result = 0;

		public Task(int startNum, int endNum) {
			this.startNum = startNum;
			this.endNum = endNum;
		}

		@Override
		public void run() {
			log("작업시작");
			sleep(2000);
			int sum = 0;
			for(int i=startNum; i<endNum+1; i++) {
				sum += i;
			}
			result = sum;
			log("작업 종료 result = " + result);
		}
	}
}
