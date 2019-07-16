/*
*
* VerifiCode.java
* Copyright(C) 2017-2020 Panguaxe公司
* @date 2019-07-13
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

@ToString
@Table(name = "ly_s_verificode")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class VerifiCode implements Serializable {
    /**
     * 主键
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 手机
	* 列名:telephone 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
    private String telephone;

    /**
     * 短信验证码
	* 列名:smsCode 类型:VARCHAR(8) 允许空:true 缺省值:null
     */
    private String smsCode;

    /**
     * 短信分类: 1 注册; 2 验证码登陆；……
	* 列名:smsSort 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer smsSort;

    /**
     * 验证码有效时长
     * 列名:validTime 类型:INTEGER(6) 允许空:true 缺省值:null
     */
    private Integer validTime;

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
     * 手机
     * @return telephone 手机
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 手机
     * @param telephone 手机
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 短信验证码
     * @return smsCode 短信验证码
     */
    public String getSmsCode() {
        return smsCode;
    }

    /**
     * 短信验证码
     * @param smsCode 短信验证码
     */
    public void setSmsCode(String smsCode) {
        this.smsCode = smsCode == null ? null : smsCode.trim();
    }

    /**
     * 短信分类: 1 注册; 2 验证码登陆；……
     * @return smsSort 短信分类: 1 注册; 2 验证码登陆；……
     */
    public Integer getSmsSort() {
        return smsSort;
    }

    /**
     * 短信分类: 1 注册; 2 验证码登陆；……
     * @param smsSort 短信分类: 1 注册; 2 验证码登陆；……
     */
    public void setSmsSort(Integer smsSort) {
        this.smsSort = smsSort;
    }

    /**
     * 验证码有效时长
     * @return validTime    有效时长
     */
    public Integer getValidTime() {
        return validTime;
    }

    /**
     * 验证码有效时长
     * @param validTime 验证码有效时长
     */
    public void setValidTime(Integer validTime) {
        this.validTime = validTime;
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