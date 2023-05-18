package com.intellekta.generics.middleearth.warriorTypes.additionalTypes;

import com.intellekta.generics.middleearth.warriorTypes.AnyUnitAbstract;

public abstract class WargAbstract extends AnyUnitAbstract implements Warg{
    private int power;
    public WargAbstract() {
        // 22.У экземпляров классов Horse и Warg конструкторы не должны
        // принимать в качестве параметров значения для инициализации name.
        super(null, Warg.POWER_MIN, Warg.POWER_MAX);
        this.power = super.getPower();
    }

    // Создан геттер у варга, т.к. без него невозможно обратиться к warg.power в других классах.
    public int getPower() {
        return power;
    }

    // внедрили сеттер для варга, для использования в методе damage для обнуления power варга до обнуления power всадника
    public void setPower(int power) {
        if(power < 0) return;
        if(power > this.power) return;
        this.power = power;
        // Экземпляры типов всех указанных типов данных должны обеспечивать, что значение power никогда
        // не будет увеличиваться и никогда не будет меньше нуля, при попытке увеличить значение power оно не должно меняться.
    }

    // переопределили здесь метод isAlive(), т.к. иначе в методе damage() в классе Всадника идет
    // обращение к переменной power абстрактного родителя AnyUnitAbstract, которая не обнуляется при нанесении damage,
    // т.к. нет сеттера.
    @Override
    public boolean isAlive() {
        if(power > 0) return true;
        else return false;
    }
}
