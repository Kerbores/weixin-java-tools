package me.chanjar.weixin.cp.bean.oa.templatedata;

import java.io.Serializable;

import lombok.Data;

/**
 * @author Administrator
 */
@Data
public class TemplateControls implements Serializable {

  private static final long serialVersionUID = -7496794407355510374L;

  private TemplateProperty property;

  private TemplateConfig config;
}
