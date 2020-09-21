package sales.model;

import java.math.BigDecimal;
import java.util.List;

public class Sale {
	
	private String identifier;
	private Long saleId;
	private List<SaleItem> saleItems;
	private String salesmanName;
	private BigDecimal sumItems;
	
	public Sale(String identifier, Long saleId, List<SaleItem> saleItems, String salesmanName) {
		super();
		this.identifier = identifier;
		this.saleId = saleId;
		this.saleItems = saleItems;
		this.salesmanName = salesmanName;
		this.sumItems = saleItems.stream().map(SaleItem::getTotal).reduce(BigDecimal.ZERO, BigDecimal::add);
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
	public List<SaleItem> getSaleItems() {
		return saleItems;
	}
	public void setSaleItems(List<SaleItem> saleItems) {
		this.saleItems = saleItems;
	}
	public String getSalesmanName() {
		return salesmanName;
	}
	public void setSalesmanName(String salesmanName) {
		this.salesmanName = salesmanName;
	}
	public BigDecimal getSumItems() {
		return sumItems;
	}

}
