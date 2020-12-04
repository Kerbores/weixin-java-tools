package me.chanjar.weixin.mp.bean.card;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import lombok.EqualsAndHashCode;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

/**
 * .
 * @author leeis
 * @Date 2018/12/29
 */
@Data
@EqualsAndHashCode(callSuper = true)
public class GrouponCardCreateRequest extends AbstractCardCreateRequest implements Serializable {
  private static final long serialVersionUID = 7551441058859934512L;

  @SerializedName("card_type")
  private String cardType = "GROUPON";

  private GrouponCard groupon;

  @Override
  public String toString() {
    return WxMpGsonBuilder.create().toJson(this);
  }
}
