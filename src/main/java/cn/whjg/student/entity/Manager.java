package cn.whjg.student.entity;

import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import java.io.Serializable;

/**
 * 
 * @TableName manager
 */
@TableName(value ="manager")
public class Manager implements Serializable {
    /**
     * 管理员id
     */
    @TableId(type = IdType.AUTO)
    private Integer id;

    /**
     * 用户名
     */
    private String username;

    /**
     * 密码
     */
    private String password;

    /**
     * token
     */
    private String token;

    @TableField(exist = false)
    private static final long serialVersionUID = 1L;

    /**
     * 管理员id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 管理员id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 用户名
     */
    public String getUsername() {
        return username;
    }

    /**
     * 用户名
     */
    public void setUsername(String username) {
        this.username = username;
    }

    /**
     * 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * token
     */
    public String getToken() {
        return token;
    }

    /**
     * token
     */
    public void setToken(String token) {
        this.token = token;
    }
}