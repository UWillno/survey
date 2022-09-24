import http from "@/utils/request";

export default {
  select(params) {
    return http.get("/survey/select", {
      // params: {
      //     id, teacherName, status, page, size
      // }
      params,
    });
  },
  update(teacher) {
    return http.put("/survey/update", teacher);
  },
  insert(teacher) {
    return http.post("/survey/insert", teacher);
  },

  delete(id) {
    return http.delete("/survey/delete/" + id);
  },
};
