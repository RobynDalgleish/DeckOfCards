package com.robyn.project.cards.v2;

import java.util.Collection;

public abstract class Hand<C extends PlayingCard, T extends Collection<C>> {

    protected T hand;

    public abstract void addCard(C card);
}
