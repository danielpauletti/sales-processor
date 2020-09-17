package test.sales.model;

import java.math.BigDecimal;

public class Salesman {
	
	private String identifier;
	private String cpf;
	private String name;
	private BigDecimal salary;
	
	public Salesman(String identifier, String cpf, String name, BigDecimal salary) {
		super();
		this.identifier = identifier;
		this.cpf = cpf;
		this.name = name;
		this.salary = salary;
	}

	public String getIdentifier() {
		return identifier;
	}

	public void setIdentifier(String identifier) {
		this.identifier = identifier;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public BigDecimal getSalary() {
		return salary;
	}

	public void setSalary(BigDecimal salary) {
		this.salary = salary;
	}

}
