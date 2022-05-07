<template>
  <div id="contentBody">
    <div>
      <Dotask
        class="item"
        :dotasksList="dotasksList"
        style="width: 100%"
      ></Dotask>
      <last-product class="item1"></last-product>
    </div>
  </div>
</template>
<script>
import Dotask from './Dotask.vue'
import LastProduct from '@/components/LastProduct.vue'
export default {
  components: {
    Dotask,
    LastProduct
  },
  data () {
    return {
      dotasksList: []
    }
  },
  methods: {

  }
}
</script>
<style scoped lang="less">
#contentBody {
  height: 880px;
  overflow: auto;
  > div {
    display: flex;
    background-color: rgb(10, 144, 235);
    flex-direction: column;
    justify-content: space-between;
    .item {
      width: 100px;
      flex-grow: 1;
      margin-right: 0px;
    }
    .item:last-child {
      margin-right: 0;
    }
  }
  > div:nth-child(1) {
    margin-bottom: 10px;
    min-height: 440px;
  }
}
</style>
