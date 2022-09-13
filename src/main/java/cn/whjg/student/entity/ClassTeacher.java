package cn.whjg.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName class_teacher
 */
@TableName(value ="class_teacher")
public class ClassTeacher implements Serializable {
    /**
     * 班级老师编号
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 班级编号
     */
    private Integer classId;

    /**
     * 老师编号
     */
    private Integer teacherId;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 乐观锁
     */
    private Integer version;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 班级老师编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 班级老师编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 班级编号
     */
    public Integer getClassId() {
        return classId;
    }

    /**
     * 班级编号
     */
    public void setClassId(Integer classId) {
        this.classId = classId;
    }

    /**
     * 老师编号
     */
    public Integer getTeacherId() {
        return teacherId;
    }

    /**
     * 老师编号
     */
    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
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