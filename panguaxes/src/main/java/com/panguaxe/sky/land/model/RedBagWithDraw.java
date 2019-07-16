/*
*
* RedBagWithDraw.java
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
@Table(name = "ly_r_withdraw")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class RedBagWithDraw implements Serializable {
    /**
     * 主键ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 提现人ID
	* 列名:accountId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String accountId;

    /**
     * 提现人昵称
	* 列名:nickName 类型:VARCHAR(16) 允许空:true 缺省值:null
     */
    private String nickName;

    /**
     * 提现人手机
	* 列名:telephone 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
    private String telephone;

    /**
     * 提现人头像
	* 列名:headPhoto 类型:VARCHAR(100) 允许空:true 缺省值:null
     */
    private String headPhoto;

    /**
     * 提现金额
	* 列名:amount 类型:DECIMAL(18) 允许空:true 缺省值:null
     */
    private BigDecimal amount;

    /**
     * 提现订单号
	* 列名:orderNo 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String orderNo;

    /**
     * 提现状态：1 成功；0 失败；
	* 列名:state 类型:INTEGER(10) 允许空:true 缺省值:1
     */
    private Integer state;

    /**
     * 返回码
	* 列名:returnCode 类型:VARCHAR(20) 允许空:true 缺省值:null
     */
    private String returnCode;

    /**
     * 返回信息
	* 列名:returnMsg 类型:VARCHAR(200) 允许空:true 缺省值:null
     */
    private String returnMsg;

    /**
     * 提现/创建时间
	* 列名:createDate 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String createDate;

    /**
     * 更新时间
	* 列名:updateDate 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String updateDate;

    /**
     * 主键ID
     * @return id 主键ID
     */
    public String getId() {
        return id;
    }

    /**
     * 主键ID
     * @param id 主键ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 提现人ID
     * @return accountId 提现人ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 提现人ID
     * @param accountId 提现人ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 提现人昵称
     * @return nickName 提现人昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 提现人昵称
     * @param nickName 提现人昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 提现人手机
     * @return telephone 提现人手机
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 提现人手机
     * @param telephone 提现人手机
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 提现人头像
     * @return headPhoto 提现人头像
     */
    public String getHeadPhoto() {
        return headPhoto;
    }

    /**
     * 提现人头像
     * @param headPhoto 提现人头像
     */
    public void setHeadPhoto(String headPhoto) {
        this.headPhoto = headPhoto == null ? null : headPhoto.trim();
    }

    /**
     * 提现金额
     * @return amount 提现金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 提现金额
     * @param amount 提现金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 提现订单号
     * @return orderNo 提现订单号
     */
    public String getOrderNo() {
        return orderNo;
    }

    /**
     * 提现订单号
     * @param orderNo 提现订单号
     */
    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo == null ? null : orderNo.trim();
    }

    /**
     * 提现状态：1 成功；0 失败；
     * @return state 提现状态：1 成功；0 失败；
     */
    public Integer getState() {
        return state;
    }

    /**
     * 提现状态：1 成功；0 失败；
     * @param state 提现状态：1 成功；0 失败；
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 返回码
     * @return returnCode 返回码
     */
    public String getReturnCode() {
        return returnCode;
    }

    /**
     * 返回码
     * @param returnCode 返回码
     */
    public void setReturnCode(String returnCode) {
        this.returnCode = returnCode == null ? null : returnCode.trim();
    }

    /**
     * 返回信息
     * @return returnMsg 返回信息
     */
    public String getReturnMsg() {
        return returnMsg;
    }

    /**
     * 返回信息
     * @param returnMsg 返回信息
     */
    public void setReturnMsg(String returnMsg) {
        this.returnMsg = returnMsg == null ? null : returnMsg.trim();
    }

    /**
     * 提现/创建时间
     * @return createDate 提现/创建时间
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 提现/创建时间
     * @param createDate 提现/创建时间
     */
    public void setCreateDate(String createDate) {
        this.createDate = createDate == null ? null : createDate.trim();
    }

    /**
     * 更新时间
     * @return updateDate 更新时间
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新时间
     * @param updateDate 更新时间
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}