package com.zrh.face.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import org.yaml.snakeyaml.events.Event;

import java.util.Date;
import java.io.Serializable;

/**
 * (Face)实体类
 *
 * @author makejava
 * @since 2020-12-27 16:56:06
 */
public class Face implements Serializable {
    private static final long serialVersionUID = 677109398235732967L;

    @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    private String faceToken;

    private Long groupId;

    private Long userId;

    private Date createDate;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFaceToken() {
        return faceToken;
    }

    public void setFaceToken(String faceToken) {
        this.faceToken = faceToken;
    }

    public Long getGroupId() {
        return groupId;
    }

    public void setGroupId(Long groupId) {
        this.groupId = groupId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

}