package cn.binarywang.wx.miniapp.message;

import static org.assertj.core.api.Assertions.assertThat;

import org.testng.annotations.Test;

import me.chanjar.weixin.common.api.WxConsts;

public class WxMaXmlOutMessageTest {

  @Test
  public void testToXml() {
    WxMaXmlOutMessage message = WxMaXmlOutMessage.builder()
      .fromUserName("1")
      .toUserName("2")
      .msgType(WxConsts.XmlMsgType.TRANSFER_CUSTOMER_SERVICE)
      .createTime(System.currentTimeMillis() / 1000)
      .build();

    assertThat(message.toXml()).isNotEmpty();
    System.out.println(message.toXml());
  }
}
