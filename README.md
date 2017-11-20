# Tech Talk - Java 8 Core Language Features - Talking Points

<pre>
More changes than in the past 8 years
200+ new features

Two categories: 
1) Quality of life improvements
	Examples of quality of life improvements:
	Streamlined exception handling
	    Catch multiple exceptions in the same catch block 
	    Reduced need for nested try/catch blocks!
	    Declare a file resource in the parens of a try-statement, and java will automatically close the file stream if there is an error
2) Core language additions
	My talk today is about the following: 
	Annotations, Interfaces, Lambdas, Function references, Streams.

Annotations
	Java 8 introduces method parameter level annotations
	    @NotNull, ships with Java 8, checked at compile time just like @Override
	    You can also create your own!
    @FunctionalInterface, will be covered later

Interfaces
	Default methods
		Template pattern similar to abstract classes/methods
		Keep helper methods in context and reduce need for utility classes
	Static methods
		Limited to other static methods
	Multiple inheritance
		How? 
			Classes/interfaces can implement multiple interfaces, which can now have implementation thanks to default methods
		Java has always been against multiple inheritance! Why is this okay?
			Allows behavior inheritance
			Does not allow evil/messy state inheritance

Pull up IDE and start live coding example
	Create FunctionalInterface, assign lambda to it

@FunctionalInterface
	Requirements:
		Only 1 abstract method
			Interface methods are implicitly abstract
		Any number of default and static methods
	Java provides pre-made functional interfaces: Function, BiFunction, Predicate, Consumer, Supplier, and many more

	https://docs.oracle.com/javase/8/docs/api/java/util/function/package-summary.html

Lambdas
	Single line syntax
	Verbose syntax

Method references
	Never use a lambda as a wrapper for an existing method, use a method reference instead
	4 types of method references:
		ContainingClass::staticMethodName
		containingObject::instanceMethodName
		ContainingType::methodName
			Super cool! Assigns to a function that takes the instance on which to call the method as the first argument
			Example:
				Function<Object, String> func = Object::toString;
		ClassName::new
			Assigns well to a Supplier (i.e. factory) functional interface

	https://docs.oracle.com/javase/tutorial/java/javaOO/methodreferences.html

Lambdas & Method reference Summary
    Allow methods to be passed around as first order objects
    Compiler optimized, not simply syntactic sugar, DO NOT have the overhead of anonymous inner classes

Streams
	Used to query data structures like SQL, but with a method chaining syntax
	The stream API allows you to filter, convert, transform, visit, aggregate data, and much more
	The Java collection API has been re-written to support streams. Simply call the .stream() method to start streaming
	Arrays can also be streamed via the Arrays.stream method
	Supports threading / CPU core parallelism natively. Just call parallelStream()
	Streams can be infinite / procedurally generated
	Some stream methods are terminal, others are not
	Streams are not reusable. An exception will be thrown if you try to use a stream after a terminal method has been called
	Demo!

Optional<T>
	Introduced to minimize NPEs
	Forces programmers to think about and handle the null case
	Should not be used as parameters to a method! That's what @NotNull is for
	Should only be used in return types
	Notable methods: isPresent, get() - throws exception if null, ifPresent(Consumer), orElse(defaultValue)
	
</pre>

## License & Copyright

© Mark Hennessy

Licensed under the [MIT License](LICENSE).
