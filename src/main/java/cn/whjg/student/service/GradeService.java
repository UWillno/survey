package cn.whjg.student.service;

import cn.whjg.student.common.P;
import cn.whjg.student.entity.Grade;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 何玥枫
* @description 针对表【grade】的数据库操作Service
* @createDate 2022-09-13 16:14:52
*/
public interface GradeService extends IService<Grade> {
    P selectPage(Map<String, Object> params);
}
