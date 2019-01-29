package com.oyf.character;

import java.io.Serializable;
import java.util.Date;

/**
 * Create Time: 2019年01月08日 14:49
 * Create Author 欧阳飞
 **/

public class Player implements Serializable {

    //玩家账号
    private String username;
    private String password;
    private String name;

    //玩家角色属性
    private int level;
    private int money;
    private int hp;
    private int exp;
    private int attack;
    private int defense;
    private int speed;

    //按照固定格式记录登录时间
    private String loginDate;

    //玩家角色初始属性
    public Player(){
        this.level = 1;
        this.money = 0;
        this.hp = 100;
        this.exp = 0;
        this.attack = 4;
        this.defense = 3;
        this.speed = 6;
    }

    public Player(String username, String password) {
        this.username = username;
        this.password = password;
        this.level = 1;
        this.money = 0;
        this.hp = 100;
        this.exp = 0;
        this.attack = 4;
        this.defense = 3;
        this.speed = 6;

    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getHp() {
        return hp;
    }

    public void setHp(int hp) {
        this.hp = hp;
    }

    public int getExp() {
        return exp;
    }

    public void setExp(int exp) {
        this.exp = exp;
    }

    public int getAttack() {
        return attack;
    }

    public void setAttack(int attack) {
        this.attack = attack;
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getMoney() {
        return money;
    }

    public void setMoney(int money) {
        this.money = money;
    }

    public int getLevel() {
        return level;
    }

    public void setLevel(int level) {
        this.level = level;
    }

    public String getLoginDate() {
        return loginDate;
    }

    public void setLoginDate(String loginDate) {
        this.loginDate = loginDate;
    }
}
