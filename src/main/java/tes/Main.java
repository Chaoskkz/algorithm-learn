package tes;

import digui.F2;
import digui.F3;
import digui.Fa;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * @author masun
 * @date 2021/12/3
 */
public class Main {

    public static void main(String[] args) {
        long l1 = System.currentTimeMillis();
//        System.out.println(FeiBo.fei(80));
        System.out.println(Fa.findWay(1, 1));
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", l2 - l1);

    }

    @Test
    public void test1() {
        long l1 = System.currentTimeMillis();
//        System.out.println(FeiBo.fei(80));
        System.out.println(F2.getMax(0, 0));
        long l2 = System.currentTimeMillis();
        System.out.printf("%s ms", l2 - l1);
    }

    @Test
    public void test2() {
        System.out.println(F3.fin(8, 100));
        F3.f();
    }
}