import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by zbs on 2017/2/28.
 */
public class Amain {

    public static void main(String[] args) {
        Integer aaaa  = 10000;
        Integer req  = aaaa;

        List<Integer> arrayList = new ArrayList<>();
        Random random = new Random();
        int num = random.nextInt(100000);
        for(int i=0;i<num;i++) {
            arrayList.add(i);
        }
        System.out.println("list长度为:"+arrayList.size());

        List<P> b = new ArrayList<>();
        int tail = 0;
        for(int j =0;j<arrayList.size();j++) {
            tail = tail+1;
            Integer value = arrayList.get(j);
            if(j%100 == 0) {
                P p = new P();
                p.setValue(value);
                p.setLocation(j);
                b.add(p);
                tail = 0;
            }
        }
        System.out.println("按100进行跳跃,剩余:"+tail);
        int k = tail/100;
        P p = b.get(b.size()-1 - k);
        System.out.println("倒数"+aaaa+"位的数值是:"+arrayList.get(p.getLocation()+tail-req));

    }
}
