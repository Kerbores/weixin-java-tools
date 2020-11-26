package me.chanjar.weixin.mp.bean.invoice.merchant;

import java.io.Serializable;

import lombok.Data;

/**
 * 发票充红请求参数
 */
@Data
public class ClearOutInvoiceRequest implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private ClearOutInvoiceInfo invoiceinfo;

    @Data
    public static class ClearOutInvoiceInfo implements Serializable {

        /**
         * 
         */
        private static final long serialVersionUID = 1L;

        /**
         * 用户的openid 用户知道是谁在开票
         */
        private String wxopenid;

        /**
         * 发票请求流水号，唯一查询发票的流水号
         */
        private String fpqqlsh;

        /**
         * 纳税人识别码
         */
        private String nsrsbh;

        /**
         * 纳税人名称
         */
        private String nsrmc;

        /**
         * 原发票代码，即要冲红的蓝票的发票代码
         */
        private String yfpdm;

        /**
         * 原发票号码，即要冲红的蓝票的发票号码
         */
        private String yfphm;

    }
}
