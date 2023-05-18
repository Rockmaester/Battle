package com.intellekta.generics.middleearth.warriorTypes;
public abstract class WoodenElfAbstract extends AnyUnitAbstract implements WoodenElf{
    public WoodenElfAbstract(String name) {
        super(name, WoodenElf.POWER_MIN, WoodenElf.POWER_MAX);
    }
}
