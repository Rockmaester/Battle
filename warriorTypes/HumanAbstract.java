package com.intellekta.generics.middleearth.warriorTypes;

import com.intellekta.generics.middleearth.Unit;
import com.intellekta.generics.middleearth.middleE.MiddleEarthUnit;

public abstract class HumanAbstract extends AnyUnitAbstract implements Human {
    public HumanAbstract(String name) {
        super(name, Human.POWER_MIN, Human.POWER_MAX);
    }

}
