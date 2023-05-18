package com.intellekta.generics.middleearth;


import com.intellekta.generics.middleearth.middleE.MiddleEarthUnit;
import com.intellekta.generics.middleearth.mordor.MordorUnit;
import com.intellekta.generics.middleearth.unitClasses.*;

import java.util.Random;



public class Randomizer {

    // в качестве условия для формирования армий выбраны следующие параметры:
    // ограничение снизу - не менее 50 (в интерфейсе)
    // ограничение сверху - не более 100 (в интерфейсе)
    // разница между армиями не более 20 %
    private static int mordorCount;
    private static int MECount;
    private static int wizardCount;
    private static int wizardIsExist;

    public static void fillTheArmies(Army<MiddleEarthUnit> armyME, Army<MordorUnit> armyMordor) {
        // коэффициент превышения разницы численности
        double difRatio = 1.2;
        Random random = new Random();

        // созданы массивы перечислений типов
        MiddleEarthUnit.TypesOfMiddleEarthEnum[] arrayOfTypesME = MiddleEarthUnit.TypesOfMiddleEarthEnum.values();
        MordorUnit.TypesOfMordorEnum[] arrayOfTypesMordor = MordorUnit.TypesOfMordorEnum.values();

        // произвольный выбор наличия wizard в армии
        wizardIsExist = random.nextInt(2);
        System.out.println("wizardIsExist - " + (wizardIsExist == 1 ? "Yes" : "No"));

        if (wizardIsExist == 1){
            Unit unit = WizardClass.getSingletonObject();
            armyME.recruit((MiddleEarthUnit) unit);
            if(WizardClass.wizardCallCount == 1) MECount++;
            wizardCount = WizardClass.wizardCallCount;
            System.out.println(unit.toString());
            System.out.println("mordorCount " + mordorCount);
            System.out.println("MECount " + MECount);
        }

        // условие прекращения метода: пока размер одной армии не достигнет 20%-го превышения над второй,
        // но не менее чем 30 юнитов в каждой и не более чем 50 юнитов в каждой
        while(
                !((mordorCount >= difRatio * MECount || MECount >= difRatio * mordorCount)
                &&
                ((mordorCount >= MordorUnit.MIN_ARMY_SIZE && mordorCount <= MordorUnit.MAX_ARMY_SIZE)
                        && (MECount >= MiddleEarthUnit.MIN_ARMY_SIZE && MECount <= MiddleEarthUnit.MAX_ARMY_SIZE)))
        ){

            if(mordorCount < MordorUnit.MAX_ARMY_SIZE && MECount < MiddleEarthUnit.MAX_ARMY_SIZE){

                // выбирается случайная армия
                // 0 - для MiddleEarth, 1 - для Mordor
                int turnOfArmy = random.nextInt(2);
                if(turnOfArmy == 0){
                    // генерируем случайный индекс для массива
                    int randomTypeIndex = random.nextInt(arrayOfTypesME.length);
                    // вызываем метод генерации с передачей элемента массива со случайным индексом
                    MiddleEarthUnit unit = generateRandomUnitME(arrayOfTypesME[randomTypeIndex]);
                    armyME.recruit(unit);

                    System.out.println(unit.toString());
                    System.out.println("mordorCount " + mordorCount);
                    System.out.println("MECount " + MECount);
                }
                if(turnOfArmy == 1){
                    // генерируем случайный индекс для массива
                    int randomTypeIndex = random.nextInt(arrayOfTypesMordor.length);
                    // вызываем метод генерации с передачей элемента массива со случайным индексом
                    MordorUnit unit = generateRandomUnitMordor(arrayOfTypesMordor[randomTypeIndex]);
                    armyMordor.recruit(unit);

                    System.out.println(unit.toString());
                    System.out.println("mordorCount " + mordorCount);
                    System.out.println("MECount " + MECount);
                }
            }
            else if (mordorCount == MordorUnit.MAX_ARMY_SIZE && MECount < MiddleEarthUnit.MAX_ARMY_SIZE){

                int randomTypeIndex = random.nextInt(arrayOfTypesME.length);
                // вызываем метод генерации с передачей элемента массива со случайным индексом
                MiddleEarthUnit unit = generateRandomUnitME(arrayOfTypesME[randomTypeIndex]);
                armyME.recruit(unit);

                System.out.println(unit.toString());
                System.out.println("mordorCount " + mordorCount);
                System.out.println("MECount " + MECount);
            }
            else if (mordorCount < MordorUnit.MAX_ARMY_SIZE && MECount == MiddleEarthUnit.MAX_ARMY_SIZE){

                int randomTypeIndex = random.nextInt(arrayOfTypesMordor.length);
                // вызываем метод генерации с передачей элемента массива со случайным индексом
                MordorUnit unit = generateRandomUnitMordor(arrayOfTypesMordor[randomTypeIndex]);
                armyMordor.recruit(unit);

                System.out.println(unit.toString());
                System.out.println("mordorCount " + mordorCount);
                System.out.println("MECount " + MECount);
            }
            else if (mordorCount == MordorUnit.MAX_ARMY_SIZE && MECount == MiddleEarthUnit.MAX_ARMY_SIZE) break;
        }

        //Если сработало условие о том, что обе армии достигли диапазона, но соотношение разницы в 20% превышено
        if(mordorCount > difRatio * MECount){
            while (mordorCount > difRatio * MECount) {
                int randomTypeIndex = random.nextInt(arrayOfTypesME.length);
                // вызываем метод генерации с передачей элемента массива со случайным индексом
                MiddleEarthUnit unit = generateRandomUnitME(arrayOfTypesME[randomTypeIndex]);
                armyME.recruit(unit);

                System.out.println(unit.toString());
                System.out.println("mordorCount " + mordorCount);
                System.out.println("MECount " + MECount);
            }
        }
        if(MECount > difRatio * mordorCount){
            while (MECount > difRatio * mordorCount) {

                int randomTypeIndex = random.nextInt(arrayOfTypesMordor.length);
                // вызываем метод генерации с передачей элемента массива со случайным индексом
                MordorUnit unit = generateRandomUnitMordor(arrayOfTypesMordor[randomTypeIndex]);
                armyMordor.recruit(unit);

                System.out.println(unit.toString());
                System.out.println("mordorCount " + mordorCount);
                System.out.println("MECount " + MECount);
            }
        }

        System.out.println("\nНаполнение армий закончено по достижению одного из условий");
        System.out.println("mordorCount " + mordorCount);
        System.out.println("MECount " + MECount);
        System.out.println();

    }

    // factory-метод для генерации случайных юнитов для заполнения армии MiddleEarth
    public static MiddleEarthUnit generateRandomUnitME(MiddleEarthUnit.TypesOfMiddleEarthEnum type){
        MiddleEarthUnit unit = null;

        switch(type){
            case HUMAN_INFANTRY:
                unit = new HumanInfantryClass("HumanInfantry "
                        + HumanCavalryClass.countNameHumanCavalry++);
                MECount++;
                break;
            case HUMAN_CAVALRY:
                unit = new HumanCavalryClass("HumanCavalry "
                        + HumanInfantryClass.countNameHumanInfantry++);
                MECount++;
                break;
            case ROHHIRIM:
                unit = new RohhiRimClass("Rohhirim " +
                        RohhiRimClass.countNameRohhIrim++);
                MECount++;
                break;
            case ELF:
                unit = new ElfClass("Elf " +
                        ElfClass.countNameElf++);
                MECount++;
                break;
            case WOODENELF:
                unit = new WoodenElfClass("WoodenElf " +
                        WoodenElfClass.countNameWoodenElf++);
                MECount++;
                break;
        }
        return unit;
    }

    // factory-метод для генерации случайных юнитов для заполнения армии Mordor
    public static MordorUnit generateRandomUnitMordor(MordorUnit.TypesOfMordorEnum type){
        MordorUnit unit = null;

        switch(type){
            case GOBBLIN:
                unit = new GobblinClass("Gobblin "
                        + GobblinClass.countNameGobblin++);
                mordorCount++;
                break;
            case ORC_CAVALRY:
                unit = new OrcCavalryClass("OrcCavalry "
                        + OrcCavalryClass.countNameOrcCavalry++);
                mordorCount++;
                break;
            case ORC_INFANTRY:
                unit = new OrcInfantryClass("OrcInfantry " +
                        OrcInfantryClass.countNameOrcInfantry++);
                mordorCount++;
                break;
            case TROLL:
                unit = new TrollClass("Troll " +
                        TrollClass.countNameTroll++);
                mordorCount++;
                break;
            case URUKHAL:
                unit = new UrukHalClass("UrukHal " +
                        UrukHalClass.countNameUrukHal++);
                mordorCount++;
                break;
        }
        return unit;
    }

}
