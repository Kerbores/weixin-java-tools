package com.github.binarywang.wxpay.bean.entpay;

import java.util.Map;

import com.github.binarywang.wxpay.bean.request.BaseWxPayRequest;
import com.github.binarywang.wxpay.exception.WxPayException;
import com.thoughtworks.xstream.annotations.XStreamAlias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 红包发送记录查询请求
 *
 * @author wuyong
 * @date 2019-12-01 17:19
 */
@Data
@EqualsAndHashCode(callSuper = true)
@Builder(builderMethodName = "newBuilder")
@NoArgsConstructor
@AllArgsConstructor
@XStreamAlias("xml")
public class EntPayRedpackQueryRequest extends BaseWxPayRequest {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    /**
     * 商户订单号
     */
    @XStreamAlias("mch_billno")
    private String mchBillNo;

    @Override
    protected void checkConstraints() throws WxPayException {

    }

    @Override
    protected void storeMap(Map<String, String> map) {
        map.put("mch_billno", mchBillNo);
    }
}
