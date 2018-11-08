package com.kpa.buglydemo;

import android.util.Log;

import java.util.ArrayList;
import java.util.List;

/**
 * author: mr.kong
 * Date:2018/10/30
 * description:
 * project name:BuglyDemo
 **/
public class Test {

    public static void main(String[] args) {
        int[] array = {1, 4, 5, 4, 2, 6, 45, 23, 12};
//        sort(array);
        for (int i : sort1(array)) {
            System.out.print(i + "\t");
        }

    }

    private static int[] sort1(int[] array) {
        int j, k = array.length;
        boolean flag = true;
        while (flag) {
            flag = false;
            for (j = 1; j < k; j++) {
                if (array[j - 1] > array[j]) {
                    int tmp = array[j - 1];
                    array[j - 1] = array[j];
                    array[j] = tmp;
                    flag = true;
                }
            }
            k--;
        }
        return array;
    }

    private static void sort(int[] array) {
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if (array[j] > array[j + 1]) {
                    int tmp = array[j];
                    array[j] = array[j + 1];
                    array[j + 1] = tmp;
                }
            }
        }
    }
}
