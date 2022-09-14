package cn.whjg.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.whjg.student.entity.Manager;
import cn.whjg.student.service.ManagerService;
import cn.whjg.student.mapper.ManagerMapper;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.UUID;

/**
 * @author 何玥枫
 * @description 针对表【manager】的数据库操作Service实现
 * @createDate 2022-09-13 16:14:52
 */
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager>
        implements ManagerService {

    @Override
    public Manager login(String username, String password) {
        LambdaQueryWrapper<Manager> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Manager::getUsername, username);
//        wrapper.eq(Manager::getPassword, password);
        Manager manager = this.getOne(wrapper);
        if (manager != null) {
            //当前密码与加密后密码比对
            BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
            boolean result = passwordEncoder.matches(password, manager.getPassword());//传入密码与加密密码比对
            if (result) {
                String token = UUID.randomUUID().toString() + System.currentTimeMillis();
                manager.setToken(token);
                this.updateById(manager);
                manager.setPassword(null);//清空密码，安全
            } else {
                manager = null;
            }
        }
        return manager;
    }
}




