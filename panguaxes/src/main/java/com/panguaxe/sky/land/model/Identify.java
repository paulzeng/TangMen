/*
*
* Identify.java
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
@Table(name = "ly_s_identify")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class Identify implements Serializable {
    /**
     * 主键
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 用户ID
	* 列名:accountId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String accountId;

    /**
     * 姓名
	* 列名:realName 类型:VARCHAR(20) 允许空:true 缺省值:null
     */
    private String realName;

    /**
     * 身份证号
	* 列名:idCard 类型:VARCHAR(100) 允许空:true 缺省值:null
     */
    private String idCard;

    /**
     * 性别
	* 列名:gender 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer gender;

    /**
     * 身份证后6位
	* 列名:laterDigits 类型:VARCHAR(6) 允许空:true 缺省值:null
     */
    private String laterDigits;

    /**
     * 户籍
	* 列名:census 类型:VARCHAR(30) 允许空:true 缺省值:null
     */
    private String census;

    /**
     * 发展机关
	* 列名:licAuth 类型:VARCHAR(50) 允许空:true 缺省值:null
     */
    private String licAuth;

    /**
     * 民族
	* 列名:nation 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    private String nation;

    /**
     * 是否通过实名认证
	* 列名:isPass 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer isPass;

    /**
     * 创建日期
	* 列名:createDate 类型:VARCHAR(19) 允许空:true 缺省值:null
     */
    private String createDate;

    /**
     * 最后修改日期
	* 列名:updateDate 类型:VARCHAR(19) 允许空:true 缺省值:null
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
     * 用户ID
     * @return accountId 用户ID
     */
    public String getAccountId() {
        return accountId;
    }

    /**
     * 用户ID
     * @param accountId 用户ID
     */
    public void setAccountId(String accountId) {
        this.accountId = accountId == null ? null : accountId.trim();
    }

    /**
     * 姓名
     * @return realName 姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 姓名
     * @param realName 姓名
     */
    public void setRealName(String realName) {
        this.realName = realName == null ? null : realName.trim();
    }

    /**
     * 身份证号
     * @return idCard 身份证号
     */
    public String getIdCard() {
        return idCard;
    }

    /**
     * 身份证号
     * @param idCard 身份证号
     */
    public void setIdCard(String idCard) {
        this.idCard = idCard == null ? null : idCard.trim();
    }

    /**
     * 性别
     * @return gender 性别
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 性别
     * @param gender 性别
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 身份证后6位
     * @return laterDigits 身份证后6位
     */
    public String getLaterDigits() {
        return laterDigits;
    }

    /**
     * 身份证后6位
     * @param laterDigits 身份证后6位
     */
    public void setLaterDigits(String laterDigits) {
        this.laterDigits = laterDigits == null ? null : laterDigits.trim();
    }

    /**
     * 户籍
     * @return census 户籍
     */
    public String getCensus() {
        return census;
    }

    /**
     * 户籍
     * @param census 户籍
     */
    public void setCensus(String census) {
        this.census = census == null ? null : census.trim();
    }

    /**
     * 发展机关
     * @return licAuth 发展机关
     */
    public String getLicAuth() {
        return licAuth;
    }

    /**
     * 发展机关
     * @param licAuth 发展机关
     */
    public void setLicAuth(String licAuth) {
        this.licAuth = licAuth == null ? null : licAuth.trim();
    }

    /**
     * 民族
     * @return nation 民族
     */
    public String getNation() {
        return nation;
    }

    /**
     * 民族
     * @param nation 民族
     */
    public void setNation(String nation) {
        this.nation = nation == null ? null : nation.trim();
    }

    /**
     * 是否通过实名认证
     * @return isPass 是否通过实名认证
     */
    public Integer getIsPass() {
        return isPass;
    }

    /**
     * 是否通过实名认证
     * @param isPass 是否通过实名认证
     */
    public void setIsPass(Integer isPass) {
        this.isPass = isPass;
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

    /**
     * 最后修改日期
     * @return updateDate 最后修改日期
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 最后修改日期
     * @param updateDate 最后修改日期
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}