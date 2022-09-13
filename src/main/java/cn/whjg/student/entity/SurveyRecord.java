package cn.whjg.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName survey_record
 */
@TableName(value ="survey_record")
public class SurveyRecord implements Serializable {
    /**
     * 记录id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 调查项id
     */
    private Integer itemId;

    /**
     * 满分
     */
    private Integer totalScore;

    /**
     * 选项id
     */
    private Integer optionsId;

    /**
     * 选项得分
     */
    private Integer optionsScore;

    /**
     * 是否合格,0合格,1不合格
     */
    private Integer isOk;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 逻辑删除0正常,1删除
     */
    private Integer isDelete;

    /**
     * 乐观锁
     */
    private Integer version;

    /**
     * 学生编号
     */
    private Integer studentId;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 记录id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 记录id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 调查项id
     */
    public Integer getItemId() {
        return itemId;
    }

    /**
     * 调查项id
     */
    public void setItemId(Integer itemId) {
        this.itemId = itemId;
    }

    /**
     * 满分
     */
    public Integer getTotalScore() {
        return totalScore;
    }

    /**
     * 满分
     */
    public void setTotalScore(Integer totalScore) {
        this.totalScore = totalScore;
    }

    /**
     * 选项id
     */
    public Integer getOptionsId() {
        return optionsId;
    }

    /**
     * 选项id
     */
    public void setOptionsId(Integer optionsId) {
        this.optionsId = optionsId;
    }

    /**
     * 选项得分
     */
    public Integer getOptionsScore() {
        return optionsScore;
    }

    /**
     * 选项得分
     */
    public void setOptionsScore(Integer optionsScore) {
        this.optionsScore = optionsScore;
    }

    /**
     * 是否合格,0合格,1不合格
     */
    public Integer getIsOk() {
        return isOk;
    }

    /**
     * 是否合格,0合格,1不合格
     */
    public void setIsOk(Integer isOk) {
        this.isOk = isOk;
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
     * 逻辑删除0正常,1删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 逻辑删除0正常,1删除
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

    /**
     * 学生编号
     */
    public Integer getStudentId() {
        return studentId;
    }

    /**
     * 学生编号
     */
    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }
}