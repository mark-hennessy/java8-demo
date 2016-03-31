package com.mhennessy.java8.demo.lambdas;

import java.util.Comparator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

public class LambdaTest {
    
    public static void main(String[] args) {
        // Lambda example
        BiFunction<Integer, Integer, Integer> add = (a, b) -> a + b;
                
        // This only works because Comparator is a @FunctionalInterface
        // Single line syntax
        Comparator<Integer> comparator = (a, b) -> a < b ? -1 : 1;
        
        // Verbose syntax
        Comparator<Integer> comparatorVerbose = (a, b) -> { 
            if (a < b) {
                return -1;
            }
            else {
                return 1;
            }
        };

        // ClassName::new
        Supplier<LambdaTest> noArgLambdaTestSupplier = LambdaTest::new;
        Function<String, LambdaTest> lambdaTestSupplier = LambdaTest::new;
        
        // containingObject::instanceMethodName
        LambdaTest testInstance = lambdaTestSupplier.apply("R2D2");
        Consumer<String> printReference = testInstance::print;
        
        // ContainingClass::staticMethodName
        BiFunction<Integer, Integer, Integer> addReference = LambdaTest::add;
        
        // ContainingType::methodName
        // Reference to an instance method of an arbitrary object of a particular type
        BiConsumer<LambdaTest, String> arbitraryPrintReference = LambdaTest::print;
        arbitraryPrintReference.accept(testInstance, "Hello World!");
    }
    
    private String id;

    public LambdaTest() {
        id = "Default";
    }
    
    public LambdaTest(String id) {
        this.id = id;
    }
    
    public static int add(int a, int b) {
        return a + b;
    }
    
    public void print(String message) {
        System.out.println(id + " " + message);
    }
}
