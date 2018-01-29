package com.jvm.oom;

import java.util.ArrayList;
import java.util.List;

/**
 * @author alan.peng
 * @date 2017-12-20 19:03
 */
public class HeapOOM {

    static class OOMObject{

    }

    public static void main(String[] args) {
        List<OOMObject> list = new ArrayList<OOMObject>();
        while (true){
            list.add(new OOMObject());
        }
    }
}
