package cn.whjg.student.common;

import lombok.Data;

import java.util.List;

@Data
public class P {
    private long total;
    private List<?> list;

    public P(long total, List<?> records) {
        this.total = total;
        this.list = records;
    }

//    public P(long total, List<ClazzVo> clazzVo) {
//        this.total=total;
//        this.list=clazzVo;
//    }


//    public P(long total, List<?> records) {
//        this.total = total;
//        this.list = records;
//    }
}
