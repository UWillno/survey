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
</script>

<style>
@import "~@/assets/restes.css";
	#app,html,body {
    margin: 0;
    padding: 0;
    height: 100%;
	}
</style>
