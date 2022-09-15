package cn.whjg.student.controller;

import cn.whjg.student.common.R;
import cn.whjg.student.entity.Manager;
import cn.whjg.student.service.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.*;


@RestController
@CrossOrigin(origins = {"http://127.0.0.1:9000"}, allowCredentials = "true") // 跨域
public class ManagerController {

    @Autowired
    ManagerService managerService;

    @GetMapping("/manager/login")
    public R login(String username, String password) {
        return R.OK(managerService.login(username, password));
    }

    @PostMapping("/manager/register")
    public R register(@RequestBody Manager manager) {
        BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
        manager.setPassword(passwordEncoder.encode(manager.getPassword()));
        return R.OK(managerService.save(manager));
    }
}
