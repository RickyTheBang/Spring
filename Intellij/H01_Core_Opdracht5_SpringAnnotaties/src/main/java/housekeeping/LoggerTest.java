package housekeeping;

import java.util.logging.Logger;

public class LoggerTest {
	
	private Logger logger ;
	
	public LoggerTest() {
		logger= Logger.getLogger(this.getClass().getName());
		
	}
	
	public void runClass() {
		logger.info("message Logger and the rest");
	}
	
	public static void main(String[] args) {
		LoggerTest loggerTest = new LoggerTest();
		loggerTest.runClass();
		
	}

}
