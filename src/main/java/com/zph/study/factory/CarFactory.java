package com.zph.study.factory;

import com.zph.study.factory.domain.Car;
import com.zph.study.factory.domain.Vehicle;

/**
 * @auther zph
 * @date 2022/9/12 - 11:42
 */
public class CarFactory implements AbstractVehicleFactory{
    @Override
    public Vehicle produce() {
        return new Car();
    }
}
