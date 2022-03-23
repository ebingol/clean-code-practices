package com.clean.code.practices;

import java.util.Arrays;
import java.util.List;

import com.clean.code.practices.model.Customer;

public class JavaStreamUsage {

    public static void main(String... args) {

	List<Customer> customerList = Arrays.asList(new Customer("sijo", "sijoJr", 42, 10000f),
		new Customer("sunil", "sijoJr", 37, 15000f),
		new Customer("kumutha", "kumuthaJr", 35, 20000f), new Customer("anu", "anuJr", 30, 8000f));

	System.out.println("Listing string array: ");
	Arrays.asList("sijo", "sunil", "kumutha").stream()
		.map(s -> s.toUpperCase())
		.forEach(System.out::println);

	System.out.println("Listing customers calling sijoJr: ");
	customerList.stream()
		.map(customer -> customer.convertToUpper(customer))
		.filter(customer -> customer.getLastName().equalsIgnoreCase("sijoJr"))
		.forEach(System.out::println);

	System.out.println("Listing customers with salay lower than 10000: ");
	customerList.stream()
		.filter(customer -> customer.getSalary() < 10000f)
		.map(s -> s.getName())
		.forEach(System.out::println);

	System.out.println("Is there any match for Kumutha: ");
	System.out.println((customerList.stream()
		.map(customer -> customer.getName())
		.anyMatch(r -> r.contains("kumutha")) ? "yes, there is a match " : "no, there isn't any match"));

    }

}
