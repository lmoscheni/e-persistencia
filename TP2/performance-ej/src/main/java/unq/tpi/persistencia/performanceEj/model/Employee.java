package unq.tpi.persistencia.performanceEj.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Employee {
	private int id;
	private Date birthDate;
	private String firstName;
	private String lastName;
	private Gender gender;
	private Set<Department> departments;
	private List<Department> historicDepartments;
	private Set<String> titles;
	private List<String> historicTitles;
	private List<Salary> salaries;
	private double maxSalary;
	
	public Employee() {
	}
	
	public Employee(String firstName, double amount, String title) {
		this.firstName = firstName;
		this.salaries = new ArrayList<Salary>();
		Salary salary = new Salary();
		salary.setAmount(amount);
		this.salaries.add(salary);
		this.titles = new HashSet<String>();
		titles.add(title);
	}
	
	public Employee(String firstName, double maxSalary){
		this.firstName = firstName;
		this.maxSalary = maxSalary;
	}
	
	
	
	public double getMaxSalary() {
		return maxSalary;
	}

	public void setMaxSalary(double maxSalary) {
		this.maxSalary = maxSalary;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Date getBirthDate() {
		return birthDate;
	}

	public void setBirthDate(Date birthDate) {
		this.birthDate = birthDate;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public Gender getGender() {
		return gender;
	}

	public void setGender(Gender gender) {
		this.gender = gender;
	}

	public Date getHireDate() {
		return hireDate;
	}

	public void setHireDate(Date hireDate) {
		this.hireDate = hireDate;
	}

	public Department getDepartment() {
		if(this.getDepartments().isEmpty())
			return null;
		
		return getDepartments().iterator().next();
	}

	private Date hireDate;

	public Set<Department> getDepartments() {
		return departments;
	}

	public void setDepartments(Set<Department> departments) {
		this.departments = departments;
	}

	public List<Department> getHistoricDepartments() {
		return historicDepartments;
	}

	public void setHistoricDepartments(List<Department> historicDepartments) {
		this.historicDepartments = historicDepartments;
	}
	
	public String getTitle(){
		if(this.getTitles().isEmpty())
			return null;
		
		return this.getTitles().iterator().next();
	}

	public Set<String> getTitles() {
		return titles;
	}

	public void setTitles(Set<String> titles) {
		this.titles = titles;
	}

	public List<String> getHistoricTitles() {
		return historicTitles;
	}

	public void setHistoricTitles(List<String> historicTitles) {
		this.historicTitles = historicTitles;
	}

	public List<Salary> getSalaries() {
		return salaries;
	}

	public void setSalaries(List<Salary> salaries) {
		this.salaries = salaries;
	}
	
	public Double getSalary(){
		return this.getSalaries().get(this.getSalaries().size()-1).getAmount();
	}

	public String getFullName() {
		return this.getLastName() + ", " + this.getFirstName();
	}
}
