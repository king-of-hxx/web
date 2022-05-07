<template>
  <div class="layout-content">
    <div class="body">
      <header>
        <span style="font-size: 1.5rem">消息</span>
        <i @click="TB" class="el-icon-menu" style="font-size: 2rem; color: #ffffff"></i>
      </header>
      <div style="background-color: #0074d9">
        <div
          class="pipeTable"
          style="margin-left: 4px; background-color: #0074d9"
        >
<!--          <el-menu class="el-menu-vertical-demo" @open="handleOpen" @close="handleClose" :collapse="isCollapse">-->
          <el-table
            :data="tableData"
            stripe
            style="width: 100%"
            cell-class-name="cell-class-name"
            :header-cell-style="{
              color: 'rgb(38,38,38)',
            }"
            header-row-class-name="tableHead"
          >
            <el-table-column width="100px">
              <template slot="header">
                <span
                  >
                  <el-image style="height: 33px" :src="require('../../static/img/homeimg/u172.png')"></el-image>
                </span>
              </template>
              <template slot-scope="scope">
                <el-button v-if="scope.row.stated" @click="statusChang(scope.row)">
                  <el-image  style="color: #000" :src="require('../../static/img/homeimg/u174.png')"></el-image>
                </el-button>
                <el-button v-else style="background-color: #e6f1fc;" @click="statusChang(scope.row)">
                  <el-image :src="require('../../static/img/homeimg/u176.png')"></el-image>
                </el-button>
              </template>
            </el-table-column>
            <el-table-column style="color: rgb(10, 144, 235)" label="主题">
              <template slot-scope="scope">
                <el-button @click="statusChang(scope.row)">
                  <span
                    v-if="!scope.row.stated"
                    style="color: rgb(10, 144, 235)"
                    >{{ scope.row.title }}</span
                  >
                  <span v-else>{{ scope.row.title }}</span>
                </el-button>
              </template>
            </el-table-column>
            <el-table-column prop="time" label="时间" width="300px">
            </el-table-column>
          </el-table>
          <div style="background-color: white;height: 33px;border-bottom: #f0f9eb solid 1px">
            <div style="width: 150px;height: 33px;background-color: #e1dede;float: right;" @click="more">
              <span>更多...</span>
            </div>
          </div>
<!--          </el-menu>-->
        </div>
      </div>
    </div>
  </div>
</template>
<script>
export default {
  data () {
    return {
      label: false,
      isCollapse: true,
      tableData: [
        {
          stated: false,
          title: '请及时处理,张三申请的状态报告！',
          time: '2021-9-7'
        }, {
          stated: false,
          title: '请及时处理,张三申请的状态报告！',
          time: '2021-9-5'
        }, {
          stated: true,
          title: '请及时处理,张三申请的状态报告！',
          time: '2021-9-1'
        }
      ]
    }
  },
  methods: {
    TB () {
      this.isCollapse = !this.isCollapse
    },
    handleOpen (key, keyPath) {
      console.log(key, keyPath)
    },
    handleClose (key, keyPath) {
      console.log(key, keyPath)
    },
    more () {
      console.log(1111)
    },
    statusChang (row) {
      row.stated = true
    },
    getPageInfo (workItemOid) {
      this.$router.push({
        name: 'Workitem',
        query: {
          workItemOid: workItemOid
        }
      })
    }
  }
}
</script>
<style scoped >
header {
  display: flex;
  align-items: center;
  /*margin: 0 0 20px 10px;*/
  height: 40px;
  background: linear-gradient(to right, rgb(48, 129, 220), rgb(25, 187, 107));
  color: #fff;
}
.tableHead >>> .tableHead {
  border-right: solid 1px;
}
header > span {
  margin-left: 15px;
  margin-right: 10px;
}
.layout-content {
  padding-top: 10px;
  background-color: rgb(230, 241, 252);
  height: 100vh;
}
.body {
  background-color: #fff;
  height: 92vh;
}
.el-table >>> .cell {
  text-align: center;
}
.pipeTable >>> .el-table__header th {
  border-right: solid 1px;
  border-bottom: solid 1px;
}
.el-table--border >>> td:first-child .cell,
button {
  border: 0;
  cursor: pointer;
  background-color: #fff;
}
.ide {
  color: rgb(10, 144, 235);
}
</style>
