package thread.control.interrupt;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class ThreadStopMainV2 {

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		thread.start();

		sleep(4000);
		log("작업 중단 지시 runFlag = false");
		thread.interrupt();
		log("work 쓰레드 인터럽트 상태1 = " + thread.isInterrupted()); // true
	}

	static class MyTask implements Runnable {

		@Override
		public void run() {
			try{
				while(true) {
					log("작업중");
					Thread.sleep(3000); // interrupted == true이면 exception 발생 -> 이때만 interrupt 체크? 아쉬움
				}
			} catch (InterruptedException e) {
				log("work 스레드 인터럽트 상태2 = " + Thread.currentThread().isInterrupted()); // false
				log("interrupt message=" + e.getMessage());
				log("state= " + Thread.currentThread().getState());
			}

			log("자원 정리");
			log("자원 종료");
		}
	}
}
