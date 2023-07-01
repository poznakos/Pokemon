package org.example.lambda;

class SomeClass extends SomeParentClass implements SomeInterface, SomeOtherInterface{

    public String newMethod(){
        return "newMethod";
    }

    @Override
    public String createString() {
        return "someClassImplementation";
    }

    @Override
    public int returnInt() {
        return 0;
    }
}
