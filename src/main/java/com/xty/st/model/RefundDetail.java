package com.xty.st.model;

import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Created by chenhuaming on 15/8/10.
 */
public class RefundDetail implements Serializable{
   // 商户退款流水号,支付宝交易号,退款金额,退款备注
    private String trade_no; //支付宝订单号
    private String out_trade_no; //商户流水号
    private BigDecimal refund_fee;
    private String reason;

    public String getOut_trade_no() {
        return out_trade_no;
    }

    public void setOut_trade_no(String out_trade_no) {
        this.out_trade_no = out_trade_no;
    }

    public String getTrade_no() {
        return trade_no;
    }

    public void setTrade_no(String trade_no) {
        this.trade_no = trade_no;
    }

    public String getReason() {
        return reason;
    }

    public void setReason(String reason) {
        this.reason = reason;
    }

    public BigDecimal getRefund_fee() {
        return refund_fee;
    }

    public void setRefund_fee(BigDecimal refund_fee) {
        this.refund_fee = refund_fee;
    }
}
