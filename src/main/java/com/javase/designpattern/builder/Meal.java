package com.javase.designpattern.builder;

import com.javase.designpattern.builder.item.Item;

import java.util.ArrayList;
import java.util.List;

/**
 * author: alan.peng
 * description:
 * date: create in 15:20 2018/3/25
 * modified By：
 */
public class Meal {

    private List<Item> items = new ArrayList<Item>();

    public void addItem(Item item){
        items.add(item);
    }

    public float getCost(){
        float cost = 0.0f;
        for (Item item : items) {
            cost += item.price();
        }
        return cost;
    }

    public void showItems(){
        for (Item item : items) {
            System.out.println("name: " + item.name());
            System.out.print(",Packing:" + item.packing().pack());
            System.out.print(",Price: " + item.price());
        }
    }
}
