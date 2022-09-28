package cn.whjg.student.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;

import cn.whjg.student.common.R;
import cn.whjg.student.entity.ClassTeacher;
import cn.whjg.student.service.ClassTeacherService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController //当所有方法都返回json, 可以为类上添加注解
//跨域
@CrossOrigin(origins = {"http://127.0.0.1:9000"},allowCredentials = "true")

public class ClazzTeacherController {
    @Autowired
    ClassTeacherService classTeacherService;

    @DeleteMapping("/clazzteacher/delete")
    public  R clazzTeacherdelete(Integer cid,Integer tid){
        System.out.println(cid+","+tid);
        return R.OK(classTeacherService.removeTeacher(cid,tid));

    }
    @PostMapping("/clazzteacher/insert")
    public R clazzteacherInsert(@RequestBody List<ClassTeacher> list){
        System.out.println(list);
        return R.OK(classTeacherService.saveBatch(list));

    }
}

