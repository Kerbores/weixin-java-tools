package me.chanjar.weixin.cp.bean.oa;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.applydata.ApplyDataContent;

/**
 * 审批申请数据
 *
 * @author element
 */
@Data
public class WxCpApprovalApplyData implements Serializable {

  private static final long serialVersionUID = 4061352949894274704L;

  private List<ApplyDataContent> contents;

}
