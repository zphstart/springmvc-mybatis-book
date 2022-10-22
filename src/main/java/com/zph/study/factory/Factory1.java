package com.zph.study.factory;

import com.zph.study.factory.domain.Bicycle;
import com.zph.study.factory.domain.Bus;
import com.zph.study.factory.domain.Car;
import com.zph.study.factory.domain.Vehicle;

/**
 * @auther zph
 * @date 2022/9/12 - 11:29
 */
public class Factory1 {
    public static Vehicle produce(String type){
        Vehicle vehicle = null;
        if ("car".equals(type)){
            vehicle = new Car();
        }else if ("bus".equals(type)){
            vehicle = new Bus();
        }else{
            vehicle = new Bicycle();
        }
        return vehicle;
    }
}
