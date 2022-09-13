package cn.whjg.student.common;

import cn.whjg.student.entity.Teacher;
import lombok.Data;

import java.util.List;

@Data
public class P {
    private long total;
    private List<?> list;

    public P(long total, List<Teacher> records) {
        this.total = total;
        this.list = records;
    }

//    public P(long total, List<?> records) {
//        this.total = total;
//        this.list = records;
//    }
}
