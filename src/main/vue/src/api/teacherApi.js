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
  select({id, teacherName, status, page, size}) {
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
};
