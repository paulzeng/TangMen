/*
*
* IncomeType.java
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
@Table(name = "ly_r_incometype")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class IncomeType implements Serializable {
    /**
     * 主键
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 收益类型：1 领红包; 2 红包分润; 可扩展
	* 列名:incomeType 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer incomeType;

    /**
     * 收益说明
	* 列名:incomeExplain 类型:VARCHAR(30) 允许空:true 缺省值:null
     */
    private String incomeExplain;

    /**
     * 收益费率
	* 列名:incomeFee 类型:DECIMAL(11) 允许空:true 缺省值:null
     */
    private BigDecimal incomeFee;

    /**
     * 状态：1 启用；0 禁用
	* 列名:state 类型:INTEGER(10) 允许空:true 缺省值:1
     */
    private Integer state;

    /**
     * 备注
	* 列名:memo 类型:VARCHAR(30) 允许空:true 缺省值:null
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
     * 收益类型：1 领红包; 2 红包分润; 可扩展
     * @return incomeType 收益类型：1 领红包; 2 红包分润; 可扩展
     */
    public Integer getIncomeType() {
        return incomeType;
    }

    /**
     * 收益类型：1 领红包; 2 红包分润; 可扩展
     * @param incomeType 收益类型：1 领红包; 2 红包分润; 可扩展
     */
    public void setIncomeType(Integer incomeType) {
        this.incomeType = incomeType;
    }

    /**
     * 收益说明
     * @return incomeExplain 收益说明
     */
    public String getIncomeExplain() {
        return incomeExplain;
    }

    /**
     * 收益说明
     * @param incomeExplain 收益说明
     */
    public void setIncomeExplain(String incomeExplain) {
        this.incomeExplain = incomeExplain == null ? null : incomeExplain.trim();
    }

    /**
     * 收益费率
     * @return incomeFee 收益费率
     */
    public BigDecimal getIncomeFee() {
        return incomeFee;
    }

    /**
     * 收益费率
     * @param incomeFee 收益费率
     */
    public void setIncomeFee(BigDecimal incomeFee) {
        this.incomeFee = incomeFee;
    }

    /**
     * 状态：1 启用；0 禁用
     * @return state 状态：1 启用；0 禁用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 状态：1 启用；0 禁用
     * @param state 状态：1 启用；0 禁用
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