package com.oyf.character;

/**
 * Create Time: 2019年01月08日 14:49
 * Create Author 欧阳飞
 **/

public class Boss {

    //BOSS的属性
    private String name;
    private int hp;
    private int attack;
    private int speed;
    private int successExp;
    private int drawExp;

    public Boss() {
    }

    public Boss(String name, int hp, int attack, int speed, int successExp, int drawExp) {
        this.name = name;
        this.hp = hp;
        this.attack = attack;
        this.speed = speed;
        this.successExp = successExp;
        this.drawExp = drawExp;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
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

    public int getSuccessExp() {
        return successExp;
    }

    public void setSuccessExp(int successExp) {
        this.successExp = successExp;
    }

    public int getDrawExp() {
        return drawExp;
    }

    public void setDrawExp(int drawExp) {
        this.drawExp = drawExp;
    }


}