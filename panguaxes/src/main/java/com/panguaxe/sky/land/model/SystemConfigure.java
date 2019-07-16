/*
*
* SystemConfigure.java
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
/**
 * @Author 作者：Panguaxe
 * @Desc	TODO
 * @date 2019-07-12
 */
@ToString
@Table(name = "ly_r_configure")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class SystemConfigure implements Serializable {
    /**
     * 主键ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 配置名称
	* 列名:configName 类型:VARCHAR(30) 允许空:true 缺省值:null
     */
    private String configName;

    /**
     * 配置值
	* 列名:configValue 类型:VARCHAR(360) 允许空:true 缺省值:null
     */
    private String configValue;

    /**
     * 是否启用：0未启用，1启用
	* 列名:state 类型:INTEGER(10) 允许空:true 缺省值:1
     */
    private Integer state;

    /**
     * 描述
	* 列名:depict 类型:VARCHAR(60) 允许空:true 缺省值:null
     */
    private String depict;

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
     * 配置名称
     * @return configName 配置名称
     */
    public String getConfigName() {
        return configName;
    }

    /**
     * 配置名称
     * @param configName 配置名称
     */
    public void setConfigName(String configName) {
        this.configName = configName == null ? null : configName.trim();
    }

    /**
     * 配置值
     * @return configValue 配置值
     */
    public String getConfigValue() {
        return configValue;
    }

    /**
     * 配置值
     * @param configValue 配置值
     */
    public void setConfigValue(String configValue) {
        this.configValue = configValue == null ? null : configValue.trim();
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
     * 描述
     * @return depict 描述
     */
    public String getDepict() {
        return depict;
    }

    /**
     * 描述
     * @param depict 描述
     */
    public void setDepict(String depict) {
        this.depict = depict == null ? null : depict.trim();
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