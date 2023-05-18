package com.intellekta.generics.middleearth.middleE;

import com.intellekta.generics.middleearth.Unit;

public interface MiddleEarthUnit extends Unit {

    // добавлены пороговые значения для условий выхода при генерации юнитов и заполнения армии
    final static int MIN_ARMY_SIZE = 50;
    final static int MAX_ARMY_SIZE = 100;

    // созданы перечисления типов для использования в генераторе случайных юнитов для заполнения армии
    public enum TypesOfMiddleEarthEnum{
        ELF,
        HUMAN_CAVALRY,
        HUMAN_INFANTRY,
        ROHHIRIM,
        WOODENELF;
    }
}
