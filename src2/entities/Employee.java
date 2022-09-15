package entities;

public class Employee {
	
	private String name;
	private String email;
	private Double salary;
	
	public Employee() {
		
	}
	public Employee(String name, String email, Double salary) {
		this.email = email;
		this.name = name;
		this.salary = salary;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public Double getSalary() {
		return salary;
	}
}