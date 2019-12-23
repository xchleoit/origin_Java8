package com.company;

import java.lang.annotation.*;
import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
//	    lambdaTest();
        //重复注解
//        Arrays.asList(Filterable.class.getAnnotationsByType(Filter.class)).
//                forEach(filter -> System.out.println(filter.value()));
//        Arrays.asList(Filterables.class.getAnnotationsByType(Filter.class)).
//                forEach(str -> System.out.println(str.value()));
//        Filterable.class.getAnnotationsByType(Filtera.class);
//        Arrays.asList("1","2","3").stream().filter(str->Integer.valueOf(str)!=null).forEach(str-> System.out.println(str));
        Integer[] in = Arrays.asList("1","2","3").stream().map(s -> {return Integer.valueOf(s);}).toArray(Integer[]::new);
        String[] in1 = Arrays.asList("1","2","3").stream().toArray(String[]::new);
        Arrays.asList(in).forEach(integer -> System.out.println(integer+5));
    }

    /**
     * lambda表达式
     * 允许允许函数作为以一个方法的参数
     * 多用于匿名函数
     * */
    private static void lambdaTest(){
//        Arrays.asList(1,2,3).forEach((e)-> {
//            System.out.println(String.valueOf(e)+1);
//        });
        String[] K = {"5","1","2","3"};
        Arrays.asList(K).sort((e1, e2) -> e1.compareTo(e2));
        Arrays.asList(K).forEach(e-> System.out.println(e));
    }


    /**
     * 重复注解
     * */

    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filtera{
        String[] value();
    }

    @Retention(RetentionPolicy.RUNTIME)
    @Repeatable(Filters.class)
    public @interface Filter{
        String value();
    }
    @Target(ElementType.TYPE)
    @Retention(RetentionPolicy.RUNTIME)
    public @interface Filters{
        Filter[] value();
    }
    @Filter("Filters1")
    @Filter("Filters")
    @Filtera({"1","2"})
    public interface Filterable{}

    @Filters({@Filter("1"),@Filter("123")})
    public interface Filterables{}
}
