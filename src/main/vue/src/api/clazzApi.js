import http from "../utils/request.js";

export default {
  list({ gradeId, className, status, page, size }) {
    return http.get("/clazz/list", {
      params: {
        gradeId,
        className,
        status,
        page,
        size,
      },
    });
  },
  select({ gradeId, className, id, page, size }) {
    return http.get("/clazz/select", {
      params: {
        className,
        gradeId,
        id,
        page,
        size,
      },
    });
  },
  insert(data) {
    return http.post("/clazz/insert", data);
  },
  update(data) {
    return http.put("clazz/update", data);
  },
  delete(id) {
    return http.delete("/clazz/delete/" + id);
  },
};
