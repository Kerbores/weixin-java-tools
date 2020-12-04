package me.chanjar.weixin.mp.bean.shake;

import java.io.Serializable;

import com.google.gson.JsonObject;

import lombok.Data;

@Data
public class WxMpDeviceIdentifier implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 1L;
    private Integer device_id;
    private String uuid;
    private Integer page_id;
    private Integer major;
    private Integer minor;

    public JsonObject toJsonObject() {
        JsonObject jsonObject = new JsonObject();
        jsonObject.addProperty("device_id", device_id);
        jsonObject.addProperty("uuid", uuid);
        jsonObject.addProperty("major", major);
        jsonObject.addProperty("minor", minor);
        return jsonObject;
    }
}
