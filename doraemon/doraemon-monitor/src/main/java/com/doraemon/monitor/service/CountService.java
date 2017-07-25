package com.doraemon.monitor.service;

import com.doraemon.monitor.controller.protocol.PagePro;
import com.doraemon.monitor.dao.mapper.ClientMapper;
import com.doraemon.monitor.dao.mapper.MonitorLogMapper;
import com.doraemon.monitor.dao.mapper.TerminalMapper;
import com.doraemon.monitor.dao.models.Client;
import com.doraemon.monitor.dao.models.MonitorLog;
import com.doraemon.monitor.dao.models.Terminal;
import com.doraemon.monitor.util.DateTool;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import lombok.Data;
import lombok.extern.log4j.Log4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.*;

/**
 * Created by zbs on 2017/7/19.
 */
@Service
@Log4j
public class CountService {

    @Autowired
    MonitorLogMapper monitorLogMapper;
    @Autowired
    TerminalMapper terminalMapper;
    @Autowired
    ClientMapper clientMapper;
    @Autowired
    ConfigService configService;
    @Autowired
    MessageSerive messageSerive;


    /**
     * 可用值计算公式
     *
     * @param errorTime
     * @param deviceNumber
     * @param days
     * @return
     */
    private double usability(long errorTime, int deviceNumber, int days) {
        double value = 1 - (errorTime / deviceNumber * 10 * 60 * days);
        BigDecimal bvalue = new BigDecimal(value);
        return bvalue.setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

    private ErrorTime selectMessage(String clientIp, Date startDate, Date stopDate) {
        List<MonitorLog> monitorLogList = messageSerive.queryByIpAndTime(clientIp, startDate, stopDate);
        Map<String, MonitorLog> errorTerminal = new HashMap<>();
        Map<String, Long> clientErrorTime = new HashMap<>();
        Map<String, Long> terminalErrorTime = new HashMap<>();
        for (MonitorLog monitorLog : monitorLogList) {
            //初始化
            if (clientErrorTime.get(monitorLog.getClientIp()) == null)
                clientErrorTime.put(monitorLog.getClientIp(), 0L);
            if (terminalErrorTime.get(getTerminalKey(monitorLog)) == null)
                terminalErrorTime.put(getTerminalKey(monitorLog), 0L);
            //统计
            if (monitorLog.getStatus().equals("-1")) {
                if (errorTerminal.get(getTerminalKey(monitorLog)) == null)
                    errorTerminal.put(getTerminalKey(monitorLog), monitorLog);
            }else{
                totalByMonitorLog(errorTerminal,clientErrorTime,terminalErrorTime,monitorLog);
            }
        }
        //如果最后还有没被移除掉的,也就是统计的时候还未恢复的.
        for(Map.Entry<String, MonitorLog> entry : errorTerminal.entrySet()){
            MonitorLog monitorLog = entry.getValue();
            total(clientErrorTime,terminalErrorTime,monitorLog.getClientIp(),getTerminalKey(monitorLog),diffTime(startDate,new Date()));
            errorTerminal.remove(getTerminalKey(monitorLog));
        }
        return new ErrorTime(clientErrorTime,terminalErrorTime);
    }


    public PageInfo<Client> totalClientErrorTime(String clientIp,Date startDate, Date stopDate,PagePro pagePro){
        PageHelper.startPage(pagePro.getPage(), pagePro.getRow());
        List<Client> clientList = clientIp == null ?
                clientMapper.selectAll() :
                new ArrayList<>(Arrays.asList(clientMapper.selectByPrimaryKey(clientIp)));
        if(clientList == null || clientList.size()<1)
            return null;
        ErrorTime errorTime = selectMessage(clientIp,startDate,stopDate);
        Map<String, Long> clientErrorTime = errorTime.getClientErrorTime();
        Map<String, Long> terminalErrorTime = errorTime.getTerminalErrorTime();
        for(Client client : clientList){
            client.setClientUsability(clientErrorTime.get(client.getIp()));
            List<Terminal> terminalList = client.getTerminalList();
            for(Terminal terminal : terminalList){
                terminal.setTerminalUsability(terminalErrorTime.get(getTerminalKey(client.getIp(),terminal.getTerminalIp())));
            }
        }
        return new PageInfo<>(clientList);
    }

    /**
     * 获取MonitorLog中的terminal的命名,规则为 clientIp_terminalIp
     * @param monitorLog
     * @return
     */
    private String getTerminalKey(MonitorLog monitorLog){
        return monitorLog.getClientIp() + "_" + monitorLog.getTerminalIp();
    }

    private String getTerminalKey(String clientIp,String terminalIp){
        return clientIp + "_" + terminalIp;
    }

    /**
     * 统计异常时间
     * @param errorTerminal
     * @param clientErrorTime
     * @param terminalErrorTime
     * @param monitorLog
     */
    private void totalByMonitorLog(Map<String, MonitorLog> errorTerminal,Map<String, Long> clientErrorTime,Map<String, Long> terminalErrorTime,MonitorLog monitorLog){
        if(errorTerminal.get(getTerminalKey(monitorLog)) != null) {
            Date errorStartTime =  errorTerminal.get(getTerminalKey(monitorLog)).getCreateTime();
            Date errorEndTime = monitorLog.getCreateTime();
            total(clientErrorTime,terminalErrorTime,monitorLog.getClientIp(),getTerminalKey(monitorLog),diffTime(errorStartTime,errorEndTime));
            errorTerminal.remove(getTerminalKey(monitorLog));
        }
    }

    /**
     * 计算异常时间
     * @param errorStartTime
     * @param errorEndTime
     * @return
     */
    private long diffTime(Date errorStartTime , Date errorEndTime){
        //如果不大于5分钟算0分钟
        long diffTime = DateTool.create().diffMinute(errorStartTime,errorEndTime)<5?
                0L : DateTool.create().diffMinute(errorStartTime,errorEndTime) ;
        return diffTime;
    }

    /**
     * 合计门店的异常时间 和 合计终端的异常时间
     * @param clientErrorTime
     * @param terminalErrorTime
     * @param clientIp
     * @param terminalKey
     * @param diffTime
     */
    private void total(Map<String, Long> clientErrorTime,Map<String, Long> terminalErrorTime,String clientIp,String terminalKey,long diffTime){
        //合计门店的异常时间
        clientErrorTime.put(clientIp,clientErrorTime.get(clientIp)+ diffTime);
        //合计终端的异常时间
        terminalErrorTime.put(terminalKey,terminalErrorTime.get(terminalKey)+ diffTime);
    }

    @Data
    class ErrorTime{

        public ErrorTime(){}

        public ErrorTime(Map<String, Long> clientErrorTime,Map<String, Long> terminalErrorTime){
            this.clientErrorTime = clientErrorTime;
            this.terminalErrorTime = terminalErrorTime;
        }
        Map<String, Long> clientErrorTime;
        Map<String, Long> terminalErrorTime;
    }
}