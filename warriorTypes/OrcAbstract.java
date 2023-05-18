package com.intellekta.generics.middleearth.warriorTypes;


public abstract class OrcAbstract extends AnyUnitAbstract implements Orc{
    public OrcAbstract(String name) {
        super(name, Orc.POWER_MIN, Orc.POWER_MAX);
    }
}
