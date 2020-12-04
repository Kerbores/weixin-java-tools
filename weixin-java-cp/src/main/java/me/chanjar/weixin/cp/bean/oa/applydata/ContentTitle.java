package me.chanjar.weixin.cp.bean.oa.applydata;

import java.io.Serializable;

import lombok.Data;

/**
 * @author element
 */
@Data
public class ContentTitle implements Serializable {

  private static final long serialVersionUID = -4501999157383517007L;

  private String text;
  private String lang;

}
