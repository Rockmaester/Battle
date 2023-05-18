package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.troopType.Infantry;
import com.intellekta.generics.middleearth.warriorTypes.WoodenElfAbstract;

public class WoodenElfClass extends WoodenElfAbstract implements Infantry {
    public static int countNameWoodenElf = 1;
    public WoodenElfClass(String name) {
        super(name);
    }
}
