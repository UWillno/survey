package cn.whjg.student.controller;

import cn.whjg.student.common.R;
import cn.whjg.student.entity.Teacher;
import cn.whjg.student.service.TeacherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController //当所有方法都返回json, 可以为类上添加注解
@CrossOrigin(origins = {"http://127.0.0.1:9000"}, allowCredentials = "true") // 跨域
public class TeacherController {
    @Autowired
    TeacherService teacherService;

    @GetMapping("/teacher/list")
    public R teacherList() {  //查询所有老师  .list()  ctrl+alt+v : 自动接收返回值
        return R.OK(teacherService.list());
    }

    @PostMapping("/teacher/insert")
    public R teacherInsert(@RequestBody Teacher teacher) {
        return R.OK(teacherService.save(teacher));
    }

    @DeleteMapping("/teacher/delete/{tid}")
    public R teacherDelete(@PathVariable Integer tid) {
        return R.OK(teacherService.removeById(tid));
    }

    @GetMapping("/teacher/{tid}")
    public R teacherById(@PathVariable Integer tid) {
        return R.OK(teacherService.getById(tid));
    }

    @PutMapping("/teacher/update")
    public R teacherUpdate(@RequestBody Teacher teacher) {
        return R.OK(teacherService.updateById(teacher));
    }


    //查询条件 姓名tname 编号tid 状态status
    //page第几页 size每页多少
    @GetMapping("/teacher/select")
    public R teacherSelect(@RequestParam Map<String, Object> params) {
        return R.OK(teacherService.selectPage(params));
    }


}
