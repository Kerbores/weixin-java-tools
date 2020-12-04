package me.chanjar.weixin.mp.bean.shake;

import java.io.Serializable;
import java.util.List;

import lombok.Data;
import me.chanjar.weixin.mp.util.json.WxMpGsonBuilder;

@Data
public class WxMpShakeAroundRelationSearchResult implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer errcode;
    private String errmsg;
    private WxMpShakeAcoundRelationSearch data;

    public static WxMpShakeAroundRelationSearchResult fromJson(String json) {
        return WxMpGsonBuilder.create().fromJson(json, WxMpShakeAroundRelationSearchResult.class);
    }

    @Data
    public static class WxMpShakeAcoundRelationSearch implements Serializable {
        /**
         * 
         */
        private static final long serialVersionUID = 1L;
        private List<WxMpDeviceIdentifier> relations;
        private Integer total_count;
    }
}
