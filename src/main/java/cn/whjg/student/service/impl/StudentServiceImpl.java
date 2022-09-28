package cn.whjg.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.whjg.student.common.P;
import cn.whjg.student.common.StudentVo;
import cn.whjg.student.entity.Student;
import cn.whjg.student.service.ClazzService;
import cn.whjg.student.service.StudentService;
import cn.whjg.student.mapper.StudentMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author 何玥枫
 * @description 针对表【student】的数据库操作Service实现
 * @createDate 2022-09-13 16:14:52
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student>
        implements StudentService {

    @Autowired
    ClazzService clazzService;

    @Override
    public P selectPage(Map<String, Object> map) {

        LambdaQueryWrapper<Student> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(map.containsKey("studentNo"), Student::getStudentNo, map.get("studentNo"));
        wrapper.like(map.containsKey("studentName"), Student::getStudentName, map.get("studentName"));
        wrapper.eq(map.containsKey("status"), Student::getStatus, map.get("status"));
        wrapper.orderByAsc(Student::getClassId);

        if (map.containsKey("page")) {
            long current = Long.parseLong(map.get("page").toString());
            long size = Long.parseLong(map.get("size").toString());
            Page<Student> page = new Page<>(current, size);
            page = this.page(page, wrapper);
            List<Student> studentList = page.getRecords();

            return new P(page.getTotal(), getStudentVo(studentList));
        } else {
            List<Student> studentList = this.list(wrapper);

            return new P(0L, getStudentVo(studentList));
        }
    }

    private List<StudentVo> getStudentVo(List<Student> studentList) {
        List<StudentVo> voList = studentList.stream().map(mapper -> {
            StudentVo vo = new StudentVo();
            BeanUtils.copyProperties(mapper, vo);
            // Clazz clazz=
            try {
                vo.setClassName(clazzService.getById(mapper.getClassId()).getClassName());
            } catch (Exception e) {
                // System.out.print("找不到班级");
                vo.setClassName("未设置的班级");
            }
            // System.out.println(vo.toString());
            // System.out.println(mapper.getClassId());
            return vo;
        }).collect(Collectors.toList());
        return voList;
    }

}
