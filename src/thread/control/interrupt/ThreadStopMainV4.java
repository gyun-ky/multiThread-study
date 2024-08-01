package thread.control.interrupt;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class ThreadStopMainV4 {

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		thread.start();

		sleep(100);
		log("작업 중단 지시 runFlag = false");
		thread.interrupt();
		log("work 쓰레드 인터럽트 상태1 = " + thread.isInterrupted()); // true
	}

	static class MyTask implements Runnable {

		@Override
		public void run() {
			while(!Thread.interrupted()) {  // 인터럽트 발생시, interrupt 상태 false로 변경
				log("작업 중");
			}
			log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); // false
			// 인터럽트 활용을 다 하고 나서는 정상적으로 돌려놓는다
			try{
				log("자원 정리");
				Thread.sleep(1000);
				log("자원 종료");
			}catch (InterruptedException e) {
				log("자원 정리 실패 - 자원 정리 중 인터럽트 발생");
			}

		}
	}
}
