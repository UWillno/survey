package cn.whjg.student.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;

import cn.whjg.student.common.P;
import cn.whjg.student.common.SurveyVo;
import cn.whjg.student.entity.ItemOptions;
import cn.whjg.student.entity.SurveyItem;
import cn.whjg.student.service.ItemOptionsService;
import cn.whjg.student.service.SurveyItemService;
import cn.whjg.student.mapper.SurveyItemMapper;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author 何玥枫
 * @description 针对表【survey_item】的数据库操作Service实现
 * @createDate 2022-09-13 16:14:52
 */
@Service
public class SurveyItemServiceImpl extends ServiceImpl<SurveyItemMapper, SurveyItem>
        implements SurveyItemService {

    @Autowired
    ItemOptionsService itemOptionsService;

    @Override
    public P selectPage(Map<String, Object> map) {
        LambdaQueryWrapper<SurveyItem> wrapper = new LambdaQueryWrapper<>();
        // 判断map集合中是否包含id条件,如果包含则wrapper添加id条件
        wrapper.like(map.containsKey("surveyText"), SurveyItem::getSurveyText, map.get("surveyText"));
        // wrapper.orderByDesc(SurveyItem::getChecked, SurveyItem::getCreateTime);
        if (map.containsKey("page")) {
            Long current = Long.parseLong(map.get("page").toString());
            Long size = Long.parseLong(map.get("size").toString());
            IPage<SurveyItem> page = new Page<>(current, size);
            page = this.page(page, wrapper);
            List<SurveyItem> surveyItemList = page.getRecords();
            return new P(page.getTotal(), getSurveyVo(surveyItemList));
        } else {
            List<SurveyItem> surveyItemList = this.list(wrapper);
            return new P(0L, getSurveyVo(surveyItemList));
        }
    }

    @Override
    @Transactional
    public boolean insertSurvey(SurveyVo vo) {
        SurveyItem surveyItem = new SurveyItem();
        BeanUtils.copyProperties(vo, surveyItem);
        this.save(surveyItem);
        List<ItemOptions> itemOptionsList = vo.getItemOptionsList();
        itemOptionsList.forEach(ItemOptions -> ItemOptions.setItemId(surveyItem.getId()));
        itemOptionsService.saveBatch(itemOptionsList);
        return true;
    }

    @Override
    @Transactional
    public boolean updateSurvey(SurveyVo vo) {
        SurveyItem surveyItem = new SurveyItem();
        BeanUtils.copyProperties(vo, surveyItem);
        this.updateById(surveyItem);
        LambdaQueryWrapper<ItemOptions> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(ItemOptions::getItemId, surveyItem.getId());
        itemOptionsService.remove(wrapper);// 移除
        List<ItemOptions> itemOptionsList = vo.getItemOptionsList();// 此集合只有述项文字和分
        itemOptionsList.forEach(ItemOptions -> ItemOptions.setItemId(surveyItem.getId()));
        itemOptionsService.saveBatch(itemOptionsList);
        return true;
    }

    private List<SurveyVo> getSurveyVo(List<SurveyItem> surveyItemList) {
        return surveyItemList.stream().map(surveyItem -> {
            SurveyVo vo = new SurveyVo();
            BeanUtils.copyProperties(surveyItem, vo);
            LambdaQueryWrapper<ItemOptions> wrapper = new LambdaQueryWrapper<>();
            wrapper.eq(ItemOptions::getItemId, surveyItem.getId());
            List<ItemOptions> itemOptionsList = itemOptionsService.list(wrapper);
            vo.setItemOptionsList(itemOptionsList);
            return vo;
        }).collect(Collectors.toList());
    }

}
