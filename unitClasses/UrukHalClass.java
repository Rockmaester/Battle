package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.troopType.Infantry;
import com.intellekta.generics.middleearth.warriorTypes.UrukHalAbstract;

public class UrukHalClass extends UrukHalAbstract implements Infantry {
    // внедрена статическая переменная для формирования постфикса имени при генерации случайных юнитов
    public static int countNameUrukHal = 1;
    public UrukHalClass(String name) {
        super(name);
    }
}
