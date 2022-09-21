import http from "@/utils/request";

export default {
    select({id, teacherName, status, page, size}) {
        return http.get("/teacher/select", {
            params: {
                id, teacherName, status, page, size
            }
        })
    },
    update(teacher){
        return http.put("/teacher/update",teacher);
    },
    insert(teacher){
        return http.post("/teacher/insert",teacher);
    },

    delete(id){
        return http.delete("/teacher/delete/"+id);
    }
}
