package cn.whjg.student.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName grade
 */
@TableName(value = "grade")
public class Grade implements Serializable {
    /**
     * 年级的id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 年级名称
     */
    private String gradeName;

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 状态,1正常,2实习,3毕业
     */
    private Integer status;

    /**
     * 逻辑删除
     */
    private Integer isDelete = 0;

    /**
     * 乐观锁
     */
    private Integer version = 1;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 年级的id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 年级的id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 年级名称
     */
    public String getGradeName() {
        return gradeName;
    }

    /**
     * 年级名称
     */
    public void setGradeName(String gradeName) {
        this.gradeName = gradeName;
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
     * 状态,1正常,2实习,3毕业
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态,1正常,2实习,3毕业
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 逻辑删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 逻辑删除
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