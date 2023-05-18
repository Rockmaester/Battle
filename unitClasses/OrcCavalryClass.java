package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.Unit;
import com.intellekta.generics.middleearth.troopType.Cavalry;
import com.intellekta.generics.middleearth.warriorTypes.OrcAbstract;
import com.intellekta.generics.middleearth.warriorTypes.additionalTypes.WargAbstract;

public class OrcCavalryClass extends OrcAbstract implements Cavalry {
    // внедрена статическая переменная для формирования постфикса имени при генерации случайных юнитов
    public static int countNameOrcCavalry = 1;
    private int power;

    private WargOfOrc warg;

    public int getPower() {
        return power;
    }
    public WargOfOrc getWarg() {
        return warg;
    }


    public OrcCavalryClass(String name) {
        super(name);
        this.warg = new WargOfOrc();
        // создан геттер для увеличения power для всадника
        this.power = super.getPower() + this.warg.getPower();
    }

    public boolean isAlive(){
        if(this.power > 0) return true;
        else return false;
    }

    // strike для переопределен, т.к. используем power его, а не родителя,
    // т.к. его power содержит суммарное значение power лошади и всадника
    @Override
    public <A extends Unit>void strike(A unit) {
        if(this.power == 0){
            System.out.println("Юнит не может атаковать, он побежден");
        } else if(unit.isAlive()){
            unit.damage(this.power);
        } else {
            System.out.println("Атакуемый уже побежден");
            return;
        }
        String conciquences = unit.isAlive() ? "does not kill him" : "kills himm";
        System.out.printf("{%s} {%s} has a power {%d} strikes {%s} {%s} has a power {%d} and {%s}\n",
                this.getClass().getSimpleName(), this.getName(), this.getPower(), unit.getClass().getSimpleName(),
                unit.getName(), unit.getPower(), conciquences);
    }

    @Override
    public void damage(int powerDamage) {
        if(warg.isAlive()){
            int currentWargPower = warg.getPower();
            currentWargPower -= powerDamage;
            if(currentWargPower < 0) currentWargPower = 0;
            warg.setPower(currentWargPower);
        } else {
            this.power -= powerDamage;
            if(this.power < 0 ) this.power = 0;
        }
    }

    public class WargOfOrc extends WargAbstract {
        //22. У экземпляров классов Horse и Warg конструкторы не должны
        // принимать в качестве параметров значения для инициализации name.
    }

    @Override
    public String toString() {
        String s = "";
        s += String.format("{%s} ", this.getClass().getSimpleName());
        s += String.format("{%s} ", super.getName());
        s += String.format("has a power {%d} ", power);
        return s;
    }

}
