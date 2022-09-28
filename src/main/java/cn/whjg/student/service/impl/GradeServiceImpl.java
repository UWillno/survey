package cn.whjg.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.whjg.student.common.P;
import cn.whjg.student.entity.Grade;
import cn.whjg.student.service.GradeService;
import cn.whjg.student.mapper.GradeMapper;

import java.util.Map;

import org.springframework.stereotype.Service;

/**
 * @author 何玥枫
 * @description 针对表【grade】的数据库操作Service实现
 * @createDate 2022-09-13 16:14:52
 */
@Service
public class GradeServiceImpl extends ServiceImpl<GradeMapper, Grade>
        implements GradeService {
    @Override
    public P selectPage(Map<String, Object> map) {
        // TODO Auto-generated method stub
        LambdaQueryWrapper<Grade> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(map.containsKey("id"), Grade::getId, map.get("id"));
        wrapper.eq(map.containsKey("gradeName"), Grade::getGradeName, map.get("gradeName"));
        wrapper.eq(map.containsKey("status"), Grade::getStatus, map.get("status"));
        wrapper.orderByDesc(Grade::getCreateTime);

        if (map.containsKey("page")) {
            long current = Long.parseLong(map.get("page").toString());
            long size = Long.parseLong(map.get("size").toString());
            Page<Grade> page = new Page<>(current, size);
            page = this.page(page, wrapper);
            // System.out.println(page.toString());
            return new P(page.getTotal(), page.getRecords());
        } else {

            return new P(0L, this.list(wrapper));
        }
    }
}
