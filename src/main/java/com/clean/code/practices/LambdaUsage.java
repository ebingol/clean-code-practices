package com.clean.code.practices;

import java.math.BigDecimal;
import java.math.MathContext;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.DoublePredicate;
import java.util.function.Function;
import java.util.function.Supplier;

import com.clean.code.practices.model.Customer;

public class LambdaUsage {

    public static void main(String... args) {

	// Consumer takes R as input return is void
	Consumer<String> printItem = n -> System.out.println(n);
	Arrays.asList("fruit", "vegetables", "milk")
		.stream()
		.forEach(printItem);

	// supplier takes R, return a value
	Supplier<String> printDefaultItem = () -> "Default";
	System.out.println("Name: " + Optional.ofNullable(new Customer().getLastName()).orElseGet(printDefaultItem));

	// Function
	Function<BigDecimal, BigDecimal> interestCalculator = (
		interestRate) -> (interestRate.multiply(new BigDecimal(1000f)));
	System.out.println("Salary: " + interestCalculator.apply(BigDecimal.valueOf(3, 2)));

	// Predicate
	DoublePredicate isPrime = salary -> (salary > 10000f);
	System.out.println("IsPrime: " + isPrime.test(interestCalculator.apply(new BigDecimal(.3)).doubleValue()));
	
	List<Customer> customerList = Arrays.asList(new Customer("sijo", "sijoJr", 42, 10000f),
		new Customer("sunil", "sijoJr", 37, 15000f),
		new Customer("kumutha", "kumuthaJr", 35, 20000f), new Customer("anu", "anuJr", 30, 8000f));
	
	System.out.println("Prime Customers: ");
	customerList.stream()
	             .filter(customer -> isPrime.test(customer.getSalary()))
	             .map(customer->(customer.getName()+" "+customer.getLastName()))
	             .forEach(printItem);
	
	System.out.println("Non-Prime Customers");
	customerList.stream()
	             .filter(customer -> !isPrime.test(customer.getSalary()))	
	             .map(customer -> (customer.getName() +" "+customer.getLastName()))
	             .forEach(printItem);

    }

}
