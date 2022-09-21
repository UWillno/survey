import http from '../utils/request.js'

export default {
	gradeList(){
		return http.get("/grade/list")
	}
}