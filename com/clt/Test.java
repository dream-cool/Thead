package com.clt;


import java.util.ArrayList;
import java.util.List;

/**
 * @ Author   ：clt.
 * @ Date     ：Created in 18:35 2019/7/15
 */
public class Test {

    @org.junit.Test
    public void test(){
        System.out.println(1);
//        var声明 new Obejct().var
        final Object o = new Object();
//        null判断  o.null  || o.nn ||o.notnull
        if (o == null) {
            if (o != null) {
                if (o != null) {

                }
            }
        }
//        if判断 o!=null.if
        if (o != null) {

        }
//        增加for循环遍历, ls.for
        List<String> ls = new ArrayList<>(1);
        for (String l : ls) {
            System.out.println(l);
        }
//        fori
        for (int i = 0; i < 100; i++) {

        }
//        强转： 数据.cast    返回值.return

    }
}
