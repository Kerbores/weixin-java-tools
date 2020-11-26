package me.chanjar.weixin.mp.bean.invoice.merchant;

import java.io.Serializable;

import lombok.Data;

/**
 * 获取授权链接返回结果DTO
 */
@Data
public class InvoiceAuthPageResult implements Serializable {

    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 授权页地址
     */
    private String authUrl;

    /**
     * 当发起端为小程序时, 返回
     */
    private String appid;
}
