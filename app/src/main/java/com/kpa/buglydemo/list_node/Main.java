package com.kpa.buglydemo.list_node;

import java.util.concurrent.LinkedBlockingDeque;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * author: mr.kong
 * Date:2018/11/6
 * description:
 * project name:BuglyDemo
 **/
public class Main {
    final ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(3, 10, 1 * 1000, TimeUnit.SECONDS
            , new LinkedBlockingDeque<Runnable>(100));

    public static void main(String[] args) {

    }


}
