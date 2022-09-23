import http from "@/utils/request";

export default {
  select(params) {
    return http.get("/teacher/select", {
      // params: {
      //     id, teacherName, status, page, size
      // }
      params,
    });
  },
  update(teacher) {
    return http.put("/teacher/update", teacher);
  },
  insert(teacher) {
    return http.post("/teacher/insert", teacher);
  },

  delete(id) {
    return http.delete("/teacher/delete/" + id);
  },
};
