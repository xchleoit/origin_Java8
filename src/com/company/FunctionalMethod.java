package com.company;

import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * @Author xulei
 * @Description
 * @Date 2019/12/27
 **/
public class FunctionalMethod {

    public static void main(String[] args) {
//        test();
        test1();
    }

    public static void test(){
        Consumer<String> consumer = (x)->{
            System.out.println("this is just a test");
        };
        consumer.accept("");
    }

    public static void test1(){
        Supplier<Main> supplier = ()->{return new Main();};
        supplier.get().toString();
    }
}
