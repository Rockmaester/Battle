package com.intellekta.generics.middleearth.warriorTypes.additionalTypes;

import com.intellekta.generics.middleearth.warriorTypes.AnyUnitAbstract;

public abstract class HorseAbstract extends AnyUnitAbstract implements Horse{
    private int power;
    public HorseAbstract() {
        // 22.У экземпляров классов Horse и Warg конструкторы не должны
        // принимать в качестве параметров значения для инициализации name.
        super(null, Horse.POWER_MIN, Horse.POWER_MAX);
        this.power = super.getPower();
    }

    // Создан геттер у лошади, т.к. без него невозможно обратиться к horse.power в других классах.
    // Это сделано в целях ухода от дублирования кода вложенного класса лошади HorseAbstractOfHuman
    // в классе HumanAbstract и увода кода в класс HorseAbstract. И т.п. в других классах.
    public int getPower() {
        return power;
    }

    // внедрили сеттер для лошади, для использования в методе damage для обнуления power лошади до обнуления power всадника
    public void setPower(int power) {
        if(power < 0) return;
        if(power > this.power) return;
        this.power = power;
        // Экземпляры типов всех указанных типов данных должны обеспечивать, что значение power никогда
        // не будет увеличиваться и никогда не будет меньше нуля, при попытке увеличить значение power оно не должно меняться.
    }

    // Переопределили здесь метод isAlive(), т.к. иначе в методе damage() в классе Всадника идет
    // обращение к переменной power абстрактного родителя AnyUnitAbstract, которая не обнуляется при нанесении damage,
    // т.к. там мы не создавали сеттер.
    @Override
    public boolean isAlive() {
        if(power > 0) return true;
        else return false;
    }

    // метод toString переопределен только для вывода энергии лошади на экран в целях тестирования
    @Override
    public String toString() {
        String s = "";
        s += String.format("{%s} ", this.getClass().getSimpleName());
        s += String.format("has a power {%d} ", power);
        return s;
    }

}
