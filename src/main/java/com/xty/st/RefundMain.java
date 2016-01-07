package com.xty.st;

import com.xty.st.task.RedTask;
import com.xty.st.task.RefundTask;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Created by chenhuaming on 15/8/10.
 */
public class RefundMain {
    private static Logger refund = LoggerFactory.getLogger("refund.csv");
    public static void main(String args[]) {

        @SuppressWarnings("resource")
        ApplicationContext ctx = new ClassPathXmlApplicationContext(
                "spring.xml");
        ctx.getBean(RefundTask.class).writeRefundToCsv();
    }
}
