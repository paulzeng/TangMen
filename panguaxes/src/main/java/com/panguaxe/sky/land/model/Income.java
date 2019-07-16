/*
*
* Income.java
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
@Table(name = "ly_r_income")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class Income implements Serializable {
    /**
     * ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 受益人ID
	* 列名:userInfoId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String userInfoId;

    /**
     * 受益人昵称
	* 列名:incomeName 类型:VARCHAR(16) 允许空:true 缺省值:null
     */
    private String incomeName;

    /**
     * 受益人手机
	* 列名:incomeMobile 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
    private String incomeMobile;

    /**
     * 收益金额
	* 列名:incomeMoney 类型:DECIMAL(11) 允许空:true 缺省值:null
     */
    private BigDecimal incomeMoney;

    /**
     * 交易金额
	* 列名:tradeMoney 类型:DECIMAL(11) 允许空:true 缺省值:null
     */
    private BigDecimal tradeMoney;

    /**
     * 提成百分比
	* 列名:fee 类型:DECIMAL(11) 允许空:true 缺省值:null
     */
    private BigDecimal fee;

    /**
     * 收益类型：1 领红包收益; 2 好友领红包收益
	* 列名:incomeType 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer incomeType;

    /**
     * 收益描述
	* 列名:incomeDesc 类型:VARCHAR(30) 允许空:true 缺省值:null
     */
    private String incomeDesc;

    /**
     * 业务ID：如 红包ID
	* 列名:businessId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String businessId;

    /**
     * 创造收益者ID
	* 列名:creatorId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String creatorId;

    /**
     * 创造收益者昵称
	* 列名:creatorName 类型:VARCHAR(16) 允许空:true 缺省值:null
     */
    private String creatorName;

    /**
     * 创造收益者手机
	* 列名:creatorMobile 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
    private String creatorMobile;

    /**
     * 状态：1 正常
	* 列名:state 类型:INTEGER(10) 允许空:true 缺省值:1
     */
    private Integer state;

    /**
     * 备注
	* 列名:memo 类型:VARCHAR(250) 允许空:true 缺省值:null
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
     * ID
     * @return id ID
     */
    public String getId() {
        return id;
    }

    /**
     * ID
     * @param id ID
     */
    public void setId(String id) {
        this.id = id == null ? null : id.trim();
    }

    /**
     * 受益人ID
     * @return userInfoId 受益人ID
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * 受益人ID
     * @param userInfoId 受益人ID
     */
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId == null ? null : userInfoId.trim();
    }

    /**
     * 受益人昵称
     * @return incomeName 受益人昵称
     */
    public String getIncomeName() {
        return incomeName;
    }

    /**
     * 受益人昵称
     * @param incomeName 受益人昵称
     */
    public void setIncomeName(String incomeName) {
        this.incomeName = incomeName == null ? null : incomeName.trim();
    }

    /**
     * 受益人手机
     * @return incomeMobile 受益人手机
     */
    public String getIncomeMobile() {
        return incomeMobile;
    }

    /**
     * 受益人手机
     * @param incomeMobile 受益人手机
     */
    public void setIncomeMobile(String incomeMobile) {
        this.incomeMobile = incomeMobile == null ? null : incomeMobile.trim();
    }

    /**
     * 收益金额
     * @return incomeMoney 收益金额
     */
    public BigDecimal getIncomeMoney() {
        return incomeMoney;
    }

    /**
     * 收益金额
     * @param incomeMoney 收益金额
     */
    public void setIncomeMoney(BigDecimal incomeMoney) {
        this.incomeMoney = incomeMoney;
    }

    /**
     * 交易金额
     * @return tradeMoney 交易金额
     */
    public BigDecimal getTradeMoney() {
        return tradeMoney;
    }

    /**
     * 交易金额
     * @param tradeMoney 交易金额
     */
    public void setTradeMoney(BigDecimal tradeMoney) {
        this.tradeMoney = tradeMoney;
    }

    /**
     * 提成百分比
     * @return fee 提成百分比
     */
    public BigDecimal getFee() {
        return fee;
    }

    /**
     * 提成百分比
     * @param fee 提成百分比
     */
    public void setFee(BigDecimal fee) {
        this.fee = fee;
    }

    /**
     * 收益类型：1 领红包收益; 2 好友领红包收益
     * @return incomeType 收益类型：1 领红包收益; 2 好友领红包收益
     */
    public Integer getIncomeType() {
        return incomeType;
    }

    /**
     * 收益类型：1 领红包收益; 2 好友领红包收益
     * @param incomeType 收益类型：1 领红包收益; 2 好友领红包收益
     */
    public void setIncomeType(Integer incomeType) {
        this.incomeType = incomeType;
    }

    /**
     * 收益描述
     * @return incomeDesc 收益描述
     */
    public String getIncomeDesc() {
        return incomeDesc;
    }

    /**
     * 收益描述
     * @param incomeDesc 收益描述
     */
    public void setIncomeDesc(String incomeDesc) {
        this.incomeDesc = incomeDesc == null ? null : incomeDesc.trim();
    }

    /**
     * 业务ID：如 红包ID
     * @return businessId 业务ID：如 红包ID
     */
    public String getBusinessId() {
        return businessId;
    }

    /**
     * 业务ID：如 红包ID
     * @param businessId 业务ID：如 红包ID
     */
    public void setBusinessId(String businessId) {
        this.businessId = businessId == null ? null : businessId.trim();
    }

    /**
     * 创造收益者ID
     * @return creatorId 创造收益者ID
     */
    public String getCreatorId() {
        return creatorId;
    }

    /**
     * 创造收益者ID
     * @param creatorId 创造收益者ID
     */
    public void setCreatorId(String creatorId) {
        this.creatorId = creatorId == null ? null : creatorId.trim();
    }

    /**
     * 创造收益者昵称
     * @return creatorName 创造收益者昵称
     */
    public String getCreatorName() {
        return creatorName;
    }

    /**
     * 创造收益者昵称
     * @param creatorName 创造收益者昵称
     */
    public void setCreatorName(String creatorName) {
        this.creatorName = creatorName == null ? null : creatorName.trim();
    }

    /**
     * 创造收益者手机
     * @return creatorMobile 创造收益者手机
     */
    public String getCreatorMobile() {
        return creatorMobile;
    }

    /**
     * 创造收益者手机
     * @param creatorMobile 创造收益者手机
     */
    public void setCreatorMobile(String creatorMobile) {
        this.creatorMobile = creatorMobile == null ? null : creatorMobile.trim();
    }

    /**
     * 状态：1 正常
     * @return state 状态：1 正常
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态：1 正常
     * @param state 状态：1 正常
     */
    public void setState(Integer state) {
        this.state = state;
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