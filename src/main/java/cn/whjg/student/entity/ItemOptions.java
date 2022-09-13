package cn.whjg.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName item_options
 */
@TableName(value ="item_options")
public class ItemOptions implements Serializable {
    /**
     * 选项id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 选项内容
     */
    private String context;

    /**
     * 选项分值
     */
    private Integer score;

    /**
     * 调查项的id
     */
    private Integer itemId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 逻辑删除,0正常,1删除
     */
    private Integer isDelete;

    /**
     * 乐观锁
     */
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 选项id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 选项id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 选项内容
     */
    public String getContext() {
        return context;
    }

    /**
     * 选项内容
     */
    public void setContext(String context) {
        this.context = context;
    }

    /**
     * 选项分值
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 选项分值
     */
    public void setScore(Integer score) {
        this.score = score;
    }

    /**
     * 调查项的id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 调查项的id
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 逻辑删除,0正常,1删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 逻辑删除,0正常,1删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 乐观锁
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 乐观锁
     */
    public void setVersion(Integer version) {
        this.version = version;
    }
}