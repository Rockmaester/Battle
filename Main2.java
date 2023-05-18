//package com.intellekta.generics.middleearth;
//
//import com.intellekta.generics.middleearth.middleE.MiddleEarthUnit;
//import com.intellekta.generics.middleearth.mordor.MordorUnit;
//import com.intellekta.generics.middleearth.troopType.Cavalry;
//import com.intellekta.generics.middleearth.troopType.Infantry;
//import com.intellekta.generics.middleearth.unitClasses.*;
//
//
//public class Main2 {
//    public static void main(String[] args) {
//
//        // Создали армии, уточнили воюющую сторону, теперь A = воюющая сторона
//        Army<MordorUnit> armyOfMordor = new Army<>();
//        Army<MiddleEarthUnit> armyOfMiddleEarth = new Army<>();
//
//        // создали человека на лошади, уточнили у него принадлежность к воюющей стороне
//        System.out.println("\nсоздали человека на лошади");
//        HumanCavalryClass human1_withHorse = new HumanCavalryClass("Human 1 (кавалерист)");
//
//        // проверили метод isAlive()
//        System.out.println("\nпроверили метод isAlive()");
//        System.out.println("human1_withHorse.isAlive(): " + human1_withHorse.isAlive());
//
//        System.out.println("\nПроверка принадлежности human 1 к кавалерии / пехоте");
//        System.out.println("Кавалерия? " + (human1_withHorse instanceof Cavalry));
//        System.out.println("Перхота? " + (human1_withHorse instanceof Infantry));
//
//        // создали человека без лошади
//        System.out.println("\nсоздали человека без лошади");
//        HumanInfantryClass human2_alone = new HumanInfantryClass("human2(alone)");
////        HumanInfantryClass<MiddleEarthUnit> human2_alone = new HumanInfantryClass<>(null);
//        System.out.println(human2_alone.toString());
//
//        System.out.println("\nПроверка принадлежности human 2 к кавалерии / пехоте");
//        System.out.println("Кавалерия? " + (human2_alone instanceof Cavalry));
//        System.out.println("Перхота? " + (human2_alone instanceof Infantry));
//
//        System.out.println("\nСоздали гобблина, орка и тролля, все пехотинцы");
//        TrollClass troll1 = new TrollClass("Troll 1");
//        OrcInfantryClass orc1 = new OrcInfantryClass("Orc 1");
//        GobblinClass gobblin1 = new GobblinClass("Gobblin 1");
//
//        System.out.println("\nЧеловек без лошади атакует троля");
//        human2_alone.strike(troll1);
//        System.out.println("troll1.isAlive(): " + troll1.isAlive());
//        human2_alone.strike(troll1);
//        System.out.println("troll1.isAlive(): " + troll1.isAlive());
//        human2_alone.strike(troll1);
//        System.out.println("troll1.isAlive(): " + troll1.isAlive());
//
//        // проверка логики атаки всадника
//        System.out.println("\nГобблин атакует человека на лошади, сила удара = " + gobblin1.getPower());
//        System.out.println("Жизнь лошади до атаки: " + human1_withHorse.getHorse().toString());
//        System.out.println("Жизнь человека до атаки: " + human1_withHorse.toString());
//        gobblin1.strike(human1_withHorse);
//        System.out.println("Жизнь лошади после атаки: " + human1_withHorse.getHorse().toString());
//        System.out.println("Жизнь человека после атаки: " + human1_withHorse.toString());
//        System.out.println("Гобблин атакует человека на лошади");
//        gobblin1.strike(human1_withHorse);
//        System.out.println("Жизнь лошади после атаки: " + human1_withHorse.getHorse().toString());
//        System.out.println("Жизнь человека после атаки: " + human1_withHorse.toString());
//        System.out.println("Гобблин атакует человека на лошади");
//        gobblin1.strike(human1_withHorse);
//        System.out.println("Жизнь лошади после атаки: " + human1_withHorse.getHorse().toString());
//        System.out.println("Жизнь человека после атаки: " + human1_withHorse.toString());
//        System.out.println("Гобблин атакует человека на лошади");
//        gobblin1.strike(human1_withHorse);
//        System.out.println("Жизнь лошади после атаки: " + human1_withHorse.getHorse().toString());
//        System.out.println("Жизнь человека после атаки: " + human1_withHorse.toString());
//
//
//        System.out.println("\nТестирование дженериков: создали армии, рекрутировали юнитов");
//
//
//        armyOfMordor.recruit(troll1);
//        armyOfMordor.recruit(orc1);
//        armyOfMiddleEarth.recruit(human2_alone);
//
//        TrollClass troll2 = new TrollClass("Troll 2");
//
//        System.out.println("troll1 before: " + troll2.toString());
//        orc1.strike(troll2);
//        System.out.println("troll1 after: " + troll2.toString());
//        System.out.println("human2_alone before: " + human2_alone.toString());
//        orc1.strike(human2_alone);
//        System.out.println("human2_alone after: " + human2_alone.toString());
//    }
//
//}
