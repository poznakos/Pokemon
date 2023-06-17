package org.example.lambda;

import java.util.function.BiConsumer;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class InterfaceUsage {

    public void entryMethod() {

        /* Old attitude */
        SomeClass someClass = new SomeClass();
        toUseMethod(someClass);

        /* Anonymous class */
        toUseMethod(new SomeInterface() {
            @Override
            public String createString() {
                return "to ma byc zwrocone";
            }

            @Override
            public int returnInt() {
                return 0;
            }
        });

        /* Functional interface */
        toUseMethod(new FunctionalInterfaceWithoutArgsExample() {
            @Override
            public String someMethod() {
                return "asd";
            }
        });

        /* Lambda */
        toUseMethod(() -> "asd");
        toUseMethod(() -> {
            System.out.println("asd");
            return "asd";
        });

//        toUseMethod(variable -> {
//            return variable;
//        });

        Function<Integer, String> function = inputVariable -> inputVariable.toString();
        String functionResult = function.apply(55);

        //Function<String,void> -> Consumer<String>
        Consumer<String> consumer1 = (consumerString) -> System.out.println(consumerString);
        Consumer<String> consumer2 = consumerString -> {
            System.out.println(consumerString);
            System.out.println(consumerString);
        };
        consumer2.accept("Hello");

        //Function<void,String> -> Supplier<String>
        Supplier<String> supplier = () -> "Hello";
        String supplierResult = supplier.get();
        Supplier<Object> newObjectSupplier = () -> new Object();
        Object o1 = newObjectSupplier.get();
//        Object o2 = newObjectSupplier.get();

//        Runnable runnable = () -> {};

        //Function<String,Boolean> -> Predicate<String>
        Predicate<String> predicate = predicateString -> predicateString.isEmpty();
        boolean predicateBoolean = predicate.test("a");

        BiConsumer<Integer, String> biConsumer = (biConsumerVar1, biConsumerVar2) -> System.out.println(biConsumerVar1+biConsumerVar2);
    }

    public String toUseMethod(SomeInterface someInterface) {
        return someInterface.createString();
    }

    public String toUseMethod(FunctionalInterfaceWithoutArgsExample functionalInterfaceWithoutArgsExample) {
        return functionalInterfaceWithoutArgsExample.someMethod();
    }

//    public String toUseMethod(FunctionalInterfaceWithArgsExample functionalInterfaceWithArgsExample) {
//        return functionalInterfaceWithArgsExample.someMethod();
//    }

    class InnerClass implements SomeInterface {

        @Override
        public String createString() {
            return null;
        }

        @Override
        public int returnInt() {
            return 0;
        }
    }

}
