package cn.whjg.student.controller;



import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import cn.whjg.student.common.R;
import cn.whjg.student.entity.Student;
import cn.whjg.student.service.ClazzService;
import cn.whjg.student.service.StudentService;



@RestController // 当所有方法都返回json, 可以为类上添加注解
@CrossOrigin(origins = { "http://127.0.0.1:9000" }, allowCredentials = "true")
public class StudentController {
    @Autowired
    StudentService studentService;
    @Autowired
    ClazzService clazzService;

    @GetMapping("/student/select")
    public R studentSelect(@RequestParam Map<String, Object> params) {
        return R.OK(studentService.selectPage(params));
    }

    @DeleteMapping("/student/delete/{sid}")
    public R studentDelete(@PathVariable Integer sid) {
        return R.OK(studentService.removeById(sid));
    }

    @PostMapping("/student/insert")
    public R studentInsert(@RequestBody Student student) {
        return R.OK(studentService.save(student));
    }

    @PutMapping("/student/update")
    public R studentUpdate(@RequestBody Student student) {
        return R.OK(studentService.updateById(student));
    }

    @GetMapping("/student/classlist")
    public R classlist(){
        return R.OK(clazzService.list());
    }

}
