package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.Unit;
import com.intellekta.generics.middleearth.mordor.MordorUnit;
import com.intellekta.generics.middleearth.troopType.Infantry;
import com.intellekta.generics.middleearth.warriorTypes.GoblinAbstract;

public class GobblinClass extends GoblinAbstract implements Infantry {
    // внедрена статическая переменная для формирования постфикса имени при генерации случайных юнитов
    public static int countNameGobblin = 1;
    public GobblinClass(String name) {
        super(name);
    }
}
