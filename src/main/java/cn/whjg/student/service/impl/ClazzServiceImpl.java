package cn.whjg.student.service.impl;

import cn.whjg.student.common.ClazzVo;
import cn.whjg.student.common.P;
import cn.whjg.student.entity.*;
import cn.whjg.student.mapper.ClazzMapper;
import cn.whjg.student.service.*;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.swing.plaf.synth.SynthTabbedPaneUI;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
    @Autowired
    StudentService studentService;
    @Autowired
    ClazzService clazzService;
    @Autowired
    TeacherService teacherService;
    @Autowired
    ClassTeacherService classTeacherService;
    @Autowired
    GradeService gradeService;

    @Override
    public P selectPage(Map<String, Object> map) {
        //构建多条件  编号,老师姓名模糊查询, 状态
        LambdaQueryWrapper<Clazz> wrapper = new LambdaQueryWrapper<>();
        //判断map集合中是否包含id条件,如果包含则wrapper添加id条件
        wrapper.eq(map.containsKey("gradeId"), Clazz::getId, map.get("gradeId"));
        wrapper.like(map.containsKey("className"), Clazz::getClassName, map.get("className"));
        wrapper.eq(map.containsKey("status"), Clazz::getStatus, map.get("status"));
        wrapper.orderByDesc(Clazz::getCreateTime);

        //判断是否包含分页条件(分页 page当前页, size每页条数 )
        if (map.containsKey("page")) {  //page表示当前页
            Long current = Long.parseLong(map.get("page").toString());
            Long size = Long.parseLong(map.get("size").toString());
            Page<Clazz> page = new Page<>(current, size);//创建分页对象
            page = this.page(page, wrapper);//多条件分页查询
            List<Clazz> clazzList = page.getRecords();
            //班级集合clazz转为clazzVo

            return new P(page.getTotal(), getClazzVo(clazzList));
        } else {
            List<Clazz> clazzList = this.list(wrapper);
            return new P(0L, getClazzVo(clazzList));
        }
    }

    private List<ClazzVo> getClazzVo(List<Clazz> clazzList) {
        List<ClazzVo> voList = clazzList.stream().map(clazz -> {
            ClazzVo vo = new ClazzVo();
            BeanUtils.copyProperties(clazz, vo);

//            //查询年级名
//                gradeService.getById(clazz.getId())
//            System.out.print(clazz.getGradeId().toString());
//            System.out.print(gradeService.getById(clazz.getGradeId()).getGradeName());
//            System.out.println(grade.toString());
//            String gradeName=grade.getGradeName();
//            System.out.print(gradeName);
            Grade grade=gradeService.getById(clazz.getGradeId());
            vo.setGradeName(grade.getGradeName());

            //查询班级人数
            LambdaQueryWrapper<Student> wrapper1 = new LambdaQueryWrapper<>();
            wrapper1.eq(Student::getClassId, clazz.getId());
            int count = studentService.count(wrapper1);
            vo.setCount(count);
            //查询老师集合
            LambdaQueryWrapper<ClassTeacher> wrapper2 = new LambdaQueryWrapper<>();
            wrapper2.eq(ClassTeacher::getClassId, clazz.getId());
            List<ClassTeacher> classTeacherList = classTeacherService.list(wrapper2);
            List<Integer> idList = classTeacherList.stream().map(ClassTeacher::getTeacherId).collect(Collectors.toList());
            List<Teacher> teacherList = new ArrayList<>();

            if (idList.size() != 0)
                teacherList = teacherService.listByIds(idList);

            vo.setTeacherList(teacherList);
//            System.out.println(vo.toString());
            return vo;

        }).collect(Collectors.toList());
        return voList;
    }
}




