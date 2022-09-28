package cn.whjg.student.service;

import cn.whjg.student.entity.ClassTeacher;
import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 何玥枫
* @description 针对表【class_teacher】的数据库操作Service
* @createDate 2022-09-13 16:14:52
*/
public interface ClassTeacherService extends IService<ClassTeacher> {

    boolean removeTeacher(Integer cid, Integer tid);

}
