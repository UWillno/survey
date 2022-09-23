import http from "@/utils/request";

export default {
  removeTeacher(cid, tid) {
    return http.delete("/clazzteacher/delete", {
      params: {
        cid,
        tid,
      },
    });
  },
  insert(data) {
    console.log(data);
    return http.post("/clazzteacher/insert", data);
  },
};
