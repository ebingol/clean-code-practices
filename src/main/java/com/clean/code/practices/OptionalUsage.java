package com.clean.code.practices;

import java.util.Optional;

public class OptionalUsage {

    String findById() {
	return null;
    }

    String findByName() {

	System.out.println("Avoiding Null Checks");

	return "Avoiding Null Checks";

    }

    Optional<String> findByAccountNo() {

	Optional<String> empty = Optional.empty();

	return empty;
    }

    Optional<String> findByCustomerNo() {

	return Optional.of("Ezgi Bingöl");
    }

    Optional<String> sayHello(String c) {
	return Optional.of("Hello " + c);
    }

    public static void main(String... args) {

	final OptionalUsage optionalUsage = new OptionalUsage();

	Optional.ofNullable(optionalUsage.findById()).orElseGet(() -> optionalUsage.findByName());

	System.out
		.println("Assigning default value in empty case: " + optionalUsage.findByAccountNo().orElse("Default"));

	System.out.println("Executing just empty Case: "
		+ optionalUsage.findByCustomerNo().orElseGet(() -> optionalUsage.findByName()));

	optionalUsage.findByCustomerNo().ifPresent(s -> System.out.println(" printing if exists"));

	optionalUsage.findByAccountNo().ifPresentOrElse(s -> System.out.println("printingIfExists"),
		() -> System.out.println("printEmptyIfNotExists"));

	System.out.println(optionalUsage.findByCustomerNo()
		.map(c -> c + " wellcome ").orElse("default"));

	System.out.println("Nothing to print if param of 'map' is null "
		+ Optional.ofNullable(optionalUsage.findById())
		.map(c -> c + " wellcome ").orElse("empty"));

	System.out.println("Using flatMap " +
		optionalUsage.findByCustomerNo()
	                      .flatMap(c -> optionalUsage.sayHello(c)).orElse("Default"));

	System.out.println("Does it contain 'Hello': " 
	+ optionalUsage.findByCustomerNo()
		.flatMap(c -> optionalUsage.sayHello(c))
		.filter(c -> c.contains("Hello")).isPresent());

	System.out.println("Does it contain 'Hello': " 
	+ optionalUsage.findByCustomerNo()
		.flatMap(c -> optionalUsage.sayHello(c))
		.filter(c -> c.contains("Good Bye")).isPresent());

	System.out.println("Does it contain 'Hello': " 
	+ optionalUsage.findByAccountNo()
		.flatMap(c -> optionalUsage.sayHello(c))
		.filter(c -> c.contains("Hello")).isPresent());

	System.out.println("Assigning default value in empty case: " 
	+ Optional.ofNullable(optionalUsage.findById())
		.orElseGet(() -> optionalUsage.findByAccountNo().orElseThrow(NullPointerException::new)));

    }

}
