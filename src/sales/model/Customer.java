package sales.model;

public class Customer {
	
	private String identifier;
	private String cnpj;
	private String name;
	private String businessArea;
	public Customer(String identifier, String cnpj, String name, String businessArea) {
		super();
		this.identifier = identifier;
		this.cnpj = cnpj;
		this.name = name;
		this.businessArea = businessArea;
	}
	public String getIdentifier() {
		return identifier;
	}
	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}
	public String getCnpj() {
		return cnpj;
	}
	public void setCnpj(String cnpj) {
		this.cnpj = cnpj;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getBusinessArea() {
		return businessArea;
	}
	public void setBusinessArea(String businessArea) {
		this.businessArea = businessArea;
	}

}
