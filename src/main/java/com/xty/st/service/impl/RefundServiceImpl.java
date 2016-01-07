package com.xty.st.service.impl;

import com.xty.st.mapper.RefundMapper;
import com.xty.st.model.RefundDetail;
import com.xty.st.service.RefundService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigDecimal;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by chenhuaming on 15/8/10.
 */

@Service
public class RefundServiceImpl implements RefundService {
    private final Logger logger  = LoggerFactory.getLogger(getClass());
    @Autowired
    private RefundMapper refundMapper;
    @Transactional
    public void writeRefundToCsv(){
        List<RefundDetail> refundList =refundMapper.getRefundDetails();
        List<Long> ids = new ArrayList<>();
        if(refundList.size()==0) return;
        for(RefundDetail r: refundList){
            String trade_no =  r.getTrade_no();
            ids.add(Long.parseLong(trade_no));
        }
        refundMapper.setRefundFlag(ids);
        writeToCsv(refundList);
        //throw new RuntimeException("for rollback");
        System.out.println("导出成功");
    }
    private final void writeToCsv(List<RefundDetail> refundList){
        StringBuffer sb = new StringBuffer();
        Date date=new Date();
        DateFormat df=new SimpleDateFormat("yyyyMMddHHmmss");
        String batchNo = df.format(date);
        sb.append("批次号 ,总金额（元）,总笔数,\n");
        long totalCount = 0 ;
        BigDecimal totalAmount = new BigDecimal("0");
        StringBuffer detail_data = new StringBuffer();
        for(RefundDetail r : refundList){
            totalCount ++;
            if(r.getRefund_fee()!=null)
            totalAmount.add(r.getRefund_fee());
            detail_data.append(r.getOut_trade_no() +","+r.getTrade_no()+","+r.getRefund_fee()+","+"交易取消退款\n");
        }
        sb.append(batchNo+","+totalAmount+","+totalCount+",\n");
        sb.append("商户退款流水号,支付宝交易号,退款金额,退款备注\n");
        sb.append(detail_data);

        FileWriter writer = null;
        try {
            writer = new FileWriter("logs/"+batchNo+".csv");
            writer.write(sb.toString());
        } catch (Exception e) {
            logger.error("导出csv文件失败{}",e);
            throw new RuntimeException("导出csv文件失败");
        } finally {
            if (writer != null) {
                try {
                    writer.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}

