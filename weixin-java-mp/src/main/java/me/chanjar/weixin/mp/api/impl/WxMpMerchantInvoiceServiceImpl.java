package me.chanjar.weixin.mp.api.impl;

import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.CLEAR_OUT_INVOICE;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.GET_AUTH_DATA;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.GET_AUTH_FIELD_SET_BIZ_ATTR;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.GET_AUTH_URL;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.GET_CONTACT_SET_BIZ_ATTR;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.GET_PAY_MCH_SET_BIZ_ATTR;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.MAKE_OUT_INVOICE;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.QUERY_INVOICE_INFO;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.REJECT_INSERT;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.SET_AUTH_FIELD_SET_BIZ_ATTR;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.SET_CONTACT_SET_BIZ_ATTR;
import static me.chanjar.weixin.mp.enums.WxMpApiUrl.Invoice.SET_PAY_MCH_SET_BIZ_ATTR;

import java.util.HashMap;
import java.util.Map;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;

import lombok.AllArgsConstructor;
import me.chanjar.weixin.common.error.WxErrorException;
import me.chanjar.weixin.mp.api.WxMpCardService;
import me.chanjar.weixin.mp.api.WxMpMerchantInvoiceService;
import me.chanjar.weixin.mp.api.WxMpService;
import me.chanjar.weixin.mp.bean.invoice.merchant.ClearOutInvoiceRequest;
import me.chanjar.weixin.mp.bean.invoice.merchant.InvoiceAuthDataRequest;
import me.chanjar.weixin.mp.bean.invoice.merchant.InvoiceAuthDataResult;
import me.chanjar.weixin.mp.bean.invoice.merchant.InvoiceAuthPageRequest;
import me.chanjar.weixin.mp.bean.invoice.merchant.InvoiceAuthPageResult;
import me.chanjar.weixin.mp.bean.invoice.merchant.InvoiceAuthPageSetting;
import me.chanjar.weixin.mp.bean.invoice.merchant.InvoiceRejectRequest;
import me.chanjar.weixin.mp.bean.invoice.merchant.InvoiceResult;
import me.chanjar.weixin.mp.bean.invoice.merchant.MakeOutInvoiceRequest;
import me.chanjar.weixin.mp.bean.invoice.merchant.MerchantContactInfo;
import me.chanjar.weixin.mp.bean.invoice.merchant.MerchantContactInfoWrapper;
import me.chanjar.weixin.mp.bean.invoice.merchant.MerchantInvoicePlatformInfo;
import me.chanjar.weixin.mp.bean.invoice.merchant.MerchantInvoicePlatformInfoWrapper;
import me.chanjar.weixin.mp.enums.WxMpApiUrl;


@AllArgsConstructor
public class WxMpMerchantInvoiceServiceImpl implements WxMpMerchantInvoiceService {

  private WxMpService wxMpService;
  private WxMpCardService wxMpCardService;

  private final static Gson gson;

  static {
    gson = new GsonBuilder()
      .disableHtmlEscaping()
      .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
      .create();
  }

  @Override
  public InvoiceAuthPageResult getAuthPageUrl(InvoiceAuthPageRequest params) throws WxErrorException {
    String ticket = wxMpCardService.getCardApiTicket();
    params.setTicket(ticket);
    return doCommonInvoiceHttpPost(GET_AUTH_URL, params, InvoiceAuthPageResult.class);
  }

  @Override
  public InvoiceAuthDataResult getAuthData(InvoiceAuthDataRequest params) throws WxErrorException {
    return doCommonInvoiceHttpPost(GET_AUTH_DATA, params, InvoiceAuthDataResult.class);
  }

  @Override
  public void rejectInvoice(InvoiceRejectRequest params) throws WxErrorException {
    doCommonInvoiceHttpPost(REJECT_INSERT, params, null);
  }

  @Override
  public void makeOutInvoice(MakeOutInvoiceRequest params) throws WxErrorException {
    doCommonInvoiceHttpPost(MAKE_OUT_INVOICE, params, null);
  }

  @Override
  public void clearOutInvoice(ClearOutInvoiceRequest params) throws WxErrorException {
    doCommonInvoiceHttpPost(CLEAR_OUT_INVOICE, params, null);
  }

  @Override
  public InvoiceResult queryInvoiceInfo(String fpqqlsh, String nsrsbh) throws WxErrorException {
    Map data = new HashMap();
    data.put("fpqqlsh", fpqqlsh);
    data.put("nsrsbh", nsrsbh);
    return doCommonInvoiceHttpPost(QUERY_INVOICE_INFO, data, InvoiceResult.class);
  }

  @Override
  public void setMerchantContactInfo(MerchantContactInfo contact) throws WxErrorException {
    MerchantContactInfoWrapper data = new MerchantContactInfoWrapper();
    data.setContact(contact);
    doCommonInvoiceHttpPost(SET_CONTACT_SET_BIZ_ATTR, data, null);
  }

  @Override
  public MerchantContactInfo getMerchantContactInfo() throws WxErrorException {
    MerchantContactInfoWrapper merchantContactInfoWrapper = doCommonInvoiceHttpPost(GET_CONTACT_SET_BIZ_ATTR, null, MerchantContactInfoWrapper.class);
    return merchantContactInfoWrapper == null ? null : merchantContactInfoWrapper.getContact();
  }

  @Override
  public void setAuthPageSetting(InvoiceAuthPageSetting authPageSetting) throws WxErrorException {
    doCommonInvoiceHttpPost(SET_AUTH_FIELD_SET_BIZ_ATTR, authPageSetting, null);
  }

  @Override
  public InvoiceAuthPageSetting getAuthPageSetting() throws WxErrorException {
    return doCommonInvoiceHttpPost(GET_AUTH_FIELD_SET_BIZ_ATTR, new JsonObject(), InvoiceAuthPageSetting.class);
  }

  @Override
  public void setMerchantInvoicePlatform(MerchantInvoicePlatformInfo paymchInfo) throws WxErrorException {
    MerchantInvoicePlatformInfoWrapper data = new MerchantInvoicePlatformInfoWrapper();
    data.setPaymchInfo(paymchInfo);
    doCommonInvoiceHttpPost(SET_PAY_MCH_SET_BIZ_ATTR, data, null);
  }

  @Override
  public MerchantInvoicePlatformInfo getMerchantInvoicePlatform(MerchantInvoicePlatformInfo merchantInvoicePlatformInfo) throws WxErrorException {
    MerchantInvoicePlatformInfoWrapper result = doCommonInvoiceHttpPost(GET_PAY_MCH_SET_BIZ_ATTR, new JsonObject(), MerchantInvoicePlatformInfoWrapper.class);
    return result == null ? null : result.getPaymchInfo();
  }

  /**
   * 电子发票公用post请求方法
   */
  private <T> T doCommonInvoiceHttpPost(WxMpApiUrl url, Object data, Class<T> resultClass) throws WxErrorException {
    String json = "";
    if (data != null) {
      json = gson.toJson(data);
    }
    String responseText = wxMpService.post(url, json);
    if (resultClass == null) return null;
    return gson.fromJson(responseText, resultClass);
  }
}
