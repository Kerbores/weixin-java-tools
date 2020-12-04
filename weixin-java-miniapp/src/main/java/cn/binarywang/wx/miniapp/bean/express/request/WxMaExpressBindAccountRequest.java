package cn.binarywang.wx.miniapp.bean.express.request;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import cn.binarywang.wx.miniapp.json.WxMaGsonBuilder;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * <pre>
 * 绑定、解绑物流账号请求对象
 * </pre>
 * @author <a href="https://github.com/mr-xiaoyu">xiaoyu</a>
 * @since 2019-11-26
 */
@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class WxMaExpressBindAccountRequest implements Serializable {
  private static final long serialVersionUID = 3868003945297939946L;

  /**
   * 类型
   * <pre>
   * 是否必填： 是
   * 描述： bind表示绑定，unbind表示解除绑定
   * </pre>
   */
  @SerializedName("type")
  private String type;

  /**
   * 快递公司客户编码
   * <pre>
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("biz_id")
  private String bizId;

  /**
   * 快递公司ID
   * <pre>
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("delivery_id")
  private String deliveryId;

  /**
   * 快递公司客户密码
   * <pre>
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("password")
  private String password;

  /**
   * 备注内容（提交EMS审核需要）
   * <pre>
   * 是否必填： 是
   * </pre>
   */
  @SerializedName("remark_content")
  private String remarkContent;

  public String toJson() {
    return WxMaGsonBuilder.create().toJson(this);
  }

}
