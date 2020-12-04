package me.chanjar.weixin.mp.bean.material;

import java.io.Serializable;

import lombok.Data;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

@Data
public class WxMpMaterialArticleUpdate implements Serializable {
  private static final long serialVersionUID = -7611963949517780270L;

  private String mediaId;
  private int index;
  private WxMpNewsArticle articles;

  public String toJson() {
    return WxMpGsonBuilder.create().toJson(this);
  }
}
