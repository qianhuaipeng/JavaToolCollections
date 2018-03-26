package com.javase.designpattern.builder;

import com.javase.designpattern.builder.item.ChickenBurger;
import com.javase.designpattern.builder.item.Coke;
import com.javase.designpattern.builder.item.PePsi;
import com.javase.designpattern.builder.item.VegBurger;

/**
 * author: alan.peng
 * description:
 * date: create in 15:25 2018/3/25
 * modified By：
 */
public class MealBuilder {

    public Meal prepareVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new VegBurger());
        meal.addItem(new Coke());
        return meal;
    }

    public Meal prepareNonVegMeal(){
        Meal meal = new Meal();
        meal.addItem(new ChickenBurger());
        meal.addItem(new PePsi());
        return meal;
    }
}
