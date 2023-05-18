package com.intellekta.generics.middleearth.warriorTypes;
public abstract class ElfAbstract extends AnyUnitAbstract implements Elf {
    public ElfAbstract(String name) {
        super(name, Elf.POWER_MIN, Elf.POWER_MAX);
    }
}
