/*
*
* Account.java
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
@Table(name = "ly_s_account")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class Account implements Serializable {
    /**
     * 主键
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 账户名
	* 列名:userName 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String userName;

    /**
     * 昵称
	* 列名:nickName 类型:VARCHAR(50) 允许空:true 缺省值:null
     */
    private String nickName;

    /**
     * 密码
	* 列名:password 类型:VARCHAR(50) 允许空:true 缺省值:null
     */
    private String password;

    /**
     * 盐池
	* 列名:salt 类型:VARCHAR(50) 允许空:true 缺省值:null
     */
    private String salt;

    /**
     * 手机号
	* 列名:telephone 类型:VARCHAR(11) 允许空:true 缺省值:null
     */
   private String telephone;

    /**
     * 账户状态
	* 列名:isEnable 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer isEnable;

    /**
     * 是否员工：1 是；0 不是
	* 列名:isEmployee 类型:INTEGER(10) 允许空:true 缺省值:0
     */
    private Integer isEmployee;

    /**
     * 性别
	* 列名:gender 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer gender;

    /**
     * 生日
	* 列名:birthday 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    private String birthday;

    /**
     * 年龄
	* 列名:age 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer age;

    /**
     * 邮箱
	* 列名:email 类型:VARCHAR(26) 允许空:true 缺省值:null
     */
    private String email;

    /**
     * 座右铭
	* 列名:motto 类型:VARCHAR(150) 允许空:true 缺省值:null
     */
    private String motto;

    /**
     * 微信ID
	* 列名:openId 类型:VARCHAR(50) 允许空:true 缺省值:null
     */
    private String openId;

    /**
     * 民族
	* 列名:nation 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    private String nation;

    /**
     * 省
	* 列名:province 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String province;

    /**
     * 市
	* 列名:city 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String city;

    /**
     * 区县
	* 列名:district 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String district;

    /**
     * 最后登录时间
	* 列名:lastLogin 类型:VARCHAR(19) 允许空:true 缺省值:null
     */
    private String lastLogin;

    /**
     * 创建日期
	* 列名:createDate 类型:VARCHAR(19) 允许空:true 缺省值:null
     */
    private String createDate;

    /**
     * 更新日期
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
     * 账户名
     * @return userName 账户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 账户名
     * @param userName 账户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 昵称
     * @return nickName 昵称
     */
    public String getNickName() {
        return nickName;
    }

    /**
     * 昵称
     * @param nickName 昵称
     */
    public void setNickName(String nickName) {
        this.nickName = nickName == null ? null : nickName.trim();
    }

    /**
     * 密码
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * 盐池
     * @return salt 盐池
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐池
     * @param salt 盐池
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 手机号
     * @return telephone 手机号
     */
    public String getTelephone() {
        return telephone;
    }

    /**
     * 手机号
     * @param telephone 手机号
     */
    public void setTelephone(String telephone) {
        this.telephone = telephone == null ? null : telephone.trim();
    }

    /**
     * 账户状态
     * @return isEnable 账户状态
     */
    public Integer getIsEnable() {
        return isEnable;
    }

    /**
     * 账户状态
     * @param isEnable 账户状态
     */
    public void setIsEnable(Integer isEnable) {
        this.isEnable = isEnable;
    }

    /**
     * 是否员工：1 是；0 不是
     * @return isEmployee 是否员工：1 是；0 不是
     */
    public Integer getIsEmployee() {
        return isEmployee;
    }

    /**
     * 是否员工：1 是；0 不是
     * @param isEmployee 是否员工：1 是；0 不是
     */
    public void setIsEmployee(Integer isEmployee) {
        this.isEmployee = isEmployee;
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
     * 生日
     * @return birthday 生日
     */
    public String getBirthday() {
        return birthday;
    }

    /**
     * 生日
     * @param birthday 生日
     */
    public void setBirthday(String birthday) {
        this.birthday = birthday == null ? null : birthday.trim();
    }

    /**
     * 年龄
     * @return age 年龄
     */
    public Integer getAge() {
        return age;
    }

    /**
     * 年龄
     * @param age 年龄
     */
    public void setAge(Integer age) {
        this.age = age;
    }

    /**
     * 邮箱
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 座右铭
     * @return motto 座右铭
     */
    public String getMotto() {
        return motto;
    }

    /**
     * 座右铭
     * @param motto 座右铭
     */
    public void setMotto(String motto) {
        this.motto = motto == null ? null : motto.trim();
    }

    /**
     * 微信ID
     * @return openId 微信ID
     */
    public String getOpenId() {
        return openId;
    }

    /**
     * 微信ID
     * @param openId 微信ID
     */
    public void setOpenId(String openId) {
        this.openId = openId == null ? null : openId.trim();
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
     * 省
     * @return province 省
     */
    public String getProvince() {
        return province;
    }

    /**
     * 省
     * @param province 省
     */
    public void setProvince(String province) {
        this.province = province == null ? null : province.trim();
    }

    /**
     * 市
     * @return city 市
     */
    public String getCity() {
        return city;
    }

    /**
     * 市
     * @param city 市
     */
    public void setCity(String city) {
        this.city = city == null ? null : city.trim();
    }

    /**
     * 区县
     * @return district 区县
     */
    public String getDistrict() {
        return district;
    }

    /**
     * 区县
     * @param district 区县
     */
    public void setDistrict(String district) {
        this.district = district == null ? null : district.trim();
    }

    /**
     * 最后登录时间
     * @return lastLogin 最后登录时间
     */
    public String getLastLogin() {
        return lastLogin;
    }

    /**
     * 最后登录时间
     * @param lastLogin 最后登录时间
     */
    public void setLastLogin(String lastLogin) {
        this.lastLogin = lastLogin == null ? null : lastLogin.trim();
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
     * 更新日期
     * @return updateDate 更新日期
     */
    public String getUpdateDate() {
        return updateDate;
    }

    /**
     * 更新日期
     * @param updateDate 更新日期
     */
    public void setUpdateDate(String updateDate) {
        this.updateDate = updateDate == null ? null : updateDate.trim();
    }
}