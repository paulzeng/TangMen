/*
*
* EarningsClassify.java
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
@Table(name = "ly_r_earningsclassify")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class EarningsClassify implements Serializable {
    /**
     * 主键ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 收益人
	* 列名:userInfoId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String userInfoId;

    /**
     * 收益金额
	* 列名:money 类型:DECIMAL(18) 允许空:true 缺省值:null
     */
    private BigDecimal money;

    /**
     * 收益类型： 1: 收红包
	* 列名:profitType 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    private String profitType;

    /**
     * 扩展字段
	* 列名:extend 类型:VARCHAR(20) 允许空:true 缺省值:null
     */
    private String extend;

    /**
     * 创建时间
	* 列名:createDate 类型:VARCHAR(36) 允许空:true 缺省值:null
     */
    private String createDate;

    /**
     * 更新时间
	* 列名:updateDate 类型:VARCHAR(36) 允许空:true 缺省值:null
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
     * 收益人
     * @return userInfoId 收益人
     */
    public String getUserInfoId() {
        return userInfoId;
    }

    /**
     * 收益人
     * @param userInfoId 收益人
     */
    public void setUserInfoId(String userInfoId) {
        this.userInfoId = userInfoId == null ? null : userInfoId.trim();
    }

    /**
     * 收益金额
     * @return money 收益金额
     */
    public BigDecimal getMoney() {
        return money;
    }

    /**
     * 收益金额
     * @param money 收益金额
     */
    public void setMoney(BigDecimal money) {
        this.money = money;
    }

    /**
     * 收益类型： 1: 收红包
     * @return profitType 收益类型： 1: 收红包
     */
    public String getProfitType() {
        return profitType;
    }

    /**
     * 收益类型： 1: 收红包
     * @param profitType 收益类型： 1: 收红包
     */
    public void setProfitType(String profitType) {
        this.profitType = profitType == null ? null : profitType.trim();
    }

    /**
     * 扩展字段
     * @return extend 扩展字段
     */
    public String getExtend() {
        return extend;
    }

    /**
     * 扩展字段
     * @param extend 扩展字段
     */
    public void setExtend(String extend) {
        this.extend = extend == null ? null : extend.trim();
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