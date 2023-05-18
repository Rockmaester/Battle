package com.intellekta.generics.middleearth.warriorTypes;

public abstract class UrukHalAbstract extends AnyUnitAbstract implements UrukHal {
    public UrukHalAbstract(String name) {
        super(name, UrukHal.POWER_MIN, UrukHal.POWER_MAX);
    }
}
