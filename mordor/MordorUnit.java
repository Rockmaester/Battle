package com.intellekta.generics.middleearth.mordor;

import com.intellekta.generics.middleearth.Unit;
public interface MordorUnit extends Unit {

    // добавлены пороговые значения для условий выхода при генерации юнитов и заполнения армии
    final static int MIN_ARMY_SIZE = 50;
    final static int MAX_ARMY_SIZE = 100;

    // созданы перечисления типов для использования в генераторе случайных юнитов для заполнения армии
    public enum TypesOfMordorEnum{
        GOBBLIN,
        ORC_CAVALRY,
        ORC_INFANTRY,
        TROLL,
        URUKHAL;
    }
}
