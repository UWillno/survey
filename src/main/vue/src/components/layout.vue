<template>
  <div style="height: 100%">
<!--  <h1>主页</h1>-->
  <myheader></myheader>
  <mynav></mynav>
  <mymain></mymain>
  </div>
</template>

<script>
import myheader from "./myheader";
import mynav from "./mynav";
import mymain from "./mymain";


export default {
  name: "layout",
  components: {
    myheader,
    mynav,
    mymain
  }
}
</script>

<style scoped>

</style>