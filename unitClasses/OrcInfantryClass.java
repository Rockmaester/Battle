package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.troopType.Infantry;
import com.intellekta.generics.middleearth.warriorTypes.OrcAbstract;

public class OrcInfantryClass extends OrcAbstract implements Infantry {
    // внедрена статическая переменная для формирования постфикса имени при генерации случайных юнитов
    public static int countNameOrcInfantry = 1;
    public OrcInfantryClass(String name) {
        super(name);
    }
}
