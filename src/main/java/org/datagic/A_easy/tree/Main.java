package org.datagic.A_easy.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Desc:
 * Author: datagic (云瞻)
 * CreateDate: 2020/8/20 10:22 上午
 * Blog: datagic.top
 * 公众号: datagator (大数据领航员)
 */
public class Main {
    public static void main(String[] args) throws Exception {
        List t = new ArrayList<>();
        t.add(111);

        for (int i = 0; i < t.size(); i++) {
            t.add(222);
            System.out.println(11);
            Thread.sleep(1000);
        }
    }
}
