package cn.whjg.student.common;


import cn.whjg.student.entity.Clazz;
import cn.whjg.student.entity.Teacher;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ClazzVo extends Clazz {
    private String gradeName;

    private Integer count;

    private List<Teacher> teacherList;
}
