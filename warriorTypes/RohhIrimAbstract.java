package com.intellekta.generics.middleearth.warriorTypes;

public abstract class RohhIrimAbstract extends AnyUnitAbstract implements RohhIrim {
    public RohhIrimAbstract(String name) {
        super(name, RohhIrim.POWER_MIN, RohhIrim.POWER_MAX);
    }
}
