package main.car;

/**
 * Created by zbs on 2017/2/12.
 */
public  class FordMidsizeCar extends Ford {

    @Override
    public String printName() {
        System.out.println("蒙迪欧");
        return "蒙迪欧";
    }

    @Override
    public String printPrice() {
        System.out.println("价格: 17w - 31w");
        return "价格: 17w - 31w";
    }
}
