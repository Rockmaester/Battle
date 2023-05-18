package com.intellekta.generics.middleearth.unitClasses;

import com.intellekta.generics.middleearth.troopType.Cavalry;
import com.intellekta.generics.middleearth.warriorTypes.WizardAbstract;
import com.intellekta.generics.middleearth.warriorTypes.additionalTypes.HorseAbstract;

public class WizardClass extends WizardAbstract implements Cavalry {
    // внедрена статическая переменная для формирования постфикса имени при генерации случайных юнитов
    public static int countNameWizard = 1;
    private int power;
    private HorseOfWizard horse;

    // счетчик вызова синглтона Волшебника. Используется в классе Randomizer для исключения дублирования подсчета численности армий
    public static int wizardCallCount;
    private static WizardClass singletonObject;
    public static WizardClass getSingletonObject(){
        if(singletonObject == null){
            singletonObject = new WizardClass("Wizard " +
                    WizardClass.countNameWizard++);
        }
        wizardCallCount++;
        return singletonObject;
    }

    // геттер создал только для тестирования в main отдельно power всадника и лошади
    public int getPower() {
        return power;
    }

    // геттер создан только для тестирования жизни лошади в main, в другой логике не участвует
    public HorseOfWizard getHorse() {
        return horse;
    }

    private WizardClass(String name) {
        super(name);
        this.horse = new HorseOfWizard();
        // создан геттер у Horse для увеличения power для всадника
        this.power = super.getPower() + this.horse.getPower();
    }

    public boolean isAlive(){
        if(this.power > 0) return true;
        else return false;
    }

    public <A extends WizardClass> void strike(A unit) {
        if(this.power == 0){
            System.out.println("Юнит не может атаковать, он побежден");
        } else if(unit.isAlive()){
            unit.damage(this.power);
        } else {
            System.out.println("Атакуемый уже побежден");
        }
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
    public class HorseOfWizard extends HorseAbstract {
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
