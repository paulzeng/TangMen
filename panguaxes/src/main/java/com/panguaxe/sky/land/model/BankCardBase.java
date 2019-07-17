/*
*
* BankCardBase.java
* Copyright(C) 2017-2020 Panguaxe公司
* @date 2019-07-17
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
@Table(name = "ly_b_bankcardbase")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class BankCardBase implements Serializable {
    /**
     * 主键
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 银行名称
	* 列名:bankName 类型:VARCHAR(60) 允许空:true 缺省值:null
     */
    private String bankName;

    /**
     * 银行代码
	* 列名:bankAbbr 类型:VARCHAR(30) 允许空:true 缺省值:null
     */
    private String bankAbbr;

    /**
     * 卡编号
	* 列名:cardCode 类型:VARCHAR(60) 允许空:true 缺省值:null
     */
    private String cardCode;

    /**
     * 卡名称
	* 列名:cardName 类型:VARCHAR(80) 允许空:true 缺省值:null
     */
    private String cardName;

    /**
     * 卡号长度
	* 列名:cardNoLength 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private String cardNoLength;

    /**
     * bin长度
	* 列名:binLength 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private String binLength;

    /**
     * 卡Bin
	* 列名:cardBin 类型:VARCHAR(30) 允许空:true 缺省值:null
     */
    private String cardBin;

    /**
     * 卡类型
	* 列名:cardType 类型:VARCHAR(80) 允许空:true 缺省值:null
     */
    private String cardType;

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
     * 银行名称
     * @return bankName 银行名称
     */
    public String getBankName() {
        return bankName;
    }

    /**
     * 银行名称
     * @param bankName 银行名称
     */
    public void setBankName(String bankName) {
        this.bankName = bankName == null ? null : bankName.trim();
    }

    /**
     * 银行代码
     * @return bankAbbr 银行代码
     */
    public String getBankAbbr() {
        return bankAbbr;
    }

    /**
     * 银行代码
     * @param bankAbbr 银行代码
     */
    public void setBankAbbr(String bankAbbr) {
        this.bankAbbr = bankAbbr == null ? null : bankAbbr.trim();
    }

    /**
     * 卡编号
     * @return cardCode 卡编号
     */
    public String getCardCode() {
        return cardCode;
    }

    /**
     * 卡编号
     * @param cardCode 卡编号
     */
    public void setCardCode(String cardCode) {
        this.cardCode = cardCode == null ? null : cardCode.trim();
    }

    /**
     * 卡名称
     * @return cardName 卡名称
     */
    public String getCardName() {
        return cardName;
    }

    /**
     * 卡名称
     * @param cardName 卡名称
     */
    public void setCardName(String cardName) {
        this.cardName = cardName == null ? null : cardName.trim();
    }

    /**
     * 卡号长度
     * @return cardNoLength 卡号长度
     */
    public String getCardNoLength() {
        return cardNoLength;
    }

    /**
     * 卡号长度
     * @param cardNoLength 卡号长度
     */
    public void setCardNoLength(String cardNoLength) {
        this.cardNoLength = cardNoLength;
    }

    /**
     * bin长度
     * @return binLength bin长度
     */
    public String getBinLength() {
        return binLength;
    }

    /**
     * bin长度
     * @param binLength bin长度
     */
    public void setBinLength(String binLength) {
        this.binLength = binLength;
    }

    /**
     * 卡Bin
     * @return cardBin 卡Bin
     */
    public String getCardBin() {
        return cardBin;
    }

    /**
     * 卡Bin
     * @param cardBin 卡Bin
     */
    public void setCardBin(String cardBin) {
        this.cardBin = cardBin == null ? null : cardBin.trim();
    }

    /**
     * 卡类型
     * @return cardType 卡类型
     */
    public String getCardType() {
        return cardType;
    }

    /**
     * 卡类型
     * @param cardType 卡类型
     */
    public void setCardType(String cardType) {
        this.cardType = cardType == null ? null : cardType.trim();
    }
}