package com.intellekta.generics.middleearth;

import com.intellekta.generics.middleearth.middleE.MiddleEarthUnit;
import com.intellekta.generics.middleearth.mordor.MordorUnit;
import com.intellekta.generics.middleearth.troopType.Cavalry;
import com.intellekta.generics.middleearth.troopType.Infantry;

import java.util.List;
import java.util.Random;
import static com.intellekta.generics.middleearth.Randomizer.fillTheArmies;

public class Battle {

    public static void fight() {

        Random random = new Random();

        System.out.println("Начало формирования армий");

        Army<MordorUnit> armyOfMordor = new Army<>();
        Army<MiddleEarthUnit> armyOfMiddleEarth = new Army<>();

        fillTheArmies(armyOfMiddleEarth, armyOfMordor);

        System.out.println(armyOfMiddleEarth.toString());
        System.out.println(armyOfMordor.toString());

        // Фаза 1. Сражение кавалерий.
        System.out.println("\nФаза 1. Сражение кавалерий.\n");
        List<MiddleEarthUnit> listOfMiddleEarthCavalry = armyOfMiddleEarth.getCavalry();
        List<MordorUnit> listOfMordorCavalry = armyOfMordor.getCavalry();


        while (listOfMiddleEarthCavalry.size() != 0 && listOfMordorCavalry.size() != 0) {
            // генерация случайных индексов для списков кавалерий армий
            int randomMiddleEarthUnitIndex = random.nextInt(listOfMiddleEarthCavalry.size());
            int randomMordorUnitIndex = random.nextInt(listOfMordorCavalry.size());

            // выбор по случайным индексам юнитов из списков для дуэли
            MiddleEarthUnit middleEarthSelectedUnit = listOfMiddleEarthCavalry.get(randomMiddleEarthUnitIndex);
            MordorUnit mordorSelectedUnit = listOfMordorCavalry.get(randomMordorUnitIndex);

            // выбор приоритета удара для воюющей стороны
            localFightBetweenTwoUnits(random, armyOfMordor, armyOfMiddleEarth, middleEarthSelectedUnit, mordorSelectedUnit);
        }

        System.out.println("\nостатки");
        System.out.println("ME Cavalry: " + listOfMiddleEarthCavalry.size());
        System.out.println("Mordor Cavalry: " + listOfMordorCavalry.size());
        System.out.println();

        // вывод на печать списка победившей стороны
        System.out.println("\nвывод на печать списка победившей стороны\n");
        if (listOfMiddleEarthCavalry.size() > 0) {
            armyOfMiddleEarth.printWinner(1, listOfMiddleEarthCavalry);
        }
        if (listOfMordorCavalry.size() > 0) {
            armyOfMordor.printWinner(1, listOfMordorCavalry);
        }

        // Фаза 2 - сражение пехоты
        System.out.println("\nФаза 2 - сражение пехоты\n");
        List<MiddleEarthUnit> listOfMiddleEarthInfantry = armyOfMiddleEarth.getInfantry();
        List<MordorUnit> listOfMordorInfantry = armyOfMordor.getInfantry();


        while (listOfMiddleEarthInfantry.size() != 0 && listOfMordorInfantry.size() != 0) {
            // генерация случайных индексов для списков кавалерий армий
            int randomMiddleEarthUnitIndex = random.nextInt(listOfMiddleEarthInfantry.size());
            int randomMordorUnitIndex = random.nextInt(listOfMordorInfantry.size());

            // выбор по случайным индексам юнитов из списков для дуэли
            MiddleEarthUnit middleEarthSelectedUnit = listOfMiddleEarthInfantry.get(randomMiddleEarthUnitIndex);
            MordorUnit mordorSelectedUnit = listOfMordorInfantry.get(randomMordorUnitIndex);

            localFightBetweenTwoUnits(random, armyOfMordor, armyOfMiddleEarth, middleEarthSelectedUnit, mordorSelectedUnit);
        }

        System.out.println("\nостатки");
        System.out.println("ME Infantry: " + listOfMiddleEarthInfantry.size());
        System.out.println("Mordor Infantry: " + listOfMordorInfantry.size());
        System.out.println();

        // вывод на печать списка победившей стороны
        if (listOfMiddleEarthInfantry.size() > 0) {
            armyOfMiddleEarth.printWinner(2, listOfMiddleEarthInfantry);
        }
        if (listOfMordorInfantry.size() > 0) {
            armyOfMordor.printWinner(2, listOfMordorInfantry);
        }

        System.out.println("\nостатки по обоим видам войск");
        System.out.println("ME Army: "  + armyOfMiddleEarth.getArmy().size());
        System.out.println("Mordor Army: " + armyOfMordor.getArmy().size());
        System.out.println();

        // Фаза 3
        System.out.println("\nФаза 3\n");

        List<MiddleEarthUnit> theRestOfArmyOfME = armyOfMiddleEarth.getArmy();
        List<MordorUnit> theRestOfArmyofMordor = armyOfMordor.getArmy();
        if (armyOfMiddleEarth.getArmy().size() > 0 && armyOfMordor.getArmy().size() > 0) {

            while (theRestOfArmyOfME.size() != 0 && theRestOfArmyofMordor.size() != 0) {

                // генерация случайных индексов для списков армий
                int randomMiddleEarthUnitIndex = random.nextInt(theRestOfArmyOfME.size());
                int randomMordorUnitIndex = random.nextInt(theRestOfArmyofMordor.size());

                // выбор по случайным индексам юнитов из списков для дуэли
                MiddleEarthUnit middleEarthSelectedUnit = theRestOfArmyOfME.get(randomMiddleEarthUnitIndex);
                MordorUnit mordorSelectedUnit = theRestOfArmyofMordor.get(randomMordorUnitIndex);

                // кавалерия имеет преимущество первого удара перед пехотой (т. е. в дуэли, в которой участвует
                // кавалерист и пехотинец, первый удар всегда наносит кавалерист).
                if (middleEarthSelectedUnit instanceof Cavalry && mordorSelectedUnit instanceof Infantry) {

                    middleEarthSelectedUnit.strike(mordorSelectedUnit);
                    if (!mordorSelectedUnit.isAlive()) armyOfMordor.release(mordorSelectedUnit);
                    else if (mordorSelectedUnit.isAlive()) mordorSelectedUnit.strike(middleEarthSelectedUnit);
                    if (!middleEarthSelectedUnit.isAlive()) armyOfMiddleEarth.release(middleEarthSelectedUnit);

                } else if (middleEarthSelectedUnit instanceof Infantry && mordorSelectedUnit instanceof Cavalry) {

                    mordorSelectedUnit.strike(middleEarthSelectedUnit);
                    if (!middleEarthSelectedUnit.isAlive()) armyOfMiddleEarth.release(middleEarthSelectedUnit);
                    else if (middleEarthSelectedUnit.isAlive()) middleEarthSelectedUnit.strike(mordorSelectedUnit);
                    if (!mordorSelectedUnit.isAlive()) armyOfMordor.release(mordorSelectedUnit);

                } else {
                    localFightBetweenTwoUnits(random, armyOfMordor, armyOfMiddleEarth, middleEarthSelectedUnit, mordorSelectedUnit);
                }

                theRestOfArmyOfME = armyOfMiddleEarth.getArmy();
                theRestOfArmyofMordor = armyOfMordor.getArmy();
            }
        }
        // вывод на печать списка победившей стороны
        if (theRestOfArmyOfME.size() > 0) armyOfMiddleEarth.printWinner(3, theRestOfArmyOfME);
        if (theRestOfArmyofMordor.size() > 0) armyOfMordor.printWinner(3, theRestOfArmyofMordor);

    } // end of fight()

    private static void localFightBetweenTwoUnits(Random random, Army<MordorUnit> armyOfMordor,
                                                  Army<MiddleEarthUnit> armyOfMiddleEarth,
                                                  MiddleEarthUnit middleEarthSelectedUnit,
                                                  MordorUnit mordorSelectedUnit) {
        int priorityOfStrike = random.nextInt(2);
        if(priorityOfStrike == 0){
            middleEarthSelectedUnit.strike(mordorSelectedUnit);
            if(!mordorSelectedUnit.isAlive()) armyOfMordor.release(mordorSelectedUnit);
            else if(mordorSelectedUnit.isAlive()) mordorSelectedUnit.strike(middleEarthSelectedUnit);
            if(!middleEarthSelectedUnit.isAlive()) armyOfMiddleEarth.release(middleEarthSelectedUnit);
        }
        if (priorityOfStrike == 1){
            mordorSelectedUnit.strike(middleEarthSelectedUnit);
            if(!middleEarthSelectedUnit.isAlive()) armyOfMiddleEarth.release(middleEarthSelectedUnit);
            else if(middleEarthSelectedUnit.isAlive()) middleEarthSelectedUnit.strike(mordorSelectedUnit);
            if(!mordorSelectedUnit.isAlive()) armyOfMordor.release(mordorSelectedUnit);
        }
    }

}
