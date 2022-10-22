package com.zph.study.factory;

import com.zph.study.factory.domain.Bus;
import com.zph.study.factory.domain.Vehicle;

/**
 * @auther zph
 * @date 2022/9/12 - 11:43
 */
public class BusFactory implements AbstractVehicleFactory{
    @Override
    public Vehicle produce() {
        return new Bus();
    }
}
