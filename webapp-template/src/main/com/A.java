/**
 * Created by zbs on 2017/3/1.
 */
public class A {

    //文件的绝对路径
    String filePath = "";

    public static final Integer images_type = 1;
    public static final Integer text_type = 0;
    public static final Integer effe_status = 1;
    public static final Integer no_effe_status = 0;



    public static void main(String[] args) {

        //导入excel 文件

        //构建B对象

        //生成json

        //保存入库


    }


    public B createB() throws Exception {
        Integer type;
        B b  = new B();
        switch (type){
            case images_type:
                b.setStatus(effe_status);
                b.setImageHeight();
                b.setImageURL();
                b.setImageWidth();
                b.setType(images_type);
                return b;
            case text_type:
                b.setType(text_type);
                b.setStatus(effe_status);
                b.setEditContent();
                return b;
            default:
                throw new Exception("");
        }
    }

}
