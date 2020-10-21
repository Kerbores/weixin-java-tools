package me.chanjar.weixin.cp.bean.oa;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * 申请人信息
 * @author element
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class WxCpApprovalApplier extends WxCpOperator implements Serializable {

  private static final long serialVersionUID = -8974662568286821271L;

  /**
   * 申请人所在部门id
   */
  @SerializedName("partyid")
  private String partyId;

}
