package com.serv.microlog.controller;

import java.util.logging.Logger;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.serv.microlog.model.entity.LogConfig;
import com.serv.microlog.model.service.LogService;

@RestController
@RequestMapping(value="/log")
public class SendLog {
	
	@Autowired
	LogService service;
	
	
	@PostMapping(value="/send")
	public String guardarlog(@RequestBody final LogConfig log ){


		String respuesta = null;
		try {
			respuesta=service.grabarlog(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}
	
	@GetMapping(value="/test")
	public String testlog(){
		
		LogConfig log =new LogConfig();
		log.setError(true);
		log.setInitialized(true);
		log.setLogFileFolder("D:\\app");
		log.setMessage(false);
		log.setMessageText("ERROR EN MODULO CLIENTE");
		log.setWarning(false);
		log.setLogError(true);
		log.setLogMessage(true);
		log.setLogToConsole(true);
		log.setLogToDatabase(true);
		log.setLogToFile(true);
		log.setLogWarning(true);
		
		
		
		String respuesta = null;
		try {
			respuesta=service.grabarlog(log);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return respuesta;
	}


}
