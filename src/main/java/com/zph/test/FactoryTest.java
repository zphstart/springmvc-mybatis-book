package com.zph.test;

import org.junit.Test;

import com.zph.study.factory.BicycleFactory;
import com.zph.study.factory.BusFactory;
import com.zph.study.factory.CarFactory;
import com.zph.study.factory.Factory1;
import com.zph.study.factory.domain.Vehicle;

/**
 * @auther zph
 * @date 2022/9/12 - 11:36
 */
public class FactoryTest extends BaseJunit4Test{

    @Test
    public void factory1Test(){
        Vehicle vehicle1 = Factory1.produce("car");
        vehicle1.run();
        Vehicle vehicle2 = Factory1.produce("bus");
        vehicle2.run();
        Vehicle vehicle3 = Factory1.produce("bicycle");
        vehicle3.run();
    }

    @Test
    public void factory2Test(){
        CarFactory carFactory = new CarFactory();
        Vehicle car = carFactory.produce();
        car.run();
        BusFactory busFactory = new BusFactory();
        Vehicle bus = busFactory.produce();
        bus.run();
        BicycleFactory bicycleFactory = new BicycleFactory();
        Vehicle bicycle = bicycleFactory.produce();
        bicycle.run();
    }
}
