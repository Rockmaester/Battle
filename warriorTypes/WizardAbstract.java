package com.intellekta.generics.middleearth.warriorTypes;

public abstract class WizardAbstract extends AnyUnitAbstract implements Wizard {
    public WizardAbstract(String name) {
        super(name, Wizard.POWER, Wizard.POWER);
    }
}
