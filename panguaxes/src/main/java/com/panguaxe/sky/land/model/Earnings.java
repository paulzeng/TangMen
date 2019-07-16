/*
*
* Earnings.java
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
@Table(name = "ly_r_earnings")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class Earnings implements Serializable {
    /**
     * 主键ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 用户ID---领取人
	* 列名:userInfoId 类型:VARCHAR(36) 允许空:true 缺省值:null
     */
    private String userInfoId;

    /**
     * 红包收益总金额
	* 列名:amount 类型:DECIMAL(11) 允许空:true 缺省值:0.000
     */
    private BigDecimal amount;

    /**
     * 可提现金额
	* 列名:ableWithdraw 类型:DECIMAL(11) 允许空:true 缺省值:0.000
     */
    private BigDecimal ableWithdraw;

    /**
     * 微信openid  可空    
	* 列名:openid 类型:VARCHAR(60) 允许空:true 缺省值:null
     */
    private String openid;

    /**
     * 备注
	* 列名:memo 类型:VARCHAR(150) 允许空:true 缺省值:null
     */
    private String memo;

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
     * 用户ID---领取人
     * @return userInfoId 用户ID---领取人
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * 用户ID---领取人
     * @param userInfoId 用户ID---领取人
     */
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId == null ? null : userInfoId.trim();
    }

    /**
     * 红包收益总金额
     * @return amount 红包收益总金额
     */
    public BigDecimal getAmount() {
        return amount;
    }

    /**
     * 红包收益总金额
     * @param amount 红包收益总金额
     */
    public void setAmount(BigDecimal amount) {
        this.amount = amount;
    }

    /**
     * 可提现金额
     * @return ableWithdraw 可提现金额
     */
    public BigDecimal getAbleWithdraw() {
        return ableWithdraw;
    }

    /**
     * 可提现金额
     * @param ableWithdraw 可提现金额
     */
    public void setAbleWithdraw(BigDecimal ableWithdraw) {
        this.ableWithdraw = ableWithdraw;
    }

    /**
     * 微信openid  可空    
     * @return openid 微信openid  可空    
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 微信openid  可空    
     * @param openid 微信openid  可空    
     */
    public void setOpenid(String openid) {
        this.openid = openid == null ? null : openid.trim();
    }

    /**
     * 备注
     * @return memo 备注
     */
    public String getMemo() {
        return memo;
    }

    /**
     * 备注
     * @param memo 备注
     */
    public void setMemo(String memo) {
        this.memo = memo == null ? null : memo.trim();
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