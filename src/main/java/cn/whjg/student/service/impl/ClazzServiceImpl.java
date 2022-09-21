package cn.whjg.student.service.impl;

import cn.whjg.student.common.ClazzVo;
import cn.whjg.student.common.P;
import cn.whjg.student.entity.Clazz;
import cn.whjg.student.entity.Student;
import cn.whjg.student.mapper.ClazzMapper;
import cn.whjg.student.service.ClazzService;
import cn.whjg.student.service.GradeService;
import cn.whjg.student.service.StudentService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;


@Service
public class ClazzServiceImpl extends ServiceImpl<ClazzMapper, Clazz> implements ClazzService {
    @Autowired
    StudentService studentService;
    ClazzService clazzService;
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

//            //查询年级名称
//            Grade grade = gradeService.getById(clazz.getGradeId());
//            vo.setGradeName(grade.getGradeName());

            //查询班级人数
            LambdaQueryWrapper<Student> wrapper1 = new LambdaQueryWrapper<>();
            wrapper1.eq(Student::getClassId, clazz.getId());
            int count = studentService.count(wrapper1);
            vo.setCount(count);

            //查询老师集合


            return vo;
        }).collect(Collectors.toList());
        return voList;
    }
}




