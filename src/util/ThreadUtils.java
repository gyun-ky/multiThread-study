package util;

import static util.MyLogger.*;

public class ThreadUtils {

	public static void sleep(long millies) {
		try {
			Thread.sleep(millies);
		}catch (InterruptedException e) {
			log("인터럽트 발생, " + e.getMessage());
			throw new RuntimeException(e);
		}
	}
}
