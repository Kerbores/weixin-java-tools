package me.chanjar.weixin.cp.bean.external.msg;

import java.io.Serializable;

import lombok.Data;

/**
 * 消息文本消息.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2020-08-16
 */
@Data
public class Text implements Serializable {
  private static final long serialVersionUID = 6608288753719551600L;
  private String content;
}
