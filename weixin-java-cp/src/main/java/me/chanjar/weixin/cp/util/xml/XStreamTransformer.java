package me.chanjar.weixin.cp.util.xml;

import java.io.InputStream;
import java.util.HashMap;
import java.util.Map;

import com.thoughtworks.xstream.XStream;

import me.chanjar.weixin.common.util.xml.XStreamInitializer;
import me.chanjar.weixin.cp.bean.WxCpTpXmlPackage;
import me.chanjar.weixin.cp.bean.message.WxCpTpXmlMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlOutImageMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlOutMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlOutNewsMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlOutTextMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlOutVideoMessage;
import me.chanjar.weixin.cp.bean.message.WxCpXmlOutVoiceMessage;

public class XStreamTransformer {

  protected static final Map<Class, XStream> CLASS_2_XSTREAM_INSTANCE = configXStreamInstance();

  /**
   * xml -> pojo
   */
  @SuppressWarnings("unchecked")
  public static <T> T fromXml(Class<T> clazz, String xml) {
    T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(xml);
    return object;
  }

  @SuppressWarnings("unchecked")
  public static <T> T fromXml(Class<T> clazz, InputStream is) {
    T object = (T) CLASS_2_XSTREAM_INSTANCE.get(clazz).fromXML(is);
    return object;
  }

  /**
   * 注册扩展消息的解析器.
   *
   * @param clz     类型
   * @param xStream xml解析器
   */
  public static void register(Class clz, XStream xStream) {
    CLASS_2_XSTREAM_INSTANCE.put(clz, xStream);
  }

  /**
   * pojo -> xml.
   */
  public static <T> String toXml(Class<T> clazz, T object) {
    return CLASS_2_XSTREAM_INSTANCE.get(clazz).toXML(object);
  }

  private static Map<Class, XStream> configXStreamInstance() {
    Map<Class, XStream> map = new HashMap<>();
    map.put(WxCpXmlMessage.class, configWxCpXmlMessage());
    map.put(WxCpXmlOutNewsMessage.class, configWxCpXmlOutNewsMessage());
    map.put(WxCpXmlOutTextMessage.class, configWxCpXmlOutTextMessage());
    map.put(WxCpXmlOutImageMessage.class, configWxCpXmlOutImageMessage());
    map.put(WxCpXmlOutVideoMessage.class, configWxCpXmlOutVideoMessage());
    map.put(WxCpXmlOutVoiceMessage.class, configWxCpXmlOutVoiceMessage());
    map.put(WxCpTpXmlPackage.class, configWxCpTpXmlPackage());
    map.put(WxCpTpXmlMessage.class, configWxCpTpXmlMessage());
    return map;
  }

  private static XStream configWxCpXmlMessage() {
    XStream xstream = XStreamInitializer.getInstance();

    xstream.processAnnotations(WxCpXmlMessage.class);
    xstream.processAnnotations(WxCpXmlMessage.ScanCodeInfo.class);
    xstream.processAnnotations(WxCpXmlMessage.SendPicsInfo.class);
    xstream.processAnnotations(WxCpXmlMessage.SendPicsInfo.Item.class);
    xstream.processAnnotations(WxCpXmlMessage.SendLocationInfo.class);
    return xstream;
  }

  private static XStream configWxCpXmlOutImageMessage() {
    XStream xstream = XStreamInitializer.getInstance();

    xstream.processAnnotations(WxCpXmlOutMessage.class);
    xstream.processAnnotations(WxCpXmlOutImageMessage.class);
    return xstream;
  }

  private static XStream configWxCpXmlOutNewsMessage() {
    XStream xstream = XStreamInitializer.getInstance();

    xstream.processAnnotations(WxCpXmlOutMessage.class);
    xstream.processAnnotations(WxCpXmlOutNewsMessage.class);
    xstream.processAnnotations(WxCpXmlOutNewsMessage.Item.class);
    return xstream;
  }

  private static XStream configWxCpXmlOutTextMessage() {
    XStream xstream = XStreamInitializer.getInstance();

    xstream.processAnnotations(WxCpXmlOutMessage.class);
    xstream.processAnnotations(WxCpXmlOutTextMessage.class);
    return xstream;
  }

  private static XStream configWxCpXmlOutVideoMessage() {
    XStream xstream = XStreamInitializer.getInstance();

    xstream.processAnnotations(WxCpXmlOutMessage.class);
    xstream.processAnnotations(WxCpXmlOutVideoMessage.class);
    xstream.processAnnotations(WxCpXmlOutVideoMessage.Video.class);
    return xstream;
  }

  private static XStream configWxCpXmlOutVoiceMessage() {
    XStream xstream = XStreamInitializer.getInstance();

    xstream.processAnnotations(WxCpXmlOutMessage.class);
    xstream.processAnnotations(WxCpXmlOutVoiceMessage.class);
    return xstream;
  }

  private static XStream configWxCpTpXmlPackage() {
    XStream xstream = XStreamInitializer.getInstance();
    xstream.processAnnotations(WxCpTpXmlPackage.class);

    return xstream;
  }

  private static XStream configWxCpTpXmlMessage() {
    XStream xstream = XStreamInitializer.getInstance();
    xstream.processAnnotations(WxCpTpXmlMessage.class);

    return xstream;
  }

}
