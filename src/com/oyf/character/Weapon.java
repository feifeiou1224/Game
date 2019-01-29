package com.oyf.character;

/**
 * Create Time: 2019年01月08日 14:55
 * Create Author 欧阳飞
 **/

public class Weapon {

    //武器属性
    private String name;
    private int attack;
    private int speed;
    private int price;

    public Weapon() {
    }

    public Weapon(String name, int attack, int speed, int price) {
        this.name = name;
        this.attack = attack;
        this.speed = speed;
        this.price = price;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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
