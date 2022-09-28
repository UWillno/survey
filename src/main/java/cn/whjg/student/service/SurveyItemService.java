package cn.whjg.student.service;

import cn.whjg.student.common.P;
import cn.whjg.student.common.SurveyVo;
import cn.whjg.student.entity.SurveyItem;

import java.util.Map;

import com.baomidou.mybatisplus.extension.service.IService;

/**
* @author 何玥枫
* @description 针对表【survey_item】的数据库操作Service
* @createDate 2022-09-13 16:14:52
*/
public interface SurveyItemService extends IService<SurveyItem> {
    P selectPage(Map<String, Object> map);

    boolean insertSurvey(SurveyVo vo);

    boolean updateSurvey(SurveyVo vo);
}
