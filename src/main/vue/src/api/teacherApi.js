import http from "@/utils/request";

export default {
  //分页查询
  list(id, teacherName, status, page, size) {
    return http.get("/teacher/list", {
      params: {
        id,
        teacherName,
        status,
        page,
        size,
      },
    });
  },
  select({ id, teacherName, status, page, size }) {
    console.log(id);
    return http.get("/teacher/select", {
      params: {
        teacherName,
        id,
        status,
        page,
        size,
      },
    });
  },
  insert(data) {
    return http.post("/teacher/insert", data);
  },
  update(data) {
    return http.put("/teacher/update", data);
  },
  delete(id) {
    return http.delete(`/teacher/delete/${id}`);
  },
  delete(id){
    return http.delete(`teacher/delete/${id}`)
  }
};
