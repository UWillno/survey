package cn.whjg.student.service;

import cn.whjg.student.common.P;
import cn.whjg.student.entity.Teacher;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * @author 何玥枫
 * @description 针对表【teacher】的数据库操作Service
 * @createDate 2022-09-13 16:14:52
 */
public interface TeacherService extends IService<Teacher> {
    P selectPage(Map<String, Object> params);
}
