package test.sales.model;

public class Sale {
	
	private String identifier;
	private Long saleId;
	private SaleItem saleItem;
	private String SalesmanName;
	public Sale(String identifier, Long saleId, SaleItem saleItem, String salesmanName) {
		super();
		this.identifier = identifier;
		this.saleId = saleId;
		this.saleItem = saleItem;
		SalesmanName = salesmanName;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public Long getSaleId() {
		return saleId;
	}
	public void setSaleId(Long saleId) {
		this.saleId = saleId;
	}
	public SaleItem getSaleItem() {
		return saleItem;
	}
	public void setSaleItem(SaleItem saleItem) {
		this.saleItem = saleItem;
	}
	public String getSalesmanName() {
		return SalesmanName;
	}
	public void setSalesmanName(String salesmanName) {
		SalesmanName = salesmanName;
	}
	
	

}
