package com.oyf.play;

import com.oyf.character.Armor;
import com.oyf.character.Boss;
import com.oyf.character.Player;
import com.oyf.character.Weapon;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.Scanner;

import static com.oyf.play.FirstMenu.oos;
import static com.oyf.play.FirstMenu.playerData;
import static com.oyf.play.GameStart.*;

/**
 * Create Time: 2019年01月08日 15:58
 * Create Author 欧阳飞
 **/

public class SecondMenu {

    static int chooseBoss = -1;

    public static void menu(){
        System.out.println("\033[35;4m" +"  游戏界面  " + "\033[0m");
        System.out.println("1、购买武器");
        System.out.println("2、购买防具");
        System.out.println("3、挑战BOSS");
        System.out.println("4、我的英雄");
        System.out.println("5、退出登录");
        while (true){
            System.out.print("请选择：");
            choose();
        }
    }

    public static void choose(){
        switch (new Scanner(System.in).next()){
            case "1":
                WeaponMenu();
                break;
            case "2":
                ArmorMenu();
                break;
            case "3":
                BossMenu();
                break;
            case "4":
                myHero();
                break;
            case "5":
                outLogin();
                break;
            default:
                System.out.println("选择错误！");
                break;
        }
    }

    public static void WeaponMenu(){
        System.out.println(" \t名   称\t\t攻击\t速度\t价格");
        int count = 1;
        for(Weapon weapon : weapons){
            System.out.println(count+"\t"+weapon.getName()+"\t"+weapon.getAttack()+"\t"+weapon.getSpeed()+"\t"+weapon.getPrice());
            count++;
        }
        System.out.println("输入0回上一界面..");
        buyWeapon();
    }

    public static void buyWeapon(){
        System.out.print("请选择：");
        int choice = new Scanner(System.in).nextInt();
        if(choice>0 && choice<=weapons.size()) {
            if (players.get(FirstMenu.count).getMoney()>=weapons.get(choice-1).getPrice()) {
                Player player = players.get(FirstMenu.count);
                Weapon weapon = weapons.get(choice-1);
                player.setAttack(player.getAttack()+weapon.getAttack());
                player.setSpeed(player.getSpeed()+weapon.getSpeed());
                player.setMoney(player.getMoney()-weapon.getPrice());
                System.out.println("购买成功！你变得更强了！！");
                menu();
            }else {
                System.out.println("你没有钱...");
                WeaponMenu();
            }
        }else {
            System.out.println("你选择了空气");
            menu();
        }
    }


    public static void ArmorMenu(){
        System.out.println(" \t名   称\t\t\t防御\t速度\t价格");
        int count = 1;
        for(Armor armor : armors) {
            System.out.println(count + "\t" + armor.getName() + "\t" + armor.getDefense() + "\t" + armor.getSpeed() + "\t" + armor.getPrice());
            count++;
        }
        System.out.println("输入0回上一界面..");
        buyArmor();
    }

    public static void buyArmor(){
        System.out.print("请选择：");
        int choice = new Scanner(System.in).nextInt();
        if (choice>0 && choice<=armors.size()){
            if (players.get(FirstMenu.count).getMoney()>=armors.get(choice-1).getPrice()) {
                Player player = players.get(FirstMenu.count);
                Armor armor = armors.get(choice-1);
                player.setDefense(player.getDefense()+armor.getDefense());
                player.setSpeed(player.getSpeed()+armor.getSpeed());
                player.setMoney(player.getMoney()-armor.getPrice());
                System.out.println("购买成功！你变得更强了！！");
                menu();
            }else {
                System.out.println("你没有钱...");
                ArmorMenu();
            }
        }else {
            System.out.println("你选择了空气");
            menu();
        }
        }



    public static void BossMenu(){
        System.out.println(" \t副本名称\t\t攻击\t速度\t血量");
        int count = 1;
        for(Boss boss : bosses) {
            System.out.println(count + "\t" + boss.getName() + "\t\t" + boss.getAttack() + "\t" + boss.getSpeed() + "\t" + boss.getHp());
            count++;
        }
        System.out.println("输入0回上一界面..");
        challengeBoss();
    }

    public static void challengeBoss(){
        System.out.print("请选择：");
        int choice = new Scanner(System.in).nextInt();
        if(choice>0 && choice<=bosses.size()){
            chooseBoss = choice-1;
            Fight.fight();
        }else {
            System.out.println("你选择了空气");
            menu();
        }

    }

    public static void myHero(){
        System.out.println("名   称\t血量\t\t攻击\t\t防御\t\t速度\t\t金币\t\t等级\t\t 经 验");
        Player p = players.get(FirstMenu.count);
        System.out.println(p.getName()+"\t\t"+p.getHp()+"\t\t"+p.getAttack()+"\t\t"+p.getDefense()+"\t\t"+p.getSpeed()+"\t\t"+p.getMoney()+"\t\t"+p.getLevel()+"\t\t"+p.getExp()+"/50");
    }

    //退出登录功能 退出时对玩家数据进行保存
    public static void outLogin(){
        try {
            FirstMenu.oos = new ObjectOutputStream(new FileOutputStream(playerData));
            oos.writeObject(players);
            oos.close();

            System.out.println("退出成功！游戏数据已保存！");
            FirstMenu.loginFlag = false;
            FirstMenu.menu();

        } catch (IOException e) {
            System.err.println("退出失败！");
            menu();
        }

    }
}
