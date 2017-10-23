package com.cfrpg.mgraz.domain.location;

import java.util.List;

/**
 * Created by mgraz1 on 10/22/17.
 */
public abstract class Location {

    private Location previus;
    private Location next;

    private String name;
    private String intro;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getIntro() {
        return intro;
    }

    public void setIntro(String intro) {
        this.intro = intro;
    }

    public Location getPrevius() {
        return previus;
    }

    public void setPrevius(Location previus) {
        this.previus = previus;
    }

    public Location getNext() {
        return next;
    }

    public void setNext(Location next) {
        this.next = next;
    }

    public abstract List<String> actionOptions();
}
