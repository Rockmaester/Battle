package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.troopType.Infantry;
import com.intellekta.generics.middleearth.warriorTypes.ElfAbstract;

public class ElfClass extends ElfAbstract implements Infantry {
    public static int countNameElf = 1;
    public ElfClass(String name) {
        super(name);
    }
}
