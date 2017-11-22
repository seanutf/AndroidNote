package com.sean.zq.android.utils.pattern.factory;


/**
 * Created by Sean on 2017/11/22.
 *
 */

public class FactoryTest {
    public void getFF(){
        Animal animal = AnimalFactory.createAnimal("dog");
        animal.eat();
        animal = AnimalFactory.createAnimal("cat");
        animal.eat();

        AnimalFactory animalFactory = new DogFactory();
        Animal animal1 = animalFactory.createAnimal();
        animal1.eat();
    }
}
