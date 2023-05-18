package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.troopType.Infantry;
import com.intellekta.generics.middleearth.warriorTypes.TrollAbstract;

public class TrollClass extends TrollAbstract implements Infantry {
    // внедрена статическая переменная для формирования постфикса имени при генерации случайных юнитов
    public static int countNameTroll = 1;
    public TrollClass(String name) {
        super(name);
    }
}
