package com.cfrpg.mgraz.domain.location;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by mgraz1 on 10/22/17.
 */
public class City extends Location {

    public List<String> actionOptions(){
        List<String> list = new ArrayList<String>();
        list.add("h - rest & heal");
        return list;
    }
}
