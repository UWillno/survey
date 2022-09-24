package cn.whjg.student.controller;


import cn.whjg.student.common.R;
import cn.whjg.student.entity.Clazz;
import cn.whjg.student.service.ClazzService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;


@RestController //当所有方法都返回json, 可以为类上添加注解
//跨域
@CrossOrigin(origins = {"http://127.0.0.1:9000"}, allowCredentials = "true")
public class ClazzController {
    @Autowired
    ClazzService clazzService;

    @GetMapping("/clazz/list")
    public R clazzList() {
        return R.OK(clazzService.list());
    }

    @GetMapping("/clazz/{tid}")//根据id查询
    public R clazzById(@PathVariable Integer tid) {
        return R.OK(clazzService.getById(tid));
    }

    @PostMapping("/clazz/insert")
    public R clazzInsert(@RequestBody Clazz clazz) {
        return R.OK(clazzService.save(clazz));
    }

    @PutMapping("/clazz/update")
    public R clazzUpdate(@RequestBody Clazz clazz) {
        return R.OK(clazzService.updateById(clazz));
    }

    @GetMapping("/clazz/select")//分页
    public R clazzSelect(@RequestParam Map<String, Object> params) {
        return R.OK(clazzService.selectPage(params));
    }

    @DeleteMapping("/clazz/delete/{id}")
    public R clazzDelete(@PathVariable Integer id) {
        return R.OK(clazzService.removeById(id));
    }
}
