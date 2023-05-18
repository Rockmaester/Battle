package com.intellekta.generics.middleearth.warriorTypes;


import com.intellekta.generics.middleearth.Unit;
import java.util.Random;

public abstract class AnyUnitAbstract implements Unit{

    private String name;
    private int power;

    // создан геттер - используется в HumanWithHorse для задания значения поля power в данном классе
    public int getPower() {
        return power;
    }

    // геррер имени - для использования в переопределенном toString для HumanWithHorse
    public String getName() {
        return name;
    }

    public AnyUnitAbstract(String name, int minPower, int maxPower) {
        Random random = new Random();
        if(name == null || name.equals("") || name.matches("\\s+")){
            this.name = super.toString();
        } else this.name = name;
        this.power = random.nextInt(minPower, maxPower + 1);
    }

    public boolean isAlive(){
        if(this.power > 0) return true;
        else return false;
    }

    @Override
    public <A extends Unit>void strike(A unit) {
        if(this.power == 0){
            System.out.println("Атакующий не может атаковать, он побежден");
        } else if(unit.isAlive()){
            unit.damage(this.power);
        } else {
            System.out.println("Атакуемый уже побежден");
        }
        String conciquences = unit.isAlive() ? "does not kill him" : "kills himm";
        System.out.printf("{%s} {%s} has a power {%d} strikes {%s} {%s} has a power {%d} and {%s}\n",
                this.getClass().getSimpleName(), this.getName(), this.getPower(), unit.getClass().getSimpleName(),
                unit.getName(), unit.getPower(), conciquences);
    }


    @Override
    public void damage(int powerDamage) {
        this.power -= powerDamage;
        if(this.power < 0 ) this.power = 0;
    }

    @Override
    public String toString() {
        String s = "";
        s += String.format("{%s} ", this.getClass().getSimpleName());
        s += String.format("{%s} ", name);
        s += String.format("has a power {%d} ", power);
        return s;
    }
}
