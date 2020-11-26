package me.chanjar.weixin.mp.bean.shake;

import java.io.Serializable;

import com.google.gson.JsonObject;

import lombok.Data;

@Data
public class WxMpShakeAroundPageAddQuery implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private String title;
    private String description;
    private String pageUrl;
    private String comment;
    private String iconUrl;

    public String toJsonString() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("title", title);
        jsonObject.addProperty("description", description);
        jsonObject.addProperty("page_url", pageUrl);
        jsonObject.addProperty("comment", comment);
        jsonObject.addProperty("icon_url", iconUrl);
        return jsonObject.toString();
    }
}
