package cn.whjg.student.common;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class R {
    private Integer code;
    private String msg;
    private Object data;

    public static R OK() {
        return new R(200, "success", null);
    }

    public static R OK(Object data) {
        return new R(200, "success", data);
    }

    public static R error() {
        return new R(400, "fail", null);
    }


}