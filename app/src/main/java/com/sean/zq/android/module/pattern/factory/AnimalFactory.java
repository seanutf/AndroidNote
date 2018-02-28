package com.sean.zq.android.module.pattern.factory;

/**
 * Created by sean on 2017/11/22.
 *
 * 工厂模式的学习
 */

public abstract class AnimalFactory {

    //private AnimalFactory(){}

    public abstract Animal createAnimal();

    public static Dog createDog(){
        return new Dog();
    }

    public static Cat createCat(){
        return new Cat();
    }

    public static Animal createAnimal(String type){
        if(type.equals("cat")){
            return new Cat();
        }else if (type.equals("dog")){
            return new Dog();
        }

        return null;
    }
}
