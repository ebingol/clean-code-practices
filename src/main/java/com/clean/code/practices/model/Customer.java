package com.clean.code.practices.model;

public class Customer {
	

		private String name;
		private String lastName;
		private int age;
		private double salary;

		public Customer(String name, String lastName, int age, double salary) {

			this.name = name;
			this.lastName = lastName;
			this.age = age;
			this.salary = salary;
		}
		
		public Customer(Customer customer) {

			this.name = customer.getName();
			this.lastName = customer.getLastName();
			this.age = customer.getAge();
			this.salary = customer.getSalary();
		}
		
		public Customer() {
		    // TODO Auto-generated constructor stub
		}

		public Customer convertToUpper(Customer customer) {
			Customer tempCustomer = new Customer(customer);
			tempCustomer.setLastName(tempCustomer.getLastName().toUpperCase());
			return tempCustomer;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getLastName() {
			return lastName;
		}

		public void setLastName(String lastName) {
			this.lastName = lastName;
		}

		public int getAge() {
			return age;
		}

		public void setAge(int age) {
			this.age = age;
		}

		public double getSalary() {
			return salary;
		}

		public void setSalary(double salary) {
			this.salary = salary;
		}

		@Override
		public String toString() {
			return "Customer [name=" + name + ", lastName=" + lastName + ", age=" + age + ", salary=" + salary + "]";
		}
		
		


}
