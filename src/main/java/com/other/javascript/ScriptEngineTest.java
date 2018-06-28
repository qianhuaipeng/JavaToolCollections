package com.other.javascript;

import javax.script.Invocable;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;
import java.io.FileReader;

/**
 * author: alan.peng
 * description:
 * date: create in 16:45 2018/4/23
 * modified By：
 */
public class ScriptEngineTest {

    public static void main(String[] args) throws Exception{
        ScriptEngineManager manager = new ScriptEngineManager();
        ScriptEngine engine = manager.getEngineByName("javascript");

        String jsFileName = ScriptEngineTest.class.getClassLoader().getResource("/").getPath()+"ScriptEngineTest.class.getClassLoader()";   // 读取js文件
        FileReader reader = new FileReader(jsFileName);   // 执行指定脚本
        engine.eval(reader);

        if(engine instanceof Invocable) {
            Invocable invoke = (Invocable)engine;    // 调用merge方法，并传入两个参数

// c = merge(2, 3);

            Double c = (Double)invoke.invokeFunction("merge", 2, 3);

            System.out.println("c = " + c);
        }

        reader.close();

    }


    public void test(){

    }
}
