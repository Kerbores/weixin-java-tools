package cn.binarywang.wx.miniapp.json;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import cn.binarywang.wx.miniapp.bean.WxMaSubscribeMessage;
import cn.binarywang.wx.miniapp.bean.WxMaUniformMessage;
import cn.binarywang.wx.miniapp.bean.analysis.WxMaRetainInfo;
import cn.binarywang.wx.miniapp.bean.analysis.WxMaUserPortrait;
import cn.binarywang.wx.miniapp.bean.analysis.WxMaVisitDistribution;
import cn.binarywang.wx.miniapp.bean.code.WxMaCodeCommitRequest;
import cn.binarywang.wx.miniapp.bean.code.WxMaCodeVersionDistribution;
import cn.binarywang.wx.miniapp.json.adaptor.WxMaCodeCommitRequestGsonAdapter;
import cn.binarywang.wx.miniapp.json.adaptor.WxMaCodeVersionDistributionGsonAdapter;
import cn.binarywang.wx.miniapp.json.adaptor.WxMaRetainInfoGsonAdapter;
import cn.binarywang.wx.miniapp.json.adaptor.WxMaSubscribeMessageGsonAdapter;
import cn.binarywang.wx.miniapp.json.adaptor.WxMaUniformMessageGsonAdapter;
import cn.binarywang.wx.miniapp.json.adaptor.WxMaUserPortraitGsonAdapter;
import cn.binarywang.wx.miniapp.json.adaptor.WxMaVisitDistributionGsonAdapter;

/**
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
public class WxMaGsonBuilder {
  private static final GsonBuilder INSTANCE = new GsonBuilder();

  static {
    INSTANCE.disableHtmlEscaping();
    INSTANCE.registerTypeAdapter(WxMaSubscribeMessage.class, new WxMaSubscribeMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaUniformMessage.class, new WxMaUniformMessageGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaCodeCommitRequest.class, new WxMaCodeCommitRequestGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaCodeVersionDistribution.class, new WxMaCodeVersionDistributionGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaVisitDistribution.class, new WxMaVisitDistributionGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaRetainInfo.class, new WxMaRetainInfoGsonAdapter());
    INSTANCE.registerTypeAdapter(WxMaUserPortrait.class, new WxMaUserPortraitGsonAdapter());
  }

  public static Gson create() {
    return INSTANCE.create();
  }

}
