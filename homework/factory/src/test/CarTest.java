package test;

import main.car.Car;
import main.car.CarFactory;
import org.junit.Assert;
import org.junit.Test;

/**
 * Created by zbs on 2017/2/12.
 */

public class CarTest {

    @Test
    public void createCarTest() throws Exception {
        Car hc = CarFactory.create("HondaCoupe");
        Car hmc = CarFactory.create("HondaMidsizeCar");
        Car fc = CarFactory.create("FordCoupe");
        Car fmc = CarFactory.create("FordMidsizeCar");
        Assert.assertNotNull(hc);
        Assert.assertNotNull(hmc);
        Assert.assertNotNull(fc);
        Assert.assertNotNull(fmc);
        Assert.assertEquals("思域",hc.printName());
        Assert.assertEquals("奥德赛",hmc.printName());
        Assert.assertEquals("福克斯",fc.printName());
        Assert.assertEquals("蒙迪欧",fmc.printName());
    }
}
