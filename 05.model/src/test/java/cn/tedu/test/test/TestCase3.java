package cn.tedu.test.test;

import org.assertj.core.util.Compatibility;
import org.junit.Test;

/**
 * Created by Administrator on 17.11.9.
 */
public class TestCase3 {
    private String s;
    @Test
    public void test() {
        System.out.println(System.getProperty("user.dir"));
        Street street=new Street();
        street.setVehicle(new Car());
        street.run();
    }
    @Test
    public void test1(){
        System.getProperties();
        System.out.println(System.getenv());
        System.out.println(System.getenv("COMPUTERNAME"));

    }

}
abstract class Road{
    protected Vehicle vehicle;

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    abstract void run();
}
class SpeedRoad extends Road{

    @Override
    public void run() {
        vehicle.run();
        System.out.println("在高速路上");
    }
}
class Street  extends Road{

    @Override
    public void run() {
        vehicle.run();
        System.out.println("在大街上");
    }
}
abstract class Vehicle{
    public abstract void run();
}
class Bus extends Vehicle{

    @Override
    public void run() {
        System.out.println("公共汽车");
    }
}
class Car extends Vehicle{

    @Override
    public void run() {
        System.out.println("私家车");
    }
}
