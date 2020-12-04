package cn.binarywang.wx.miniapp.bean.code;

import java.io.Serializable;
import java.util.List;

import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.json.WxMaGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 提交审核的请求
 *
 * @author <a href="https://github.com/charmingoh">Charming</a>
 * @since 2018-04-26 19:45
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxMaCodeSubmitAuditRequest implements Serializable {
  private static final long serialVersionUID = 8854979405505241314L;
  /**
   * 提交审核项的一个列表（至少填写1项，至多填写5项）
   */
  @SerializedName("item_list")
  private List<WxMaCategory> itemList;

  public String toJson() {
    return WxMaGsonBuilder.create().toJson(this);
  }
}
