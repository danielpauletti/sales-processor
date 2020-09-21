package sales.data;

import java.io.File;

public class DataReaderThread implements Runnable {

	@Override
	public void run() {
		while (!Thread.currentThread().isInterrupted()) {
			String path;
			try {
				path = new File(".").getCanonicalPath()+"\\data\\in";
				File folder = new File(path);
				if(folder == null) {
					System.out.println("Diretório não encontrado \n"+path);
				}else {
					for(String fileName : folder.list()) {
						DataReader dataReader = new DataReader(path+"\\"+fileName, "");
						dataReader.readFile();
						dataReader.analyzeFile();
					}
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}

}
