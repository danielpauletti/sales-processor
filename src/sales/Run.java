package sales;

import sales.data.DataReaderThread;

public class Run {

	public static void main(String[] args) {
		new Thread(new DataReaderThread()).start();
	}

}
