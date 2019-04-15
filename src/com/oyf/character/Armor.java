package com.oyf.character;

/**
 * Create Time: 2019年01月08日 14:55
 * Create Author 欧阳飞
 **/

public class Armor {

    //防具属性
    private String name;
    private int defense;
    private int speed;
    private int price;

    public Armor() {
    }

    public Armor(String name){
        this.name = name;
    }

    public Armor(String name, int defense, int speed, int price) {
        this.name = name;
        this.defense = defense;
        this.speed = speed;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDefense() {
        return defense;
    }

    public void setDefense(int defense) {
        this.defense = defense;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }
}
