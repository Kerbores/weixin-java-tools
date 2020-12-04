package me.chanjar.weixin.cp.bean.oa.templatedata;

import java.io.Serializable;

import lombok.Data;

/**
 * @author gyv12345@163.com
 */
@Data
public class TemplateVacationItem implements Serializable {

  private static final long serialVersionUID = 4510594801023791319L;

  private Integer id;

  private TemplateTitle name;
}
