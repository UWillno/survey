<template>
  <div style="height:100%">
    <myheader></myheader>
    <div style="height: calc(100% - 80px);padding-top: 80px;">
      <mynav></mynav>
      <mymain></mymain>
    </div>

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