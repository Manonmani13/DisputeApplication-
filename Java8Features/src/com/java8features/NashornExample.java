package com.java8features;

import javax.script.*;

public class NashornExample {
	public static void main(String[] args) {
		ScriptEngineManager manager=new ScriptEngineManager();
		ScriptEngine engine = manager.getEngineByName("nashorn");

        engine.eval("print('Hello from JavaScript');");
        engine.eval("var x = 10 + 20;");
        engine.eval("print(x);");
	}

}
