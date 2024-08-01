package thread.control;

import util.ThreadUtils;

public class CheckedExceptionMain {

	public static void main(String[] args) throws Exception {
		throw new Exception();
	}

	public static class CheckedRunnable implements Runnable {

		@Override
		public void run() {
			// throw new Exception(); run() 메서드의 부모에서 체크예외를 던지지 않으므로, 체크예외 사용 불가
			ThreadUtils.sleep(1000);
		}
	}
}
