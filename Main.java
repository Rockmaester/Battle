//package com.intellekta.generics.middleearth;
//
//import com.intellekta.generics.middleearth.middleE.CavalryMiddleEarth;
//import com.intellekta.generics.middleearth.middleE.InfantryMiddleEarth;
//import com.intellekta.generics.middleearth.middleE.MiddleEarthUnit;
//import com.intellekta.generics.middleearth.mordor.CavalryMordor;
//import com.intellekta.generics.middleearth.mordor.MordorUnit;
//import com.intellekta.generics.middleearth.mordor.InfantryMordor;
//
//import java.util.List;
//
//public class Main {
//    public static void main(String[] args) {
//        // Создаем армии с указанием конкретного типа
//        Army<MordorUnit> armyOfMordor = new Army<>();
//        Army<MiddleEarthUnit> armyOfMiddleEarth = new Army<>();
//
//        // создаем кавалеристов Мордора
//        CavalryMordor mordorCav1 = new CavalryMordor("Mordor cav 1");
//        CavalryMordor mordorCav2 = new CavalryMordor("Mordor cav 2");
//        CavalryMordor mordorCav3 = new CavalryMordor("Mordor cav 3");
//        // создаем пехотинцев Мордора
//        InfantryMordor mordorInf1 = new InfantryMordor("Mordor inf 1");
//        InfantryMordor mordorInf2 = new InfantryMordor("Mordor inf 2");
//        InfantryMordor mordorInf3 = new InfantryMordor("Mordor inf 3");
//
//        // создаем кавалеристов MiddleEarth
//        CavalryMiddleEarth middleEarthCav1 = new CavalryMiddleEarth("MiddleEarth cav 1");
//        CavalryMiddleEarth middleEarthCav2 = new CavalryMiddleEarth("MiddleEarth cav 2");
//        CavalryMiddleEarth middleEarthCav3 = new CavalryMiddleEarth("MiddleEarth cav 3");
//        // создаем пехотинцев MiddleEarth
//        InfantryMiddleEarth middleEarthInf1 = new InfantryMiddleEarth("MiddleEarth inf 1");
//        InfantryMiddleEarth middleEarthInf2 = new InfantryMiddleEarth("MiddleEarth inf 2");
//        InfantryMiddleEarth middleEarthInf3 = new InfantryMiddleEarth("MiddleEarth inf 3");
//
//        // проверка добавления в кавалерию Mordor пехотинца Mordor:
////        CavalryMordorClass MordorCav4 = new InfantryMordorClass("Mordor Cav 4"); // не позволяет
//        // проверка добавления в кавалерию Mordor кавалериста MiddleEarth
////        CavalryMordorClass middleEarthCav5 = new CavalryMiddleEarthClass("MiddleEarth cav 5"); // не позволяет
//
//
//        // добавление всех юнитов в армию Мордор:
//        armyOfMordor.recruit(mordorCav1);
//        armyOfMordor.recruit(mordorCav2);
//        armyOfMordor.recruit(mordorCav3);
//
//        armyOfMordor.recruit(mordorInf1);
//        armyOfMordor.recruit(mordorInf2);
//        armyOfMordor.recruit(mordorInf3);
//
//        // добавление всех юнитов в армию MiddleEaarth:
//        armyOfMiddleEarth.recruit(middleEarthCav1);
//        armyOfMiddleEarth.recruit(middleEarthCav2);
//        armyOfMiddleEarth.recruit(middleEarthCav3);
//
//        armyOfMiddleEarth.recruit(middleEarthInf1);
//        armyOfMiddleEarth.recruit(middleEarthInf2);
//        armyOfMiddleEarth.recruit(middleEarthInf3);
//
//        // проверка добавления в армию Мордор кавалериста MiddleEarth
//        System.out.println("проверка добавления в армию Мордор кавалериста MiddleEarth");
////        CavalryMiddleEarthClass middleEarthCav4 = new CavalryMiddleEarthClass("MiddleEarth cav 4");
////        armyOfMordor.recruit(middleEarthCav4); // не позволяет
//
//        // проверка метода getArmy() на получение полных списков армий:
//        System.out.println("проверка метода getArmy() на получение полных списков армий");
//        List<MordorUnit> armMor = armyOfMordor.getArmy();
//        List<MiddleEarthUnit> armME = armyOfMiddleEarth.getArmy();
//
//        // проверка toString на объекте Army
//        System.out.println("проверка toString на объекте Army");
//        System.out.println(armyOfMordor);
//        System.out.println(armyOfMiddleEarth);
//
//        // проверка метода print()
//        System.out.println("проверка метода print()");
//        armyOfMordor.print();
//        armyOfMiddleEarth.print();
//
//        // тестирование метода recruit на null
//        System.out.println("тестирование метода recruit");
//        CavalryMordor mordorCav5 = new CavalryMordor("Mordor cav 5");
//        boolean b1 = armyOfMordor.recruit(mordorCav5);
//        boolean b2 = armyOfMordor.recruit(null);
//        System.out.println(b1);
//        System.out.println(b2);
//
//        armyOfMordor.print();
//        armyOfMiddleEarth.print();
//
//        // тестирование release
//        System.out.println("тестирование release");
//        boolean b3 = armyOfMiddleEarth.release(middleEarthCav1);
//        boolean b4 = armyOfMiddleEarth.release(null);
//        System.out.println(b3);
//        System.out.println(b4);
//        armyOfMordor.print();
//        armyOfMiddleEarth.print();
//
//        // тестирование 2-х getRandomUnit
//        System.out.println("тестирование 2-х getRandomUnit");
//        System.out.println(armyOfMiddleEarth.getRandomUnit());
//        System.out.println(armyOfMiddleEarth.getRandomUnit(middleEarthInf2));
//    }
//}
