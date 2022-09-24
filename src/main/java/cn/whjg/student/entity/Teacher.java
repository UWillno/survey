package cn.whjg.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;

import java.io.Serializable;
import java.util.Date;

/**
 * @TableName teacher
 */
@TableName(value = "teacher")
public class Teacher implements Serializable {
    /**
     * 老师id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 老师姓名
     */
    private String teacherName;

    /**
     * 老师性别,0女,1男
     */
    private Integer gender;

    /**
     * 老师手机号码(登录账号)
     */
    private String phonenumber;

    /**
     * 出生日期
     */
    private Date bornday;

    /**
     * 登录密码
     */
    private String password;

    /**
     * 创建时间
     */
    private Date createTime = new Date();

    /**
     * 状态,1正常,2休假,3离职,4退休
     */
    private Integer status = 1;

    /**
     * 逻辑删除,0正常,1删除
     */
    private Object isDelete=1;

    /**
     * 乐观锁
     */
    private Integer version = 0;

    /**
     * 权限等级,0为管理员,1为老师
     */
    private Integer level = 1;

    /**
     * 登录令牌
     */
    private String token = "";

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 老师id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 老师id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 老师姓名
     */
    public String getTeacherName() {
        return teacherName;
    }

    /**
     * 老师姓名
     */
    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    /**
     * 老师性别,0女,1男
     */
    public Integer getGender() {
        return gender;
    }

    /**
     * 老师性别,0女,1男
     */
    public void setGender(Integer gender) {
        this.gender = gender;
    }

    /**
     * 老师手机号码(登录账号)
     */
    public String getPhonenumber() {
        return phonenumber;
    }

    /**
     * 老师手机号码(登录账号)
     */
    public void setPhonenumber(String phonenumber) {
        this.phonenumber = phonenumber;
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
     * 状态,1正常,2休假,3离职,4退休
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态,1正常,2休假,3离职,4退休
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 逻辑删除,0正常,1删除
     */
    public Object getIsDelete() {
        return isDelete;
    }

    /**
     * 逻辑删除,0正常,1删除
     */
    public void setIsDelete(Object isDelete) {
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
     * 权限等级,0为管理员,1为老师
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 权限等级,0为管理员,1为老师
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 登录令牌
     */
    public String getToken() {
        return token;
    }

    /**
     * 登录令牌
     */
    public void setToken(String token) {
        this.token = token;
    }
}