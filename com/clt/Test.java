package com.clt;


import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/**
 * @ Author   ��clt.
 * @ Date     ��Created in 18:35 2019/7/15
 */
public class Test {

    @org.junit.Test
    public void test() {
        System.out.println(1);
//        var���� new Obejct().var
        final Object o = new Object();
//        null�ж�  o.null  || o.nn ||o.notnull
        if (o == null) {
            if (o != null) {
                if (o != null) {

                }
            }
        }
//        if�ж� o!=null.if
        if (o != null) {

        }
//        ����forѭ������, ls.for
        List<String> ls = new ArrayList<>(1);
        for (String l : ls) {
            System.out.println(l);
        }
//        fori
        for (int i = 0; i < 100; i++) {

        }
//        ǿת�� ����.cast    ����ֵ.return
    }

    @org.junit.Test
    public void test1() {
        ConcurrentMap<String, Integer> map = new ConcurrentHashMap<>();
        for (int i = 0; i < 5; i++) {
            String s = i + "i";
            map.put(s, i);
        }
    }

    @org.junit.Test
    public void test2() {
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < 100; i++) {
            String s = i + "i";
            map.put(s, i);
        }
    }

    @org.junit.Test
    public void test3() {
        String s1 = new String("ͨ��");
        String s2 = new String("ͨ��");
        System.out.println(s1.hashCode() + "-----" + s2.hashCode());
        System.out.println(s1 == s2);
    }

    @org.junit.Test
    public void test4(){
        Integer[] arr = new Integer[10];
        for (int i = 0; i < 5; i++) {
            arr[i] = i;
        }
        List<Integer> list =  Arrays.asList(arr);
        System.out.println(list);
        arr[1] = 5;
        System.out.println(list);
        list.set(7,7);
        System.out.println(Arrays.toString(arr));
    }

    @org.junit.Test
    public void test5(){

        List<Integer> ls = new ArrayList<>();
        for (int i = 0; i < 5; i++) {
            ls.add(i);
        }
        Object[] arr = ls.toArray();
        arr[2] = 20;
        ls.add(10);
        System.out.println("�б�"+ls);
        System.out.println("���飺"+Arrays.toString(arr));
        while (true){

        }
    }


}
