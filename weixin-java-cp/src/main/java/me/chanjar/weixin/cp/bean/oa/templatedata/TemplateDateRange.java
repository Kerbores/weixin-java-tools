package me.chanjar.weixin.cp.bean.oa.templatedata;

import java.io.Serializable;

import lombok.Data;

/**
 * @author gyv12345@163.com
 */
@Data
public class TemplateDateRange implements Serializable {

  private static final long serialVersionUID = -9209035461466543180L;

  /**
   * 时间刻度：hour-精确到分钟, halfday—上午/下午
   */
  private String type;
}
