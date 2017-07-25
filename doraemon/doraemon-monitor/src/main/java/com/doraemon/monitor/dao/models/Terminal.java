package com.doraemon.monitor.dao.models;

import lombok.Data;

import javax.persistence.Table;
import javax.persistence.Transient;
import java.util.Date;

@Data
@Table(name = "terminal")
public class Terminal extends TerminalKey {

    private String nick;

    private String deviceType;

    private Date offTime;

    private int warningNum;

    private String status;

    @Transient  //终端可用值
    private double terminalUsability;

    public Terminal(){}
    public Terminal(TerminalKey terminalKey){
        this.setClientIp(terminalKey.getClientIp());
        this.setTerminalIp(terminalKey.getTerminalIp());
    }
}