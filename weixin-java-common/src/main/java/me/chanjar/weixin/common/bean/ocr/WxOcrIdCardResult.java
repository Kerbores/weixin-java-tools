package me.chanjar.weixin.common.bean.ocr;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import me.chanjar.weixin.common.util.json.WxGsonBuilder;

/**
 * OCR身份证识别结果.
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 * @date 2019-06-23
 */
@Data
public class WxOcrIdCardResult implements Serializable {
  private static final long serialVersionUID = 8184352486986729980L;

  @SerializedName("type")
  private String type;
  @SerializedName("name")
  private String name;
  @SerializedName("id")
  private String id;
  @SerializedName("valid_date")
  private String validDate;

  public static WxOcrIdCardResult fromJson(String json) {
    return WxGsonBuilder.create().fromJson(json, WxOcrIdCardResult.class);
  }

}
