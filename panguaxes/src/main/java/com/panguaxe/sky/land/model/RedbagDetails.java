/*
*
* RedbagDetails.java
* Copyright(C) 2017-2020 Panguaxe公司
* @date 2019-07-12
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
import java.math.BigDecimal;
/**
 * @Author 作者：Panguaxe
 * @Desc	TODO
 * @date 2019-07-12
 */
@ToString
@Table(name = "ly_r_redbagdetails")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class RedbagDetails implements Serializable {
    /**
     * 红包ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 红包大包ID
	* 列名:redBagId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String redBagId;

    /**
     * 红包类型: LUCK - 拼手气; GENERAL - 普通
	* 列名:redBagType 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    private String redBagType;

    /**
     * 发送者
	* 列名:userInfoId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String userInfoId;

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
	* 列名:money 类型:DECIMAL(18) 允许空:true 缺省值:null
     */
    private BigDecimal money;

    /**
     * 领取人
	* 列名:receiverId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String receiverId;

    /**
     * 领取人昵称
	* 列名:receiverName 类型:VARCHAR(30) 允许空:true 缺省值:null
     */
    private String receiverName;

    /**
     * 领取人电话
	* 列名:receiverPhone 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
    private String receiverPhone;

    /**
     * 领取人头像
	* 列名:receiverHead 类型:VARCHAR(150) 允许空:true 缺省值:null
     */
    private String receiverHead;

    /**
     * 领取时间
	* 列名:getTime 类型:VARCHAR(36) 允许空:true 缺省值:null
     */
    private String getTime;

    /**
     * 红包状态：默认0 未领取； 1 已领取；2 回收
	* 列名:redBagState 类型:INTEGER(10) 允许空:true 缺省值:0
     */
    private Integer redBagState;

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
     * 红包描述：如：大吉大利
	* 列名:redbagDesc 类型:VARCHAR(400) 允许空:true 缺省值:null
     */
    private String redbagDesc;

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
     * 红包大包ID
     * @return redBagId 红包大包ID
     */
    public String getRedBagId() {
        return redBagId;
    }

    /**
     * 红包大包ID
     * @param redBagId 红包大包ID
     */
    public void setRedBagId(String redBagId) {
        this.redBagId = redBagId == null ? null : redBagId.trim();
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
     * 发送者
     * @return userInfoId 发送者
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * 发送者
     * @param userInfoId 发送者
     */
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId == null ? null : userInfoId.trim();
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
     * @return money 红包金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 红包金额
     * @param money 红包金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 领取人
     * @return receiverId 领取人
     */
    public String getReceiverId() {
        return receiverId;
    }

    /**
     * 领取人
     * @param receiverId 领取人
     */
    public void setReceiverId(String receiverId) {
        this.receiverId = receiverId == null ? null : receiverId.trim();
    }

    /**
     * 领取人昵称
     * @return receiverName 领取人昵称
     */
    public String getReceiverName() {
        return receiverName;
    }

    /**
     * 领取人昵称
     * @param receiverName 领取人昵称
     */
    public void setReceiverName(String receiverName) {
        this.receiverName = receiverName == null ? null : receiverName.trim();
    }

    /**
     * 领取人电话
     * @return receiverPhone 领取人电话
     */
    public String getReceiverPhone() {
        return receiverPhone;
    }

    /**
     * 领取人电话
     * @param receiverPhone 领取人电话
     */
    public void setReceiverPhone(String receiverPhone) {
        this.receiverPhone = receiverPhone == null ? null : receiverPhone.trim();
    }

    /**
     * 领取人头像
     * @return receiverHead 领取人头像
     */
    public String getReceiverHead() {
        return receiverHead;
    }

    /**
     * 领取人头像
     * @param receiverHead 领取人头像
     */
    public void setReceiverHead(String receiverHead) {
        this.receiverHead = receiverHead == null ? null : receiverHead.trim();
    }

    /**
     * 领取时间
     * @return getTime 领取时间
     */
    public String getGetTime() {
        return getTime;
    }

    /**
     * 领取时间
     * @param getTime 领取时间
     */
    public void setGetTime(String getTime) {
        this.getTime = getTime == null ? null : getTime.trim();
    }

    /**
     * 红包状态：默认0 未领取； 1 已领取；2 回收
     * @return redBagState 红包状态：默认0 未领取； 1 已领取；2 回收
     */
    public Integer getRedBagState() {
        return redBagState;
    }

    /**
     * 红包状态：默认0 未领取； 1 已领取；2 回收
     * @param redBagState 红包状态：默认0 未领取； 1 已领取；2 回收
     */
    public void setRedBagState(Integer redBagState) {
        this.redBagState = redBagState;
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