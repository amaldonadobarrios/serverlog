package com.serv.microlog.model.entity;

import java.io.Serializable;
import java.util.Map;
import java.util.logging.Logger;

public class LogConfig  implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public  boolean logToFile;
    public  boolean logToConsole;
    public  boolean logMessage;
    public  boolean logWarning;
    public  boolean logError;
    public   boolean logToDatabase;
    public boolean initialized;
    public  String logFileFolder;
    public static Logger logger;
	
    
    public String messageText;
    public boolean message;
    public boolean warning;
    public boolean error;
    
    public LogConfig() {
    	logger = Logger.getLogger("MyLog");
    }
    
    
    
    public String getMessageText() {
		return messageText;
	}
	public void setMessageText(String messageText) {
		this.messageText = messageText;
	}
	public boolean isMessage() {
		return message;
	}
	public void setMessage(boolean message) {
		this.message = message;
	}
	public boolean isWarning() {
		return warning;
	}
	public void setWarning(boolean warning) {
		this.warning = warning;
	}
	public boolean isError() {
		return error;
	}
	public void setError(boolean error) {
		this.error = error;
	}

	public String getLogFileFolder() {
		return logFileFolder;
	}
	public void setLogFileFolder(String logFileFolder) {
		this.logFileFolder = logFileFolder;
	}
	
	public boolean isLogToFile() {
		return logToFile;
	}



	public void setLogToFile(boolean logToFile) {
		this.logToFile = logToFile;
	}



	public boolean isLogToConsole() {
		return logToConsole;
	}



	public void setLogToConsole(boolean logToConsole) {
		this.logToConsole = logToConsole;
	}



	public boolean isLogMessage() {
		return logMessage;
	}



	public void setLogMessage(boolean logMessage) {
		this.logMessage = logMessage;
	}



	public boolean isLogWarning() {
		return logWarning;
	}



	public void setLogWarning(boolean logWarning) {
		this.logWarning = logWarning;
	}



	public boolean isLogError() {
		return logError;
	}



	public void setLogError(boolean logError) {
		this.logError = logError;
	}



	public boolean isLogToDatabase() {
		return logToDatabase;
	}



	public void setLogToDatabase(boolean logToDatabase) {
		this.logToDatabase = logToDatabase;
	}



	public boolean isInitialized() {
		return initialized;
	}



	public void setInitialized(boolean initialized) {
		this.initialized = initialized;
	}



	public static Logger getLogger() {
		return logger;
	}
	public static void setLogger(Logger logger) {
		LogConfig.logger = logger;
	}
    
    
}
