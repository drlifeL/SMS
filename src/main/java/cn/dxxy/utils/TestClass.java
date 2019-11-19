package cn.dxxy.utils;

import java.util.Arrays;
import java.util.List;

public class TestClass {

    public static void main(String[] args) {
        String s = "abc";
        a(s);
        System.out.println(s);
        Integer[] arr = new Integer[]{1, 2, 3, 4};
        List<Integer> integers = Arrays.asList(arr);
        String sarr[] = new String[]{"anc", "bcs", "abd"};
        List<String> strings = Arrays.asList(sarr);
        String[] array = strings.toArray(new String[10]);
        for (String s1 : array) {
            System.out.println("hhh" + s1);
        }
        System.out.println(array.length);


    }

    public static void a(String s) {
        s = "bdc";
    }
}
