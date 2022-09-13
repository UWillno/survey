package cn.whjg.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName survey_item
 */
@TableName(value ="survey_item")
public class SurveyItem implements Serializable {
    /**
     * 调查项id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 调查内容
     */
    private String surveyText;

    /**
     * 分值
     */
    private Integer score;

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

    /**
     * 是否启动,0未启用, 1启用
     */
    private Integer checked;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 调查项id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 调查项id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 调查内容
     */
    public String getSurveyText() {
        return surveyText;
    }

    /**
     * 调查内容
     */
    public void setSurveyText(String surveyText) {
        this.surveyText = surveyText;
    }

    /**
     * 分值
     */
    public Integer getScore() {
        return score;
    }

    /**
     * 分值
     */
    public void setScore(Integer score) {
        this.score = score;
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

    /**
     * 是否启动,0未启用, 1启用
     */
    public Integer getChecked() {
        return checked;
    }

    /**
     * 是否启动,0未启用, 1启用
     */
    public void setChecked(Integer checked) {
        this.checked = checked;
    }
}