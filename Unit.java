package com.intellekta.generics.middleearth;


public interface Unit{
    int getPower();
    String getName();
    boolean isAlive();

    void damage(int powerDamage);

    <A extends Unit>void strike(A unit);
}
