<template>
<div class="myheader">
  <div class="logo" style="float: left;padding-left: 40px"><img src="https://www.kaspersky.com/siterenderer/_next/static/media/kaspersky-logo.e79ac6c57fcaf0a58fbb62a8a5d56786.svg" /></div>
  <span class="title" style="color: forestgreen">
    武昌首义欢迎你
  </span>
</div>
</template>

<script>
export default {
  name: "myheader"
}
</script>

<style scoped>
.myheader{
  height: 80px;
  background-color: white;
  /*display: flex;*/
  line-height: 80px;
  justify-content: center;
  align-items: center;
}
.title{
  font-size: 30px;
}
</style>