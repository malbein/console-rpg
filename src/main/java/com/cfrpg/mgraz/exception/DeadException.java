package com.cfrpg.mgraz.exception;

/**
 * Created by mgraz1 on 10/21/17.
 */
public class DeadException extends Exception{

    public DeadException(){
        super("You have been Killed");
    }

    public DeadException(String message){
        super(message);
    }
}
