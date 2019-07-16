/*
*
* WeChat.java
* Copyright(C) 2017-2020 Panguaxe公司
* @date 2019-07-11
*/
package com.panguaxe.sky.land.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.panguaxe.sky.common.UUIDGenId;
import lombok.ToString;
import org.springframework.validation.annotation.Validated;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;

import javax.persistence.Id;
import javax.persistence.Table;
import java.io.Serializable;

/**
 * @Author 作者：Panguaxe
 * @Desc	TODO
 * @date 2019-07-12
 */
@ToString
@Table(name = "ly_s_wechat")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class WeChat implements Serializable {
    /**
     * 主键
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 账户ID
	* 列名:accountId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String accountId;

    /**
     * 手机号
	* 列名:mobile 类型:VARCHAR(20) 允许空:true 缺省值:null
     */
    private String mobile;

    /**
     * 微信openid
	* 列名:openid 类型:VARCHAR(64) 允许空:true 缺省值:null
     */
    private String openid;

    /**
     * 头像
	* 列名:headPture 类型:VARCHAR(256) 允许空:true 缺省值:null
     */
    private String headPture;

    /**
     * 昵称
	* 列名:nickName 类型:VARCHAR(50) 允许空:true 缺省值:null
     */
    private String nickName;

    /**
     * 省
	* 列名:province 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String province;

    /**
     * 市
	* 列名:city 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String city;

    /**
     * unionid微信唯一标识
	* 列名:unionid 类型:VARCHAR(64) 允许空:true 缺省值:null
     */
    private String unionid;

    /**
     * 状态
	* 列名:status 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    private String status;

    /**
     * 创建日期
	* 列名:createDate 类型:VARCHAR(19) 允许空:true 缺省值:null
     */
    private String createDate;

    /**
     * 主键
     * @return id 主键
     */
    public String getId() {
        return id;
    }

    /**
     * 主键
     * @param id 主键
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 账户ID
     * @return accountId 账户ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 账户ID
     * @param accountId 账户ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 手机号
     * @return mobile 手机号
     */
    public String getMobile() {
        return mobile;
    }

    /**
     * 手机号
     * @param mobile 手机号
     */
    public void setMobile(String mobile) {
        this.mobile = mobile == null ? null : mobile.trim();
    }

    /**
     * 微信openid
     * @return openid 微信openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 微信openid
     * @param openid 微信openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 头像
     * @return headPture 头像
     */
    public String getHeadPture() {
        return headPture;
    }

    /**
     * 头像
     * @param headPture 头像
     */
    public void setHeadPture(String headPture) {
        this.headPture = headPture == null ? null : headPture.trim();
    }

    /**
     * 昵称
     * @return nickName 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 省
     * @return province 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 市
     * @return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * unionid微信唯一标识
     * @return unionid unionid微信唯一标识
     */
    public String getUnionid() {
        return unionid;
    }

    /**
     * unionid微信唯一标识
     * @param unionid unionid微信唯一标识
     */
    public void setUnionid(String unionid) {
        this.unionid = unionid == null ? null : unionid.trim();
    }

    /**
     * 状态
     * @return status 状态
     */
    public String getStatus() {
        return status;
    }

    /**
     * 状态
     * @param status 状态
     */
    public void setStatus(String status) {
        this.status = status == null ? null : status.trim();
    }

    /**
     * 创建日期
     * @return createDate 创建日期
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 创建日期
     * @param createDate 创建日期
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }
}