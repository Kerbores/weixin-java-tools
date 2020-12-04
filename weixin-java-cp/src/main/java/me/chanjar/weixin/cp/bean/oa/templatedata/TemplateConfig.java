package me.chanjar.weixin.cp.bean.oa.templatedata;

import java.io.Serializable;

import com.google.gson.annotations.SerializedName;

import lombok.Data;
import me.chanjar.weixin.cp.bean.oa.templatedata.control.TemplateAttendance;
import me.chanjar.weixin.cp.bean.oa.templatedata.control.TemplateContact;
import me.chanjar.weixin.cp.bean.oa.templatedata.control.TemplateDate;
import me.chanjar.weixin.cp.bean.oa.templatedata.control.TemplateSelector;
import me.chanjar.weixin.cp.bean.oa.templatedata.control.TemplateTable;
import me.chanjar.weixin.cp.bean.oa.templatedata.control.TemplateVacation;

/**
 * 模板控件配置，包含了部分控件类型的附加类型、属性，详见附录说明。
 * 目前有配置信息的控件类型有：
 * Date-日期/日期+时间；
 * Selector-单选/多选；
 * Contact-成员/部门；
 * Table-明细；
 * Attendance-假勤组件（请假、外出、出差、加班）
 * @author gyv12345@163.com
 */
@Data
public class TemplateConfig implements Serializable {

  private static final long serialVersionUID = 6993937809371277669L;

  private TemplateDate date;

  private TemplateSelector selector;

  private TemplateContact contact;

  private TemplateTable table;

  private TemplateAttendance attendance;

  @SerializedName("vacation_list")
  private TemplateVacation vacationList;

}
