package me.chanjar.weixin.mp.bean.invoice.merchant;

import java.io.Serializable;

import lombok.Data;

/**
 * 设置商户联系信息和发票过时时间参数
 */
@Data
public class MerchantInvoicePlatformInfoWrapper implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private MerchantInvoicePlatformInfo paymchInfo;

}
