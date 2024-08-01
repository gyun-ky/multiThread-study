package thread.control.printer;

import static util.MyLogger.*;
import static util.ThreadUtils.*;

import java.util.Queue;
import java.util.Scanner;
import java.util.concurrent.ConcurrentLinkedQueue;

public class MyPrinterV1 {

	public static void main(String[] args) {
		Printer printer = new Printer();
		Thread thread = new Thread(printer, "printer");
		thread.start();

		Scanner scanner = new Scanner(System.in);
		while(true) {
			log("프린터할 문서를 입력하세요. 종료 (q) :");
			String input = scanner.nextLine();
			if(input.equals("q")) {
				printer.work = false; // 바로 반응하지 않는다
				break;
			}

			printer.addJob(input);

		}
	}

	static class Printer implements Runnable {

		volatile boolean work = true; // 여러 쓰레드가 동시에 접근시 필요 - main과 Printer쓰레드가 접근중
		Queue<String> jobQueue = new ConcurrentLinkedQueue<>(); // 여러 쓰레드가 자료구조에 접근시 동시성을 지원하는 자료구조를 사용해야함

		@Override
		public void run() {
			while(work) {
				if(jobQueue.isEmpty()) {
					continue;
				}

				String job = jobQueue.poll();
				log("출력 시작 : " + job + ", 대기 문서: " + jobQueue);
				sleep(3000);  // 여기서 대기 상태에 빠져서 바로 작동하지 않는다
				log("출력 완료");
			}
			log("프린터 종료");
		}

		public void addJob(String input) {
			jobQueue.offer(input);
		}
	}
}
