package thread.control.interrupt;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class ThreadStopMainV3 {

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
			while(!Thread.currentThread().isInterrupted()) {
				log("작업 중");
			}
			log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); // true
			// 문제점 - true로 계속 유지

			// java 내부에서 InterruptedException 터지면 interrupted를 false로 변경해주는 이유?
			// 아래 코드가 실행되기 위해서는 interrupted가 false가 되어야 sleep에서 exception 안터직고 자원 정리 가능
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
