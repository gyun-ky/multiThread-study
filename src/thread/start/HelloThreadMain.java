package thread.start;

public class HelloThreadMain {

	public static void main(String[] args) {
		System.out.println(Thread.currentThread().getName() + ": main() start");

		HelloThread helloThread = new HelloThread();
		System.out.println(Thread.currentThread().getName() + ": start() 호출전");
		helloThread.start(); // 절대 run을 호출해서는 안됨
		System.out.println(Thread.currentThread().getName() + ": start() 호출후");

		System.out.println(Thread.currentThread().getName() + ": main() end");

	}
}
