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
import cn.whjg.student.entity.Grade;
import cn.whjg.student.service.GradeService;

@RestController //当所有方法都返回json, 可以为类上添加注解
//跨域
@CrossOrigin(origins = {"http://127.0.0.1:9000"},allowCredentials = "true")
public class GradeController {
    @Autowired
    GradeService gradeService;
    @GetMapping("/grade/list")
    public R gradeList(){return R.OK(gradeService.list());}


    @DeleteMapping("/grade/delete/{tid}")
    public R gradeDelete(@PathVariable Integer tid) {
        return R.OK(gradeService.removeById(tid));
    }

    @GetMapping("/grade/{tid}")
    public R gradeById(@PathVariable Integer tid) {
        return R.OK(gradeService.getById(tid));
    }

    @PutMapping("/grade/update")
    public R gradeUpdate(@RequestBody Grade grade) {
        return R.OK(gradeService.updateById(grade));
    }


    //查询条件 姓名tname 编号tid 状态status
    //page第几页 size每页多少
    @GetMapping("/grade/select")
    public R gradeSelect(@RequestParam Map<String, Object> map) {
        return R.OK(gradeService.selectPage(map));
    }

    @PostMapping("/grade/insert")
    public R gradeInsert(@RequestBody Grade grade) {
        return R.OK(gradeService.save(grade));
    }

}
