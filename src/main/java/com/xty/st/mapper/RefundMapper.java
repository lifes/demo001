package com.xty.st.mapper;

import com.xty.st.model.RefundDetail;
import java.util.List;

/**
 * Created by chenhuaming on 15/8/10.
 */
public interface RefundMapper {
    List<RefundDetail> getRefundDetails();
    void setRefundFlag(List<Long> ids);
}
