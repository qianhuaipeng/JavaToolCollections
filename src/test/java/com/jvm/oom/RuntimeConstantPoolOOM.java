package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 *  运行时常量池导致的内存溢出异常
 * @author alan.peng
 * @date 2017-12-07 20:25
 */
public class RuntimeConstantPoolOOM {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        int i = 0;
        while (true){
            System.out.println(i++);
            list.add(String.valueOf(i++).intern());
        }
    }
}
