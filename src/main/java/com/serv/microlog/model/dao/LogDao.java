package com.serv.microlog.model.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.serv.microlog.model.entity.Log;

public interface LogDao extends JpaRepository<Log, Long> {

}
