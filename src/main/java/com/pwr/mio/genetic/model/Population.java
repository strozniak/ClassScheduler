package com.pwr.mio.genetic.model;

/**
 * Created by Piotr on 07.12.13.
 */
public interface Population {

    public void generatePopulation();

    Schedule getBest();

    void estimatePopulation();

    void cross();

    void mutate();

    void chooseParents();
}
