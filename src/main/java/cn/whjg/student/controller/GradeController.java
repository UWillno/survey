package cn.whjg.student.controller;



import cn.whjg.student.common.R;
import cn.whjg.student.service.GradeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController //当所有方法都返回json, 可以为类上添加注解
//跨域
@CrossOrigin(origins = {"http://127.0.0.1:9000"},allowCredentials = "true")
public class GradeController {
    @Autowired
    GradeService gradeService;
    @GetMapping("/grade/list")
    public R gradeList(){return R.OK(gradeService.list());}
}
