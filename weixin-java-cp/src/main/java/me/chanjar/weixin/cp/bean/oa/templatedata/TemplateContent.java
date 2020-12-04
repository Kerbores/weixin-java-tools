package me.chanjar.weixin.cp.bean.oa.templatedata;

import java.io.Serializable;
import java.util.List;

import lombok.Data;

/**
 * @author gyv12345@163.com
 */
@Data
public class TemplateContent implements Serializable {

  private static final long serialVersionUID = -5640250983775840865L;

  private List<TemplateControls> controls;
}
