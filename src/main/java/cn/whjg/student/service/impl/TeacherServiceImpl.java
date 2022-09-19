package cn.whjg.student.service.impl;

import cn.whjg.student.common.P;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.whjg.student.entity.Teacher;
import cn.whjg.student.service.TeacherService;
import cn.whjg.student.mapper.TeacherMapper;
import org.springframework.stereotype.Service;

import java.util.Map;

/**
 * @author 何玥枫
 * @description 针对表【teacher】的数据库操作Service实现
 * @createDate 2022-09-13 16:14:52
 */
@Service
public class TeacherServiceImpl extends ServiceImpl<TeacherMapper, Teacher>
        implements TeacherService {

    @Override
    public P selectPage(Map<String, Object> map) {

        LambdaQueryWrapper<Teacher> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(map.containsKey("id"), Teacher::getId, map.get("id"));
        wrapper.like(map.containsKey("teacherName"), Teacher::getTeacherName, map.get("teacherName"));
        wrapper.eq(map.containsKey("status"), Teacher::getStatus, map.get("status"));
        wrapper.orderByDesc(Teacher::getCreateTime);
        if (map.containsKey("page")) {
            long current = Long.parseLong(map.get("page").toString());
            long size = Long.parseLong(map.get("size").toString());
            Page<Teacher> page = new Page<>(current, size);
            page = this.page(page, wrapper);
//            System.out.println(page.toString());
            return new P(page.getTotal(), page.getRecords());
        } else {

            return new P(0L, this.list(wrapper));
        }
    }
}




