package com.serv.microlog.model.service;

import com.serv.microlog.model.entity.LogConfig;

public interface LogService {

	public String grabarlog(LogConfig config ) throws Exception;
}
