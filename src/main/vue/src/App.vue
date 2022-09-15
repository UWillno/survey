<template>
	<div id="app">
		<!-- <img alt="Vue logo" src="./assets/logo.png">
    <HelloWorld msg="Welcome to Your Vue.js App"/> -->
<!--		<login></login>-->
    <router-view></router-view>
	</div>
</template>

<script>
export default {
  name:'app',
}
	// import login from "@/components/login.vue"
	// export default {
	// 	name: 'app',
	// 	components: {
	// 		login
	// 	}
	// }
</script>

<style>
	#app,html,body {
    margin: 0;
    padding: 0;
		text-align: center;
		color: #2c3e50;
		/*margin-top: 60px;*/
    height: 100%;
	}
</style>
