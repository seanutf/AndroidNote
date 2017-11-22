package com.sean.zq.android.utils.pattern.factory;

/**
 * Created by sean on 2017/11/22.
 *
 */

public class DogFactory extends AnimalFactory{

    @Override
    public Animal createAnimal() {
        return new Dog();
    }
}
