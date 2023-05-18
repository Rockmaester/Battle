package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.Unit;
import com.intellekta.generics.middleearth.troopType.Cavalry;
import com.intellekta.generics.middleearth.warriorTypes.HumanAbstract;
import com.intellekta.generics.middleearth.warriorTypes.additionalTypes.HorseAbstract;

public class HumanCavalryClass extends HumanAbstract implements Cavalry {

    // внедрена статическая переменная для формирования постфикса имени при генерации случайных юнитов
    public static int countNameHumanCavalry = 1;
    private int power;
    private HorseOfHuman horse;

    // геттер создал только для тестирования в main отдельно power всадника и лошади
    public int getPower() {
        return power;
    }

    // геттер создан только для тестирования жизни лошади в main, в другой логике не участвует
    public HorseOfHuman getHorse() {
        return horse;
    }

    public HumanCavalryClass(String name) {
        super(name);
        this.horse = new HorseOfHuman();
        // создан геттер у Horse для увеличения power для Human
        this.power = super.getPower() + this.horse.getPower();
    }

    public boolean isAlive(){
        if(this.power > 0) return true;
        else return false;
    }


    // strike для HumanWithHorse переопределен, т.к. используем power его, а не родителя,
    // т.к. его power содержит суммарное значение power лошади и всадника

    @Override
    public <A extends Unit> void strike(A unit) {
        if(this.power == 0){
            System.out.println("Юнит не может атаковать, он побежден");
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
        if(horse.isAlive()){
            int currentHorsePower = horse.getPower();
            currentHorsePower -= powerDamage;
            if(currentHorsePower < 0){
                currentHorsePower = 0;
                this.power = super.getPower();
            }
            horse.setPower(currentHorsePower);

        } else {
            this.power -= powerDamage;
            if(this.power < 0 ) this.power = 0;
        }
    }


    public class HorseOfHuman extends HorseAbstract {
        //22. У экземпляров классов Horse и Warg конструкторы не должны
        // принимать в качестве параметров значения для инициализации name.
    }

    // toString переопределен для доступа к полю name
    @Override
    public String toString() {
        String s = "";
        s += String.format("{%s} ", this.getClass().getSimpleName());
        s += String.format("{%s} ", super.getName());
        s += String.format("has a power {%d} ", power);
        return s;
    }
}
