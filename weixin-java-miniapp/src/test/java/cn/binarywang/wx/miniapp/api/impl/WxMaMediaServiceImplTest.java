package cn.binarywang.wx.miniapp.api.impl;

import static org.testng.Assert.assertNotNull;
import static org.testng.Assert.assertTrue;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

import org.testng.annotations.Guice;
import org.testng.annotations.Test;

import com.google.inject.Inject;

import cn.binarywang.wx.miniapp.api.WxMaService;
import cn.binarywang.wx.miniapp.test.ApiTestModule;
import me.chanjar.weixin.common.bean.result.WxMediaUploadResult;
import me.chanjar.weixin.common.error.WxErrorException;

/**
 * 临时素材接口的测试
 *
 * @author <a href="https://github.com/binarywang">Binary Wang</a>
 */
@Test
@Guice(modules = ApiTestModule.class)
public class WxMaMediaServiceImplTest {
  @Inject
  protected WxMaService wxService;

  private String mediaId;

  @Test
  public void testUploadMedia() throws WxErrorException, IOException {
    String mediaType = "image";
    String fileType = "png";
    String fileName = "tmp.png";
    try (InputStream inputStream = ClassLoader.getSystemResourceAsStream(fileName)) {
      WxMediaUploadResult res = this.wxService.getMediaService().uploadMedia(mediaType, fileType, inputStream);
      assertNotNull(res.getType());
      assertNotNull(res.getCreatedAt());
      assertTrue(res.getMediaId() != null || res.getThumbMediaId() != null);
      this.mediaId = res.getMediaId();
      System.out.println(res);
    }
  }

  @Test(dependsOnMethods = {"testUploadMedia"})
  public void testGetMedia() throws WxErrorException {
    File file = this.wxService.getMediaService().getMedia(this.mediaId);
    assertNotNull(file);
    System.out.println(file.getAbsolutePath());
  }
}
