package slf;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class Main {

	private static Logger log = LoggerFactory.getLogger(Main.class);

	public static void main(String[] args) {
//		File file = new File("C:\\Users\\anant.navagale\\logs");
//		file.mkdir();
//		file.setWritable(true);
		while (true){
		log.debug("This is debug message");
		log.error("This is error message");
		log.trace("This is trace message");
		log.warn("This is warn message");
		log.info("This is info message");
		try {
			Thread.sleep(2000);
		} catch (Exception e) {

		}
		}
	}
}