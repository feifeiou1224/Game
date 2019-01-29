package com.oyf.play;

import com.oyf.character.Player;

import java.io.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.Scanner;

import static com.oyf.play.GameStart.players;

/**
 * Create Time: 2019年01月08日 15:58
 * Create Author 欧阳飞
 **/

public class FirstMenu {

    static File playerData = new File("F:\\ideaWorkspace\\Game\\src\\com\\oyf\\dataSave\\playerData.txt");
    static int count = -1;
    static boolean loginFlag = false;
    static ObjectOutputStream oos;
    static ObjectInputStream ois;

    public static void menu(){
        System.out.println("----------------");
        System.out.println("\033[34;4m" +"欢迎来到本游戏"+ "\033[0m");
        System.out.println("1、注册");
        System.out.println("2、登录");
        System.out.println("3、退出");
        System.out.println("----------------");
        while (true) {
            choose();
        }
    }

    public static void choose(){
        System.out.print("请选择：");
        switch (new Scanner(System.in).next()){
            case "1":
                register();
                break;
            case "2":
                login();
                break;
            case "3":
                System.exit(0);
                break;
            default:
                System.out.println("选择错误！");
                break;
        }
    }

    public static void register(){

        System.out.print("请输入用户名：");
        String username = new Scanner(System.in).next();
        System.out.print("请输入密码：");
        String password = new Scanner(System.in).next();
        Player player = new Player(username, password);

        if (playerData.length() == 0) {
            try {
                players.add(player);
                oos = new ObjectOutputStream(new FileOutputStream(playerData));
                oos.writeObject(players);
                oos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }else {
            try {
                ois = new ObjectInputStream(new FileInputStream(playerData));
                players = (ArrayList<Player>)ois.readObject();

                for (int i = 0; i < players.size(); i++) {
                    if(username.equals(players.get(i).getUsername())){
                        System.out.println("账号已存在!");
                        menu();
                    }
                }

                players.add(player);
                oos = new ObjectOutputStream(new FileOutputStream(playerData));
                oos.writeObject(players);
                oos.close();
                ois.close();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
        menu();
    }

    public static void login() {

        if (playerData.length() == 0) {
            System.out.println("没有数据，请先注册！");
            menu();
        } else {
            System.out.print("请输入用户名：");
            String username = new Scanner(System.in).next();
            System.out.print("请输入用户密码：");
            String password = new Scanner(System.in).next();
            try {
                ois = new ObjectInputStream(new FileInputStream(playerData));
                players = (ArrayList<Player>) ois.readObject();
                for (int i = 0; i < players.size(); i++) {
                    if (players.get(i).getUsername().equals(username) && players.get(i).getPassword().equals(password)) {
                        System.out.println("登录成功！");
                        count = i;
                        loginFlag = true;

                        if (players.get(i).getName() == null) {
                            System.out.println("欢迎来到本游戏，菜鸟！");
                            System.out.print("请输入你的角色名：");
                            String name = new Scanner(System.in).next();
                            players.get(i).setName(name);
                            DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                            Date loginDate = new Date();
                            dateFormat.format(loginDate);
                            players.get(i).setLoginDate(dateFormat.format(loginDate));
                        }else {
                            System.out.println("欢迎回来！上次登录时间："+players.get(i).getLoginDate());
                            DateFormat dateFormat = new SimpleDateFormat("yyyy年MM月dd日 HH:mm:ss");
                            Date loginDate = new Date();
                            dateFormat.format(loginDate);
                            players.get(i).setLoginDate(dateFormat.format(loginDate));
                        }
                        ois.close();
                        SecondMenu.menu();
                    }
                }
                System.out.println("用户名或者密码错误！");
                menu();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (ClassNotFoundException e) {
                e.printStackTrace();
            }
        }
    }
}
