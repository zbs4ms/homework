package com.doraemon.monitor.dao.models;

import lombok.Data;
import javax.persistence.Id;
@Data
public class TerminalKey {

    private String clientIp;

    private String terminalIp;

}