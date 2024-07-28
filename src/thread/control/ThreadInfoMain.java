package thread.control;

import static util.MyLogger.*;

import thread.start.HelloRunnable;

public class ThreadInfoMain {

	public static void main(String[] args) {

		Thread mainThread = Thread.currentThread();
		log("mainThread = " + mainThread);
		log("mainThread.threadId() = " + mainThread.threadId());
		log("mainThread.getName() = " + mainThread.getName());
		log("mainThread.getPriority() = " + mainThread.getPriority()); // 우선순위가 높을수록 많이 실행됨
		log("mainThread.getThreadGroup() = " + mainThread.getThreadGroup());
		log("mainThread.getState() = " + mainThread.getState());

		Thread myThread = new Thread(new HelloRunnable(), "myThread");
		log("myThread = " + myThread);
		log("myThread.threadId() = " + myThread.threadId());
		log("myThread.getName() = " + myThread.getName());
		log("myThread.getPriority() = " + myThread.getPriority()); // 우선순위가 높을수록 많이 실행됨
		log("myThread.getThreadGroup() = " + myThread.getThreadGroup());
		log("myThread.getState() = " + myThread.getState());

	}
}
