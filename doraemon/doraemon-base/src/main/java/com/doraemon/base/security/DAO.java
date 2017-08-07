package com.doraemon.base.security;

import java.lang.annotation.*;

/**
 * Created by zbs on 2017/6/30.
 */
//@Target(ElementType.FIELD) //ElementType.TYPE:用于描述类、接口或enum声明  ElementType.FIELD:用于描述实例变量ElementType.METHODElementType.PARAMETER ElementType.CONSTRUCTOR ElementType.LOCAL_VARIABLE ElementType.ANNOTATION_TYPE 另一个注释ElementType.PACKAGE 用于记录java文件的package信息
//@Retention(RetentionPolicy.RUNTIME) //什么时候使用该注解,RetentionPolicy.SOURCE – 在编译阶段丢弃。这些注解在编译结束之后就不再有任何意义,在类加载的时候丢弃。在字节码文件的处理中有用。RetentionPolicy.RUNTIME– 始终不会丢弃，运行期也保留该注解，因此可以使用反射机制读取该注解的信息
//@Documented  //注解是否将包含在JavaDoc中
public @interface DAO {
}
