package com.cfrpg.mgraz.exception;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class MonsterDeadException extends DeadException{

    public MonsterDeadException(){
        super("You have kill the monster");
    }
}
