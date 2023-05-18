package com.intellekta.generics.middleearth;

import com.intellekta.generics.middleearth.middleE.MiddleEarthUnit;
import com.intellekta.generics.middleearth.mordor.MordorUnit;
import com.intellekta.generics.middleearth.troopType.Cavalry;
import com.intellekta.generics.middleearth.troopType.Infantry;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army<A extends Unit> {
    // А - тип воюющей стороны
    // Т - тип войска (кавалерия / пехота

    private List<A> listOfCavalry;
    private List<A> listOfInfantry;

    public List<A> getCavalry(){
        return listOfCavalry;
    }
    public List<A> getInfantry(){
        return listOfInfantry;
    }

    public List<A> getArmy(){
        List<A> listOfArmy = new ArrayList<>();
        if(listOfCavalry != null){
            listOfArmy.addAll(listOfCavalry);
        }
        if(listOfInfantry != null){
            listOfArmy.addAll(listOfInfantry);
        }
        return listOfArmy;
    }

    public boolean recruit(A unit){
        boolean result = false;
        if(unit instanceof Cavalry){
            if (this.listOfCavalry == null) this.listOfCavalry = new ArrayList<>();
            int listLengthBefore = listOfCavalry.size();
            listOfCavalry.add(unit);
            int listLengthAfter = listOfCavalry.size();
            result = listLengthBefore < listLengthAfter ? true : false;
        }
        if(unit instanceof Infantry){
            if (this.listOfInfantry == null) this.listOfInfantry = new ArrayList<>();
            int listLengthBefore = listOfInfantry.size();
            listOfInfantry.add(unit);
            int listLengthAfter = listOfInfantry.size();
            result = listLengthBefore < listLengthAfter ? true : false;
        }
        return result;
    }

    public void print(){
        System.out.println(this.toString());
    }

    public boolean release(A unit){
        boolean result = false;
        if(unit instanceof Cavalry){
            if(listOfCavalry != null){
                int listLengthBefore = listOfCavalry.size();
                listOfCavalry.remove(unit);
                int listLengthAfter = listOfCavalry.size();
                result = listLengthBefore > listLengthAfter ? true : false;
            }
        }
        if(unit instanceof Infantry){
            if(listOfInfantry != null){
                int listLengthBefore = listOfInfantry.size();
                listOfInfantry.remove(unit);
                int listLengthAfter = listOfInfantry.size();
                result = listLengthBefore > listLengthAfter ? true : false;
            }
        }
        return result;
    }

    public Unit getRandomUnit(){
        Unit unit;
        Random random = new Random();
        List<A> listOfArmy = this.getArmy();
        int rnd = random.nextInt(listOfArmy.size());
        unit = listOfArmy.get(rnd);
        return unit;
    }

    public Unit getRandomUnit(A unit){
        Random random = new Random();
        Unit result = null;
        if(unit instanceof Cavalry){
            if(listOfCavalry != null || listOfCavalry.size() != 0){
                int randomUnit = random.nextInt(listOfCavalry.size());
                result = listOfCavalry.get(randomUnit);
            }
        }
        if (unit instanceof Infantry){
            if(listOfInfantry != null || listOfInfantry.size() != 0){
                int randomUnit = random.nextInt(listOfInfantry.size());
                result = listOfInfantry.get(randomUnit);
            }
        }
        return result;
    }

    @Override
    public String toString() {
        String s = "\nArmy of";
        if(this.getRandomUnit() instanceof MordorUnit){
            s += " {MordorUnit} ";
        }
        if(this.getRandomUnit() instanceof MiddleEarthUnit){
            s += " {MiddleEarthUnit} ";
        }
        s += "consist of:\n";
        for(Unit x : this.getArmy()){
            s += x;
            s += "\n";
        }
        return s;
    }

    public void printWinner(int i, List<A> incomingList){
        String s = "\nArmy of";
        if(this.getRandomUnit() instanceof MordorUnit){
            s += " {MordorUnit} ";
        }
        if(this.getRandomUnit() instanceof MiddleEarthUnit){
            s += " {MiddleEarthUnit} ";
        }
        s += "has won the ";
        if(i == 1 || i == 2) s += "{" + i + "} phase.";
        if(i == 3)  s += "battle. ";
        s += "The winners list:\n" ;
        List<A> list = new ArrayList<>();
        if(incomingList.get(0) instanceof Cavalry){
            list = this.getCavalry();
        }
        if(incomingList.get(0) instanceof Infantry){
            list = this.getInfantry();
        }
        for(A x : list){
            s += x;
            s += "\n";
        }
        System.out.println(s);
    }
}
