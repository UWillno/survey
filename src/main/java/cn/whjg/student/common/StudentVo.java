package cn.whjg.student.common;


import cn.whjg.student.entity.Student;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
public class StudentVo extends Student {
    String className;

  
}
