package cn.whjg.student.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import cn.whjg.student.entity.Manager;
import cn.whjg.student.service.ManagerService;
import cn.whjg.student.mapper.ManagerMapper;
import org.springframework.stereotype.Service;

/**
* @author 何玥枫
* @description 针对表【manager】的数据库操作Service实现
* @createDate 2022-09-13 16:14:52
*/
@Service
public class ManagerServiceImpl extends ServiceImpl<ManagerMapper, Manager>
    implements ManagerService{

}




