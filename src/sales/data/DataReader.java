package sales.data;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

import sales.model.Customer;
import sales.model.Sale;
import sales.model.SaleItem;
import sales.model.Salesman;
import sales.util.StringUtils;

public class DataReader {
	
	private final String DEFAULT_ERR_MSG = "Erro ao processar arquivo \n %s";
	private final String DEFAULT_SEPARATOR = "ç";
	
	private String path;
	private File file;
	private BufferedReader reader;
	private DataAnalyzer dataAnalyzer;
	private String separator = this.DEFAULT_SEPARATOR;
	
	public DataReader(String path, String separator) {
		this.path = path;
		if(StringUtils.isNotEmpty(separator)) {
			this.separator = separator;
		}
	}
	
	public void readFile() {
		try {
			this.file = new File(this.path);
		}catch(Exception e) {
			System.out.println(String.format(DEFAULT_ERR_MSG, e.getMessage()));
		}
	}
	
	public void analyzeFile() {
		try {
			if(this.file==null) {
				System.out.println(String.format(DEFAULT_ERR_MSG, "ARQUIVO NÃO ENCONTRADO!"));
			}else {
				this.dataAnalyzer = new DataAnalyzer(this.file.getName());
				this.reader = new BufferedReader(new InputStreamReader(new FileInputStream(this.file),"UTF-8"));
				String data;
				while((data = this.reader.readLine())!=null) {
					String[] dataParsed = data.split(this.separator);
					switch (dataParsed[0]) {
					case "001":
						readSalesman(dataParsed);
						break;
					case "002":
						readCustomer(dataParsed);
						break;
					case "003":
						readSale(dataParsed);
						break;
					default:
						break;
					}
				}
				this.reader.close();
			}
			
			this.dataAnalyzer.analyze();
			this.dataAnalyzer.saveResult();
			this.file.delete();
		}catch (Exception e) {
			System.out.println(String.format(DEFAULT_ERR_MSG, e.getMessage()));
		}
	}
	
	private void readSalesman(String[] data) {
		Salesman salesman = new Salesman(data[0],data[1], data[2], new BigDecimal(data[3]));
		this.dataAnalyzer.addSalesman(salesman);
	}
	
	private void readCustomer(String[] data) {
		Customer customer = new Customer(data[0],data[1],data[2],data[3]);
		this.dataAnalyzer.addCustomer(customer);
	}
	
	private void readSale(String[] data) {
		List<SaleItem> saleItems = new ArrayList<>();
		String dataParsed = data[2].replaceAll("[\\[\\]]", "");
		String[] items = dataParsed.split(",");
		for(String item : items) {
			String[] saleItemArray = item.split("-");
			SaleItem saleItem = new SaleItem(Integer.valueOf(saleItemArray[0]), new BigDecimal(saleItemArray[1]), new BigDecimal(saleItemArray[2]));
			saleItems.add(saleItem);
		}
		Sale sale = new Sale(data[0], Long.valueOf(data[1]), saleItems, data[3]);
		this.dataAnalyzer.addSale(sale);
	}
}
