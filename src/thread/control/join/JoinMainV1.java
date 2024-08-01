package thread.control.join;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class JoinMainV1 {

	public static void main(String[] args) {
		log("Start");
		Task task1 = new Task(1, 50);
		Task task2 = new Task(51, 100);
		Thread thread1 = new Thread(task1, "thread-1");
		Thread thread2 = new Thread(task2, "thread-2");

		thread1.start(); // run() 진행시에 어떤 인스턴스(task1,task2)의 메서드를 호출했는지 기억하기 위해
		// thread1 스택의 스택 frame 내부에 해당 인스턴스 참조값을 저장해놓는다
		// 메서드명 + 인스턴스 참조값
		thread2.start();

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
