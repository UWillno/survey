import http from "@/utils/request";

export default {
    select({id, teacherName, status, page, size}) {
        return http.get("/teacher/select", {
            params: {
                id, teacherName, status, page, size
            }
        })
    }
}