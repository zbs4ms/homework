package main.car;

/**
 * Created by zbs on 2017/2/12.
 */
public class HondaMidsizeCar extends Honda{
    @Override
    public String printName() {
        System.out.println("奥德赛");
        return "奥德赛";
    }

    @Override
    public String printPrice() {
        System.out.println("价格: 22w - 28W");
        return "价格: 22w - 28W";
    }
}
