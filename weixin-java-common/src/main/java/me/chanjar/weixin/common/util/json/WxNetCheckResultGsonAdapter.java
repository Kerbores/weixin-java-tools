package me.chanjar.weixin.common.util.json;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import com.google.gson.JsonArray;
import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonParseException;

import me.chanjar.weixin.common.bean.WxNetCheckResult;


/**
 * @author billytomato
 */
public class WxNetCheckResultGsonAdapter implements JsonDeserializer<WxNetCheckResult> {


  @Override
  public WxNetCheckResult deserialize(JsonElement json, Type typeOfT, JsonDeserializationContext context) throws JsonParseException {
    WxNetCheckResult result = new WxNetCheckResult();

    JsonArray dnssJson = json.getAsJsonObject().get("dns").getAsJsonArray();
    List<WxNetCheckResult.WxNetCheckDnsInfo> dnsInfoList = new ArrayList<>();
    if (dnssJson != null && dnssJson.size() > 0) {
      for (int i = 0; i < dnssJson.size(); i++) {
        JsonObject buttonJson = dnssJson.get(i).getAsJsonObject();
        WxNetCheckResult.WxNetCheckDnsInfo dnsInfo = new WxNetCheckResult.WxNetCheckDnsInfo();
        dnsInfo.setIp(GsonHelper.getString(buttonJson, "ip"));
        dnsInfo.setRealOperator(GsonHelper.getString(buttonJson, "real_operator"));
        dnsInfoList.add(dnsInfo);
      }
    }

    JsonArray pingsJson = json.getAsJsonObject().get("ping").getAsJsonArray();
    List<WxNetCheckResult.WxNetCheckPingInfo> pingInfoList = new ArrayList<>();
    if (pingsJson != null && pingsJson.size() > 0) {
      for (int i = 0; i < pingsJson.size(); i++) {
        JsonObject pingJson = pingsJson.get(i).getAsJsonObject();
        WxNetCheckResult.WxNetCheckPingInfo pingInfo = new WxNetCheckResult.WxNetCheckPingInfo();
        pingInfo.setIp(GsonHelper.getString(pingJson, "ip"));
        pingInfo.setFromOperator(GsonHelper.getString(pingJson, "from_operator"));
        pingInfo.setPackageLoss(GsonHelper.getString(pingJson, "package_loss"));
        pingInfo.setTime(GsonHelper.getString(pingJson, "time"));
        pingInfoList.add(pingInfo);
      }
    }
    result.setDnsInfos(dnsInfoList);
    result.setPingInfos(pingInfoList);
    return result;
  }

}
