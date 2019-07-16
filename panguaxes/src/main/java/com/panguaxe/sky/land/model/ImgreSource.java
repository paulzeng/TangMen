/*
*
* ImgreSource.java
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
@Table(name = "ly_r_imgresource")
@NameStyle(Style.normal)
@JsonInclude(value= JsonInclude.Include.NON_EMPTY)
@Validated
public class ImgreSource implements Serializable {
    /**
     * 主键ID
	* 列名:id 类型:VARCHAR(32) 允许空:false 缺省值:null
     */
    @Id
    @KeySql(genId = UUIDGenId.class)
    private String id;

    /**
     * 红包ID
	* 列名:redBagId 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String redBagId;

    /**
     * 类型：IMG 图片；V 视频。
	* 列名:type 类型:VARCHAR(10) 允许空:true 缺省值:null
     */
    private String type;

    /**
     * 资源路径
	* 列名:resourceUrl 类型:VARCHAR(255) 允许空:true 缺省值:null
     */
    private String resourceUrl;

    /**
     * 宽度
	* 列名:width 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer width;

    /**
     * 高度
	* 列名:height 类型:INTEGER(10) 允许空:true 缺省值:null
     */
    private Integer height;

    /**
     * 扩展字段
	* 列名:extend 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String extend;

    /**
     * 提现、创建时间
	* 列名:createDate 类型:VARCHAR(32) 允许空:true 缺省值:null
     */
    private String createDate;

    /**
     * 更新时间
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
     * 红包ID
     * @return redBagId 红包ID
     */
    public String getRedBagId() {
        return redBagId;
    }

    /**
     * 红包ID
     * @param redBagId 红包ID
     */
    public void setRedBagId(String redBagId) {
        this.redBagId = redBagId == null ? null : redBagId.trim();
    }

    /**
     * 类型：IMG 图片；V 视频。
     * @return type 类型：IMG 图片；V 视频。
     */
    public String getType() {
        return type;
    }

    /**
     * 类型：IMG 图片；V 视频。
     * @param type 类型：IMG 图片；V 视频。
     */
    public void setType(String type) {
        this.type = type == null ? null : type.trim();
    }

    /**
     * 资源路径
     * @return resourceUrl 资源路径
     */
    public String getResourceUrl() {
        return resourceUrl;
    }

    /**
     * 资源路径
     * @param resourceUrl 资源路径
     */
    public void setResourceUrl(String resourceUrl) {
        this.resourceUrl = resourceUrl == null ? null : resourceUrl.trim();
    }

    /**
     * 宽度
     * @return width 宽度
     */
    public Integer getWidth() {
        return width;
    }

    /**
     * 宽度
     * @param width 宽度
     */
    public void setWidth(Integer width) {
        this.width = width;
    }

    /**
     * 高度
     * @return height 高度
     */
    public Integer getHeight() {
        return height;
    }

    /**
     * 高度
     * @param height 高度
     */
    public void setHeight(Integer height) {
        this.height = height;
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
     * 提现、创建时间
     * @return createDate 提现、创建时间
     */
    public String getCreateDate() {
        return createDate;
    }

    /**
     * 提现、创建时间
     * @param createDate 提现、创建时间
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