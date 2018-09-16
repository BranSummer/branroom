package org.bran.branroom.entity;

import java.io.Serializable;
import java.util.Date;

public class TopBolgModel implements Serializable {
    private Integer id;

    private Integer blogId;

    private Integer order;

    private Date createTime;

    private Date updateTime;

    private static final long serialVersionUID = 1L;

    public TopBolgModel(Integer id, Integer blogId, Integer order, Date createTime, Date updateTime) {
        this.id = id;
        this.blogId = blogId;
        this.order = order;
        this.createTime = createTime;
        this.updateTime = updateTime;
    }

    public TopBolgModel() {
        super();
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public Integer getOrder() {
        return order;
    }

    public void setOrder(Integer order) {
        this.order = order;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", blogId=").append(blogId);
        sb.append(", order=").append(order);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}