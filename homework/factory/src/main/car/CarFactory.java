package main.car;

/**
 * Created by zbs on 2017/2/12.
 */
public class CarFactory {

    public static Car create(String name) throws Exception {
        try {
            String className = "main.car." + name;
            Class<Car> carClass = (Class<Car>) Class.forName(className);
            return carClass.newInstance();
        }catch (Exception e){
            throw new Exception("创建实例失败.");
        }
    }
}
