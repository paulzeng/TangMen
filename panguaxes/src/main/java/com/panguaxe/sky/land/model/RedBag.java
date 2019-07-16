/*
*
* RedBag.java
* Copyright(C) 2017-2020 Panguaxe公司
* @date 2019-07-12
*/
package com.panguaxe.sky.land.model;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.panguaxe.sky.common.UUIDGenId;
import lombok.ToString;
import org.hibernate.validator.constraints.Length;
import org.springframework.validation.annotation.Validated;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.NameStyle;
import tk.mybatis.mapper.code.Style;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import java.io.Serializable;
import java.math.BigDecimal;
/**
 * @Author 作者：Panguaxe
 * @Desc	TODO
 * @date 2019-07-12
 */
@ToString
@Table(name = "ly_r_redbag")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class RedBag implements Serializable {
    /**
     * 红包ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 发送者
	* 列名:accountId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String accountId;

    /**
     * 发送人微信openid
	* 列名:openid 类型:VARCHAR(36) 允许空:true 缺省值:null
     */
    private String openid;

    /**
     * 发送者昵称
	* 列名:nickName 类型:VARCHAR(30) 允许空:true 缺省值:null
     */
    private String nickName;

    /**
     * 发送者电话
	* 列名:telephone 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
    private String telephone;

    /**
     * 发送者头像
	* 列名:headPortrait 类型:VARCHAR(350) 允许空:true 缺省值:null
     */
    private String headPortrait;

    /**
     * 红包金额
	* 列名:amount 类型:DECIMAL(11) 允许空:true 缺省值:null
     */
    private BigDecimal amount;

    /**
     * 红包个数
	* 列名:num 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer num;

    /**
     * 发送时间
	* 列名:sendTime 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String sendTime;

    /**
     * 未领取个数：默认发送时的个数
	* 列名:unclaimed 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer unclaimed;

    /**
     * 已领取个数：领取一个,此值+1
	* 列名:alreadyTake 类型:INTEGER(10) 允许空:true 缺省值:0
     */
    private Integer alreadyTake;

    /**
     * 红包类型: LUCK - 拼手气; GENERAL - 普通
	* 列名:redBagType 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    @NotEmpty(message = "请选择红包类型: LUCK - 拼手气; GENERAL - 普通")
    @Length(min = 3,max = 20,message = "请选择红包类型: LUCK - 拼手气; GENERAL - 普通")
    private String redBagType;

    /**
     * 支付方式：Wap、IOS、Android、JSAPI
	* 列名:payType 类型:VARCHAR(10) 允许空:true 缺省值:
     */
    @NotEmpty(message = "请选择支付方式: Wap、IOS、Android、JSAPI")
    @Length(min = 5,max = 20,message = "请选择支付方式: Wap、IOS、Android、JSAPI")
    private String payType;

    /**
     * 支付状态：1 成功; 0 失败
	* 列名:payState 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer payState;

    /**
     * 红包描述：如：大吉大利
	* 列名:redbagDesc 类型:VARCHAR(150) 允许空:true 缺省值:null
     */
    private String redbagDesc;

    /**
     * 展示范围
	* 列名:showRange 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    private String showRange;

    /**
     * 省
	* 列名:province 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String province;

    /**
     * 市/区
	* 列名:city 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String city;

    /**
     * 经度
	* 列名:longitude 类型:DECIMAL(25) 允许空:true 缺省值:null
     */
    private BigDecimal longitude;

    /**
     * 纬度
	* 列名:latitude 类型:DECIMAL(25) 允许空:true 缺省值:null
     */
    private BigDecimal latitude;

    /**
     * 创建时间
	* 列名:createDate 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String createDate;

    /**
     * 修改时间
	* 列名:updateDate 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String updateDate;

    /**
     * 红包ID
     * @return id 红包ID
     */
    public String getId() {
        return id;
    }

    /**
     * 红包ID
     * @param id 红包ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 发送者
     * @return userInfoId 发送者
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 发送者
     * @param accountId 发送者
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 发送人微信openid
     * @return openid 发送人微信openid
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 发送人微信openid
     * @param openid 发送人微信openid
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 发送者昵称
     * @return nickName 发送者昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 发送者昵称
     * @param nickName 发送者昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 发送者电话
     * @return telephone 发送者电话
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 发送者电话
     * @param telephone 发送者电话
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 发送者头像
     * @return headPortrait 发送者头像
     */
    public String getHeadPortrait() {
        return headPortrait;
    }

    /**
     * 发送者头像
     * @param headPortrait 发送者头像
     */
    public void setHeadPortrait(String headPortrait) {
        this.headPortrait = headPortrait == null ? null : headPortrait.trim();
    }

    /**
     * 红包金额
     * @return amount 红包金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 红包金额
     * @param amount 红包金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 红包个数
     * @return num 红包个数
     */
    public Integer getNum() {
        return num;
    }

    /**
     * 红包个数
     * @param num 红包个数
     */
    public void setNum(Integer num) {
        this.num = num;
    }

    /**
     * 发送时间
     * @return sendTime 发送时间
     */
    public String getSendTime() {
        return sendTime;
    }

    /**
     * 发送时间
     * @param sendTime 发送时间
     */
    public void setSendTime(String sendTime) {
        this.sendTime = sendTime == null ? null : sendTime.trim();
    }

    /**
     * 未领取个数：默认发送时的个数
     * @return unclaimed 未领取个数：默认发送时的个数
     */
    public Integer getUnclaimed() {
        return unclaimed;
    }

    /**
     * 未领取个数：默认发送时的个数
     * @param unclaimed 未领取个数：默认发送时的个数
     */
    public void setUnclaimed(Integer unclaimed) {
        this.unclaimed = unclaimed;
    }

    /**
     * 已领取个数：领取一个,此值+1
     * @return alreadyTake 已领取个数：领取一个,此值+1
     */
    public Integer getAlreadyTake() {
        return alreadyTake;
    }

    /**
     * 已领取个数：领取一个,此值+1
     * @param alreadyTake 已领取个数：领取一个,此值+1
     */
    public void setAlreadyTake(Integer alreadyTake) {
        this.alreadyTake = alreadyTake;
    }

    /**
     * 红包类型: LUCK - 拼手气; GENERAL - 普通
     * @return redBagType 红包类型: LUCK - 拼手气; GENERAL - 普通
     */
    public String getRedBagType() {
        return redBagType;
    }

    /**
     * 红包类型: LUCK - 拼手气; GENERAL - 普通
     * @param redBagType 红包类型: LUCK - 拼手气; GENERAL - 普通
     */
    public void setRedBagType(String redBagType) {
        this.redBagType = redBagType == null ? null : redBagType.trim();
    }

    /**
     * 支付方式：Wap、IOS、Android、JSAPI
     * @return payType 支付方式：Wap、IOS、Android、JSAPI
     */
    public String getPayType() {
        return payType;
    }

    /**
     * 支付方式：Wap、IOS、Android、JSAPI
     * @param payType 支付方式：Wap、IOS、Android、JSAPI
     */
    public void setPayType(String payType) {
        this.payType = payType == null ? null : payType.trim();
    }

    /**
     * 支付状态：1 成功; 0 失败
     * @return payState 支付状态：1 成功; 0 失败
     */
    public Integer getPayState() {
        return payState;
    }

    /**
     * 支付状态：1 成功; 0 失败
     * @param payState 支付状态：1 成功; 0 失败
     */
    public void setPayState(Integer payState) {
        this.payState = payState;
    }

    /**
     * 红包描述：如：大吉大利
     * @return redbagDesc 红包描述：如：大吉大利
     */
    public String getRedbagDesc() {
        return redbagDesc;
    }

    /**
     * 红包描述：如：大吉大利
     * @param redbagDesc 红包描述：如：大吉大利
     */
    public void setRedbagDesc(String redbagDesc) {
        this.redbagDesc = redbagDesc == null ? null : redbagDesc.trim();
    }

    /**
     * 展示范围
     * @return showRange 展示范围
     */
    public String getShowRange() {
        return showRange;
    }

    /**
     * 展示范围
     * @param showRange 展示范围
     */
    public void setShowRange(String showRange) {
        this.showRange = showRange == null ? null : showRange.trim();
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
     * 市/区
     * @return city 市/区
     */
    public String getCity() {
        return city;
    }

    /**
     * 市/区
     * @param city 市/区
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 经度
     * @return longitude 经度
     */
    public BigDecimal getLongitude() {
        return longitude;
    }

    /**
     * 经度
     * @param longitude 经度
     */
    public void setLongitude(BigDecimal longitude) {
        this.longitude = longitude;
    }

    /**
     * 纬度
     * @return latitude 纬度
     */
    public BigDecimal getLatitude() {
        return latitude;
    }

    /**
     * 纬度
     * @param latitude 纬度
     */
    public void setLatitude(BigDecimal latitude) {
        this.latitude = latitude;
    }

    /**
     * 创建时间
     * @return createDate 创建时间
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 创建时间
     * @param createDate 创建时间
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * 修改时间
     * @return updateDate 修改时间
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 修改时间
     * @param updateDate 修改时间
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}