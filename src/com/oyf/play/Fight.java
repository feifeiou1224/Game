package com.oyf.play;

import com.oyf.character.Boss;
import com.oyf.character.Player;

import java.util.Random;

import static com.oyf.play.GameStart.bosses;
import static com.oyf.play.GameStart.players;

/**
 * Create Time: 2019年01月08日 14:56
 * Create Author 欧阳飞
 **/

public class Fight  {


    public static void fight() {
        int round = 1;

        Boss boss = bosses.get(SecondMenu.chooseBoss);
        Player player = players.get(FirstMenu.count);

        int bossDamage = (boss.getAttack()-player.getDefense()/3);//boss对玩家造成的伤害
        if(bossDamage <1 ){
            bossDamage = 1;
        }


        int playerDamage = player.getAttack();

        int bHp = boss.getHp();
        int pHp = player.getHp();

        int bspeed = boss.getSpeed();
        int pspeed = player.getSpeed();

        while (true) {
            try {
                Thread.sleep(600);
            } catch (Exception e) {
                e.printStackTrace();
            }

            int br = new Random().nextInt(40) + 1 + bspeed;
            int pr = new Random().nextInt(40) + 1 + pspeed/3;

            if (pr >= br) {

                System.out.println("---------------------------");
                System.out.println("\033[30;4m"+"        第" + round + "回合        "+ "\033[0m");
                System.out.println("你对Boss造成了" + playerDamage + "点伤害");

                boss.setHp(boss.getHp() - playerDamage);

                System.out.println("Boss剩余" + boss.getHp() + "点HP");
                System.out.println("你剩余" + player.getHp() + "点HP");
                System.out.println("---------------------------");
            } else {

                System.out.println("---------------------------");
                System.out.println("\033[30;4m"+"        第" + round + "回合        "+ "\033[0m");
                System.out.println("Boss对你造成了" + bossDamage + "点伤害");

                player.setHp(player.getHp() - bossDamage);

                System.out.println("Boss剩余" + boss.getHp() + "点HP");
                System.out.println("你剩余" + player.getHp() + "点HP");
                System.out.println("---------------------------");
            }

            if (round == 50) {
                System.out.println("\033[36;4m" +"居然是旗鼓相当的对手"+"\033[0m");
                System.out.println("\033[33;4m" +"你获得了5个金币和" + boss.getDrawExp() + "点经验"+"\033[0m");
                System.out.println("---------------------------");

                player.setMoney(player.getMoney() + 5);
                player.setExp(player.getExp() + boss.getDrawExp());
                player.setHp(pHp);
                boss.setHp(bHp);
                break;
            }

            if (player.getHp() <= 0) {
                System.out.println("\033[31;4m" +"啊你死了"+ "\033[0m");
                System.out.println("boss剩余"+boss.getHp()+"点HP");
                System.out.println("\033[33;4m" +"你获得了3个金币和1点经验"+"\033[0m");
                System.out.println("---------------------------");

                player.setMoney(player.getMoney() + 3);
                player.setExp(player.getExp() + 1);
                player.setHp(pHp);
                boss.setHp(bHp);
                break;
            }if (boss.getHp() <= 0) {
                System.out.println("\033[32;4m" +"你获得了胜利!"+ "\033[0m");
                System.out.println("\033[33;4m" +"你获得了10个金币和" + boss.getSuccessExp() + "点经验"+"\033[0m");
                System.out.println("---------------------------");

                player.setHp(pHp);
                player.setMoney(player.getMoney() + 10);
                player.setExp(player.getExp() + boss.getSuccessExp());
                boss.setHp(bHp);
                break;
            }
            round++;
        }
        if(player.getLevel() < 10) {
            if (player.getExp() >= 50) {
                System.out.println("\033[33;4m" +"恭喜你升级了！所有属性+3！！"+"\033[0m");
                System.out.println("---------------------------");

                player.setExp(player.getExp() - 50);
                player.setLevel(player.getLevel() + 1);
                player.setSpeed(player.getSpeed() + 3);
                player.setAttack(player.getAttack() + 3);
                player.setDefense(player.getDefense() + 3);
                player.setHp(pHp + 3);
            }
        }
        SecondMenu.menu();
    }
}
