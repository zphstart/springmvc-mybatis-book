package com.zph.study.factory;

import com.zph.study.factory.domain.Bicycle;
import com.zph.study.factory.domain.Vehicle;

/**
 * @auther zph
 * @date 2022/9/12 - 11:43
 */
public class BicycleFactory implements AbstractVehicleFactory{
    @Override
    public Vehicle produce() {
        return new Bicycle();
    }
}
