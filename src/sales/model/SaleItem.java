package sales.model;

import java.math.BigDecimal;
import java.math.RoundingMode;

public class SaleItem {
	
	private Integer itemId;
	private BigDecimal quantity;
	private BigDecimal itemPrice;
	private BigDecimal total;
	public SaleItem(Integer itemId, BigDecimal quantity, BigDecimal itemPrice) {
		super();
		this.itemId = itemId;
		this.quantity = quantity;
		this.itemPrice = itemPrice;
		this.total = this.itemPrice.multiply(this.quantity).setScale(2, RoundingMode.HALF_EVEN);
	}
	public Integer getItemId() {
		return itemId;
	}
	public void setItemId(Integer itemId) {
		this.itemId = itemId;
	}
	public BigDecimal getQuantity() {
		return quantity;
	}
	public void setQuantity(BigDecimal quantity) {
		this.quantity = quantity;
	}
	public BigDecimal getItemPrice() {
		return itemPrice;
	}
	public void setItemPrice(BigDecimal itemPrice) {
		this.itemPrice = itemPrice;
	}
	public BigDecimal getTotal() {
		return this.total;
	}
}
