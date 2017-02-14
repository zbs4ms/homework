package main.car;

/**
 * Created by zbs on 2017/2/12.
 */
public class HondaCoupe extends Honda{

    @Override
    public String printName() {
            System.out.println("思域");
        return "思域";
    }

    @Override
    public String printPrice() {
        System.out.println("价格: 12w - 16w");
        return "价格: 12w - 16w";
    }
}
