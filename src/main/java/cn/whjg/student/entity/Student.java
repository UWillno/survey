package cn.whjg.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;
import java.util.Date;

/**
 * 
 * @TableName student
 */
@TableName(value ="student")
public class Student implements Serializable {
    /**
     * 学生的id
     */
    @TableId(type = IdType.AUTO)
    private Integer studnetId;

    /**
     * 学生的学号
     */
    private String studentNo;

    /**
     * 学生姓名
     */
    private String studentName;

    /**
     * 学生性别,0女,1男
     */
    private Integer gender;

    /**
     * 学生手机号码
     */
    private String phoneNumber;

    /**
     * 出生日期
     */
    private Date bornday;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 班级编号
     */
    private Integer classId;

    /**
     * 状态,1正常,2请假,3休学,4毕业
     */
    private Integer status;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 逻辑删除,0正常,1删除
     */
    private Integer isDelete;

    /**
     * 乐观所
     */
    private Integer version;

    /**
     * 微信的唯一Id
     */
    private String openid;

    /**
     * 用户微信的密钥
     */
    private String sessionkey;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 学生的id
     */
    public Integer getStudnetId() {
        return studnetId;
    }

    /**
     * 学生的id
     */
    public void setStudnetId(Integer studnetId) {
        this.studnetId = studnetId;
    }

    /**
     * 学生的学号
     */
    public String getStudentNo() {
        return studentNo;
    }

    /**
     * 学生的学号
     */
    public void setStudentNo(String studentNo) {
        this.studentNo = studentNo;
    }

    /**
     * 学生姓名
     */
    public String getStudentName() {
        return studentName;
    }

    /**
     * 学生姓名
     */
    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    /**
     * 学生性别,0女,1男
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 学生性别,0女,1男
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 学生手机号码
     */
    public String getPhoneNumber() {
        return phoneNumber;
    }

    /**
     * 学生手机号码
     */
    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    /**
     * 出生日期
     */
    public Date getBornday() {
        return bornday;
    }

    /**
     * 出生日期
     */
    public void setBornday(Date bornday) {
        this.bornday = bornday;
    }

    /**
     * 登录密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 登录密码
     */
    public void setPassword(String password) {
        this.password = password;
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
     * 状态,1正常,2请假,3休学,4毕业
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态,1正常,2请假,3休学,4毕业
     */
    public void setStatus(Integer status) {
        this.status = status;
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
     * 乐观所
     */
    public Integer getVersion() {
        return version;
    }

    /**
     * 乐观所
     */
    public void setVersion(Integer version) {
        this.version = version;
    }

    /**
     * 微信的唯一Id
     */
    public String getOpenid() {
        return openid;
    }

    /**
     * 微信的唯一Id
     */
    public void setOpenid(String openid) {
        this.openid = openid;
    }

    /**
     * 用户微信的密钥
     */
    public String getSessionkey() {
        return sessionkey;
    }

    /**
     * 用户微信的密钥
     */
    public void setSessionkey(String sessionkey) {
        this.sessionkey = sessionkey;
    }
}