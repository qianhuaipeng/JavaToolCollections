package com.javase.genericity.test;

import com.javase.genericity.fruit.Apple;
import com.javase.genericity.fruit.Fruit;
import com.javase.genericity.fruit.Orange;

import java.util.Arrays;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 11:56 2018/1/24
 * modified By：
 */
public class GenericReading {

    static List<Apple> apples = Arrays.asList(new Apple());
    static List<Orange> oranges = Arrays.asList(new Orange());

    static class Reader<T> {
        T readExact(List<T> list){
            return list.get(0);
        }
    }

    static void f1(){
        Reader<Fruit> fruitReader = new Reader<Fruit>();
        //fruitReader.readExact(apples);

    }

    static class CovariantReader<T> {
        T readCovariant(List<? extends T> list){
            return list.get(0);
        }
    }

    static void f2(){
        CovariantReader<Fruit> fruitReader = new CovariantReader<Fruit>();
        Fruit f = fruitReader.readCovariant(apples);
        Fruit a = fruitReader.readCovariant(oranges);
    }
}
