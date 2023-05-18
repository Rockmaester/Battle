package com.intellekta.generics.middleearth.warriorTypes;

public abstract class TrollAbstract extends AnyUnitAbstract implements Troll{
    public TrollAbstract(String name) {
        super(name, Troll.POWER_MIN, Troll.POWER_MAX);
    }
}
