package com.serv.microlog.model.service;

import java.io.File;
import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.logging.ConsoleHandler;
import java.util.logging.FileHandler;
import java.util.logging.Level;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.serv.microlog.model.dao.LogDao;
import com.serv.microlog.model.entity.Log;
import com.serv.microlog.model.entity.LogConfig;
@Service
public class LogServiceImpl implements LogService {

	@Autowired
	LogDao dao;
	



	@Override
	public String grabarlog(LogConfig config) throws Exception {
String mensaje=null;
		

config.messageText.trim();
if (config.messageText == null || config.messageText.length() == 0) {
    return "error mensaje vacio";
}
if (!config.logToConsole && !config.logToFile && !config.logToDatabase) {
    throw new Exception("Invalid configuration");
}
if ((!config.logError && !config.logMessage && !config.logWarning) || (!config.message && !config.warning && !config.error)) {
    throw new Exception("Error or Warning or Message must be specified");
}



int t = 0;
if (config.message && config.logMessage) {
    t = 1;
}

if (config.error && config.logError) {
    t = 2;
}

if (config.warning && config.logWarning) {
    t = 3;
}


String l = null;
File logFile = new File(config.getLogFileFolder() + "/logFile.txt");
if (!logFile.exists()) {
    logFile.createNewFile();
}

FileHandler fh = new FileHandler(config.getLogFileFolder() + "/logFile.txt");
ConsoleHandler ch = new ConsoleHandler();

if (config.error && config.logError) {
    l = l + "error " + DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + config.messageText;
}

if (config.warning && config.logWarning) {
    l = l + "warning " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + config.messageText;
}

if (config.message && config.logMessage) {
    l = l + "message " +DateFormat.getDateInstance(DateFormat.LONG).format(new Date()) + config.messageText;
}

if(config.logToFile) {
	config.logger.addHandler(fh);
	config.logger.log(Level.INFO, config.messageText);
}

if(config.logToConsole) {
	config.logger.addHandler(ch);
	config.logger.log(Level.INFO, config.messageText);
}

if(config.logToDatabase) {
   Log ocurrencia= new Log();
   ocurrencia.setMensaje(config.messageText);
   ocurrencia.setPrioridad(String.valueOf(t));
   try {
		dao.save(ocurrencia);
		mensaje="LOG REGISTRADO CORRECTAMENTE EN BD";
	} catch (Exception e) {
		mensaje="ERROR AL REGISTRAR EL LOG EN BD";
	}
}
return mensaje;	
	}

}
