package cn.whjg.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName clazz
 */
@TableName(value ="clazz")
public class Clazz implements Serializable {
    /**
     * 班级的id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 班级名称
     */
    private String className;

    /**
     * 年级id
     */
    private Integer gradeId;

    /**
     * 创建修改事件
     */
    private Date createTime =new Date();

    /**
     * 逻辑删除,0为正常,1为删除
     */
    private Integer isDelete =1;

    /**
     * 班级状态,1为正常,2为实习,3为毕业
     */
    private Integer status;

    /**
     * 乐观锁
     */
    private Integer version =0;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 班级的id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 班级的id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 班级名称
     */
    public String getClassName() {
        return className;
    }

    /**
     * 班级名称
     */
    public void setClassName(String className) {
        this.className = className;
    }

    /**
     * 年级id
     */
    public Integer getGradeId() {
        return gradeId;
    }

    /**
     * 年级id
     */
    public void setGradeId(Integer gradeId) {
        this.gradeId = gradeId;
    }

    /**
     * 创建修改事件
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建修改事件
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 逻辑删除,0为正常,1为删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 逻辑删除,0为正常,1为删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 班级状态,1为正常,2为实习,3为毕业
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 班级状态,1为正常,2为实习,3为毕业
     */
    public void setStatus(Integer status) {
        this.status = status;
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