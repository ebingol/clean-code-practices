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

		System.out.println("Assigning default value in empty case: " + Optional.ofNullable(optionalUsage.findById())
				.orElseGet(() -> optionalUsage.findByAccountNo().orElseThrow(NullPointerException::new)));

	}

}
