package com.serv.microlog.test;

import java.util.HashMap;
import java.util.Map;

public class TestDemo {

	public static void main(String[] args) throws Exception {
		
		Map<String, String> db = new HashMap<String, String>();
		db.put("dbms", "h2:tcp");
		db.put("portNumber", "~/test");
		db.put("serverName", "localhost");
		db.put("userName", "root");
		db.put("password", "secret");
		db.put("logFileFolder", "D:\\app");
		
		Demo d= new Demo(true, true, true, true, true, true, db);
		
		d.LogMessage("HOLA SOY ERROR TEST", true,true, true);
	}

}
