package com.xty.st.task;

import com.xty.st.service.RefundService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * Created by chenhuaming on 15/8/10.
 */
@Component
public class RefundTask {
    @Autowired
    private RefundService refundService;

    public void writeRefundToCsv() { //每周执行
        refundService.writeRefundToCsv();
    }
}
