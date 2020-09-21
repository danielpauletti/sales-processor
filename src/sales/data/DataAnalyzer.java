package sales.data;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.PrintWriter;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import sales.model.Customer;
import sales.model.Sale;
import sales.model.Salesman;

public class DataAnalyzer {
	
	private HashMap<String, Salesman> salesmanList;
	private HashMap<String, Customer> customerList;
	private HashMap<Long, Sale> salesList;
	private HashMap<String, BigDecimal> sumBySalesman;
	
	private List<Map> result;
	
	private String fileName;

	public DataAnalyzer(String fileName) {
		this.salesmanList = new HashMap<>();
		this.customerList = new HashMap<>();
		this.salesList = new HashMap<>();
		this.sumBySalesman = new HashMap<>();
		this.result = new ArrayList<>();
		this.fileName = fileName;
	}
	
	public void addSalesman(Salesman salesman) {
		if(!salesmanList.containsKey((String)salesman.getName())) {
			salesmanList.put(salesman.getName(), salesman);
		}
	}
	
	public void addCustomer(Customer customer) {
		if(!customerList.containsKey((String)customer.getName())) {
			customerList.put(customer.getName(), customer);
		}
	}
	
	public void addSale(Sale sale){
		if(!salesList.containsKey(sale.getSaleId())){
			salesList.put(sale.getSaleId(), sale);
		}
		
		if(!sumBySalesman.containsKey(sale.getSalesmanName())) {
			sumBySalesman.put(sale.getSalesmanName(), sale.getSumItems());
		}else {
			sumBySalesman.computeIfPresent(sale.getSalesmanName(), (k,v)->v.add(sale.getSumItems()));
		}
	}
	
	public void analyze() {
		getCustomerAmount();
		getSalesmanAmount();
		getMostExpensiveSale();
		getGetWorstSalesman();
	}
	
	private void getCustomerAmount() {
		Map map = Map.of("Quantidade clientes",String.valueOf(customerList.size()));
		result.add(map);
	}
	
	private void getSalesmanAmount() {
		Map map = Map.of("Quantidade vendedores",String.valueOf(salesmanList.size()));
		result.add(map);
	}
	
	private void getMostExpensiveSale() {
		Sale sale = salesList.entrySet().stream().max(
				(l,s)->l.getValue().getSumItems().compareTo(
						s.getValue().getSumItems()
						)
				).get().getValue();
		Map map = Map.of("Venda mais cara", String.valueOf(sale.getSaleId()));
		result.add(map);
	}
	
	/*
	 * (Pior vendedor) == (menor soma de vandas)?
	 */
	private void getGetWorstSalesman(){
		String worst = sumBySalesman.entrySet().stream()
		.sorted(Map.Entry.<String, BigDecimal>comparingByValue())
		.findFirst().get().getKey();
		Map map = Map.of("Pior vendedor (Soma de vendas)", worst);
		result.add(map);
	}
	
	public void saveResult() {
		try {
			String path = new File(".").getCanonicalPath() + "\\data\\out";
			PrintWriter printWriter = new PrintWriter(new FileOutputStream(path+"\\"+this.fileName));
			for(Map<String,String> map : result) {
				for(Map.Entry<String,String> entry : map.entrySet()) {
					printWriter.write(entry.getKey()+" "+entry.getValue()+"\n");
				}
			}
			printWriter.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}

}
