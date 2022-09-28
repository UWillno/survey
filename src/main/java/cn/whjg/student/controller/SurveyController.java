package cn.whjg.student.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import cn.whjg.student.common.R;
import cn.whjg.student.common.SurveyVo;
import cn.whjg.student.service.SurveyItemService;

import java.util.Map;

@RestController //当所有方法都返回json, 可以为类上添加注解
//跨域
@CrossOrigin(origins = {"http://127.0.0.1:9000"}, allowCredentials = "true")
public class SurveyController {
    @Autowired
    SurveyItemService surveyItemService;

    @DeleteMapping("/survey/delete/{id}")
    public R surveyDelete(@PathVariable Integer id) {
        return R.OK(surveyItemService.removeById(id));
    }

    @PostMapping("/survey/insert")
    public R surveyInsert(@RequestBody SurveyVo vo) {
        System.out.println(vo);
        return R.OK(surveyItemService.insertSurvey(vo));
    }

    @PutMapping("/survey/update")
    public R surveyUpdate(@RequestBody  SurveyVo vo) {
        return R.OK(surveyItemService.updateSurvey(vo));
    }

//    @PutMapping("/survey/updatechecked")
//    public R surveyUpdatechecked(@RequestBody SurveyItem surveyItem) {
//        return R.OK(surveyItemService.updatechecked(surveyItem));
//    }

    //分页
    @GetMapping("/survey/select")
    public R surveySelect(@RequestParam Map<String, Object> map) {
        return R.OK(surveyItemService.selectPage(map));
    }
}
