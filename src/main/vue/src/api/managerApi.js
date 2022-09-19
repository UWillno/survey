import http from "@/utils/request";

export default {
    //登录
    login(username, password) {
        return http.get("/manager/login", {
            params: {
                username, password
            }
        })
    }

}