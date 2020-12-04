package me.chanjar.weixin.mp.bean.invoice.merchant;

import java.io.Serializable;

import lombok.Data;

/**
 * 商户联系信息
 */
@Data
public class MerchantContactInfo implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;

    /**
     * 联系电话
     */
    private String phone;

    /**
     * 开票超时时间
     */
    private Integer timeout;

}
