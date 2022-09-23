import http from "@/utils/request";

export default {
  removeTeacher(cid, tid) {
    return http.delete("/classteacher/delete", {
      params: {
        cid,
        tid,
      },
    });
  },
};
