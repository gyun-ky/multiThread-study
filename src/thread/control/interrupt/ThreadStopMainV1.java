package thread.control.interrupt;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

public class ThreadStopMainV1 {

	public static void main(String[] args) {
		MyTask task = new MyTask();
		Thread thread = new Thread(task, "work");
		thread.start();

		sleep(4000);
		log("작업 중단 지시 runFlag = false");
		task.runFlag = false;
	}

	static class MyTask implements Runnable {

		volatile boolean runFlag = true; // 여러 쓰레드에서 공유하는 값에 사용하는 키워드

		@Override
		public void run() {
			while(runFlag) {
				log("작업중");
				sleep(3000); // 해당 부분에서 thread가 sleep하고 있기 때문에 flag가 바뀌어도, 바로 작업 중단이 되지 않는다
			}
			log("자원 정리");
			log("자원 종료");
		}
	}
}
