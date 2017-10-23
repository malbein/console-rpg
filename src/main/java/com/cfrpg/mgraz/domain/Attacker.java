package com.cfrpg.mgraz.domain;

import com.cfrpg.mgraz.exception.DeadException;

/**
 * Created by mgraz1 on 10/22/17.
 */
public interface Attacker {
    public void receiveDamage(Integer damage) throws DeadException;
    public abstract Integer doDamage();
}
