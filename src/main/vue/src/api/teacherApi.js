import http from "@/utils/request";

export default {
    list(id, teacherName, status, page, size) {
        return http.get("/teacher/list", {
            params: {
                id, teacherName, status, page, size
            }
        })
    }
}