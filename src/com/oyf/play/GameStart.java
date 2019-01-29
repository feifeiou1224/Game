package com.oyf.play;

import com.oyf.character.Armor;
import com.oyf.character.Boss;
import com.oyf.character.Player;
import com.oyf.character.Weapon;

import java.util.ArrayList;
import java.util.Scanner;

/**
 * Create Time: 2019年01月08日 14:56
 * Create Author 欧阳飞
 **/

public class GameStart {

    //初始化游戏属性：武器，防具，BOSS
    static ArrayList<Weapon> weapons = new ArrayList<>();
    static ArrayList<Armor> armors = new ArrayList<>();
    static ArrayList<Boss> bosses = new ArrayList<>();
    static ArrayList<Player> players = new ArrayList<>();

    public static void initialize(){

        weapons.add(new Weapon("虚无之刃  ",+1,+3,10));
        weapons.add(new Weapon("鲜血之舞  ",+3,+0,20));
        weapons.add(new Weapon("索尔之锤  ",+5,+3,40));
        weapons.add(new Weapon("提尔的断腕",+7,+2,50));
        weapons.add(new Weapon("阿芙洛狄忒",+12,+4,80));

        armors.add(new Armor("光怪陆离-布甲",+3,+0,10));
        armors.add(new Armor("深渊恶魔-皮甲",+5,-1,15));
        armors.add(new Armor("崩塌大陆-轻甲",+6,+1,25));
        armors.add(new Armor("千年战争-重甲",+9,-1,40));
        armors.add(new Armor("七宗之罪-板甲",+10,+2,70));

        bosses.add(new Boss("河畔童谣",200,10,2,5,2));
        bosses.add(new Boss("回忆之雪",300,20,3,10,4));
        bosses.add(new Boss("荒川之怒",400,30,5,15,6));
        bosses.add(new Boss("黄泉彼岸",500,50,4,20,8));
        bosses.add(new Boss("八歧大蛇",1000,80,4,25,10));
        bosses.add(new Boss("暴风之巅",700,25,15,40,15));

    }

}
