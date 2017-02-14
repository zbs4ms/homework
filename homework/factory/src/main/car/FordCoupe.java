package main.car;

/**
 * Created by zbs on 2017/2/12.
 */
public class FordCoupe extends Ford{
    @Override
    public String printName() {
        System.out.println("福克斯");
        return "福克斯";
    }

    @Override
    public String printPrice() {
        System.out.println("价格: 9w - 16w");
        return "价格: 9w - 16w";
    }
}
