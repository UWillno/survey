package cn.whjg.student.common;


import lombok.Data;

import java.util.List;

import cn.whjg.student.entity.ItemOptions;
import cn.whjg.student.entity.SurveyItem;
@Data
public class SurveyVo extends SurveyItem {
    private List<ItemOptions> itemOptionsList;
}
