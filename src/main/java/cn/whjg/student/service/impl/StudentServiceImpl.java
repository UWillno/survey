package cn.whjg.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.whjg.student.entity.Student;
import cn.whjg.student.service.StudentService;
import cn.whjg.student.mapper.StudentMapper;
import org.springframework.stereotype.Service;

/**
* @author 何玥枫
* @description 针对表【student】的数据库操作Service实现
* @createDate 2022-09-13 16:14:52
*/
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
    implements StudentService{

}




