/*
*
* RedBagType.java
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
@Table(name = "ly_r_redbagtype")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class RedBagType implements Serializable {
    /**
     * 主键ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 红包类型CODE
	* 列名:typeCode 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String typeCode;

    /**
     * 红包类型名称
	* 列名:typeName 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    private String typeName;

    /**
     * 红包最大金额
	* 列名:maxMoney 类型:DECIMAL(18) 允许空:true 缺省值:null
     */
    private BigDecimal maxMoney;

    /**
     * 红包最小金额
	* 列名:minMoney 类型:DECIMAL(18) 允许空:true 缺省值:null
     */
    private BigDecimal minMoney;

    /**
     * 是否启用：0未启用，1启用
	* 列名:state 类型:INTEGER(10) 允许空:true 缺省值:1
     */
    private Integer state;

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
     * 红包类型CODE
     * @return typeCode 红包类型CODE
     */
    public String getTypeCode() {
        return typeCode;
    }

    /**
     * 红包类型CODE
     * @param typeCode 红包类型CODE
     */
    public void setTypeCode(String typeCode) {
        this.typeCode = typeCode == null ? null : typeCode.trim();
    }

    /**
     * 红包类型名称
     * @return typeName 红包类型名称
     */
    public String getTypeName() {
        return typeName;
    }

    /**
     * 红包类型名称
     * @param typeName 红包类型名称
     */
    public void setTypeName(String typeName) {
        this.typeName = typeName == null ? null : typeName.trim();
    }

    /**
     * 红包最大金额
     * @return maxMoney 红包最大金额
     */
    public BigDecimal getMaxMoney() {
        return maxMoney;
    }

    /**
     * 红包最大金额
     * @param maxMoney 红包最大金额
     */
    public void setMaxMoney(BigDecimal maxMoney) {
        this.maxMoney = maxMoney;
    }

    /**
     * 红包最小金额
     * @return minMoney 红包最小金额
     */
    public BigDecimal getMinMoney() {
        return minMoney;
    }

    /**
     * 红包最小金额
     * @param minMoney 红包最小金额
     */
    public void setMinMoney(BigDecimal minMoney) {
        this.minMoney = minMoney;
    }

    /**
     * 是否启用：0未启用，1启用
     * @return state 是否启用：0未启用，1启用
     */
    public Integer getState() {
        return state;
    }

    /**
     * 是否启用：0未启用，1启用
     * @param state 是否启用：0未启用，1启用
     */
    public void setState(Integer state) {
        this.state = state;
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