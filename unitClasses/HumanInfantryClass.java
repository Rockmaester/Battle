package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.troopType.Infantry;
import com.intellekta.generics.middleearth.warriorTypes.HumanAbstract;

public class HumanInfantryClass extends HumanAbstract implements Infantry {
    // внедрена статическая переменная для формирования постфикса имени при генерации случайных юнитов
    public static int countNameHumanInfantry = 1;
    public HumanInfantryClass(String name) {
        super(name);
    }
}
