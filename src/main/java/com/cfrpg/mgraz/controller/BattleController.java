package com.cfrpg.mgraz.controller;

import com.cfrpg.mgraz.domain.Monster;
import com.cfrpg.mgraz.domain.Character;
import com.cfrpg.mgraz.domain.location.Dungeon;
import com.cfrpg.mgraz.domain.location.Location;
import com.cfrpg.mgraz.exception.DeadException;
import com.cfrpg.mgraz.exception.MonsterDeadException;
import com.cfrpg.mgraz.provider.CharacterProvider;
import com.cfrpg.mgraz.provider.LocationProvider;

import java.util.Scanner;

/**
 * Created by mgraz1 on 10/22/17.
 *
 * This is a presentation class that shows the battle
 */
public class BattleController {

    private static BattleController instance;

    private BattleController(){

    }

    public static BattleController getInstance(){
        if(instance == null){
            instance = new BattleController();
        }
        return instance;
    }

    public boolean match(Location location) {
        Character character = CharacterProvider.getInstance().getCharacter();
        Monster monster = ((Dungeon)location).getMonster();
        monster.reset();

        boolean resp = true;
        try{
            System.out.println();
            System.out.println(" ███████╗██╗ ██████╗ ██╗  ██╗████████╗\n" +
                                "██╔════╝██║██╔════╝ ██║  ██║╚══██╔══╝\n" +
                                "█████╗  ██║██║  ███╗███████║   ██║   \n" +
                                "██╔══╝  ██║██║   ██║██╔══██║   ██║   \n" +
                                "██║     ██║╚██████╔╝██║  ██║   ██║   \n" +
                                "╚═╝     ╚═╝ ╚═════╝ ╚═╝  ╚═╝   ╚═╝   \n");
            while(true){
                System.out.println("## You attack Monster ##");
                System.out.println(" ---> You do ".concat(character.doDamage().toString()).concat(" damage."));
                monster.receiveDamage(character.doDamage());
                System.out.println("## Monster attacks you ##");
                System.out.println(" <--- You receive ".concat(monster.doDamage().toString()).concat(" damage."));
                character.receiveDamage(monster.doDamage());
            }
        }catch (MonsterDeadException ex){
            System.out.println();
            System.out.println( "██╗    ██╗██╗███╗   ██╗███╗   ██╗███████╗██████╗ \n" +
                                "██║    ██║██║████╗  ██║████╗  ██║██╔════╝██╔══██╗\n" +
                                "██║ █╗ ██║██║██╔██╗ ██║██╔██╗ ██║█████╗  ██████╔╝\n" +
                                "██║███╗██║██║██║╚██╗██║██║╚██╗██║██╔══╝  ██╔══██╗\n" +
                                "╚███╔███╔╝██║██║ ╚████║██║ ╚████║███████╗██║  ██║\n" +
                                " ╚══╝╚══╝ ╚═╝╚═╝  ╚═══╝╚═╝  ╚═══╝╚══════╝╚═╝  ╚═╝    ");
            System.out.println("You have kill the ".concat(monster.getName()).concat("!!!"));

            character.gainExperience(monster.getXpReward());
            CharacterController.getInstance().printDetail();
            LocationProvider.getInstance().moveNextLocation();

        }catch (DeadException ex){
            LocationProvider.getInstance().setCurrentLocation(LocationProvider.getInstance().getInitialLocation());
            character.rest();
            resp = false;

            System.out.println();
            System.out.println(" ██████╗  █████╗ ██████╗     ██╗     ██╗   ██╗ ██████╗██╗  ██╗\n" +
                                "██╔══██╗██╔══██╗██╔══██╗    ██║     ██║   ██║██╔════╝██║ ██╔╝\n" +
                                "██████╔╝███████║██║  ██║    ██║     ██║   ██║██║     █████╔╝ \n" +
                                "██╔══██╗██╔══██║██║  ██║    ██║     ██║   ██║██║     ██╔═██╗ \n" +
                                "██████╔╝██║  ██║██████╔╝    ███████╗╚██████╔╝╚██████╗██║  ██╗\n" +
                                "╚═════╝ ╚═╝  ╚═╝╚═════╝     ╚══════╝ ╚═════╝  ╚═════╝╚═╝  ╚═╝");
            System.out.println(monster.getName().concat(" have kill you!!!"));

            System.out.println("Press enter to continue");
            Scanner scanIn = new Scanner(System.in);
            scanIn.nextLine();
        }

        return resp;
    }
}
