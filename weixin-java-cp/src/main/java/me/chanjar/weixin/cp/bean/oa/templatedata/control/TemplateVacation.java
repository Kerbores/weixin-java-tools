package me.chanjar.weixin.cp.bean.oa.templatedata.control;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.templatedata.TemplateVacationItem;

/**
 * @author gyv12345@163.com
 */
@Data
public class TemplateVacation implements Serializable {

  private List<TemplateVacationItem> item;

}
