package com.intellekta.generics.middleearth.warriorTypes;


public abstract class GoblinAbstract extends AnyUnitAbstract implements Goblin {
    public GoblinAbstract(String name) {
        super(name, Goblin.POWER_MIN, Goblin.POWER_MAX);
    }
}
