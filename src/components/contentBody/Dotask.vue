<template>
  <div id="dotaskApp">
    <el-tabs
      v-model="activeTab"
      style="height: 100%"
      type="card"
      @tab-click="handleClick"
    >
      <el-tab-pane label="我的待办" name="team" :lazy="true">
        <el-row
          style="padding-left: 10px; padding-bottom: 5px; margin-left: 10px"
        >
          <el-button @click="reassign" size="small" plain style="float: left">
            <!-- <i
              style="font-size: 16px; color: #1296db"
              class="icon iconfont icon-externallink"
            ></i> -->
            <img src="../../../static/img/homeimg/u36.png" alt="">
            <span style="font-size: 14px; padding-left: 2px">重新分配</span>
          </el-button>

          <el-input
          @keyup.enter.native="doFilter"
            size="medium"
            placeholder="请输入关键字"
            v-model="tableDataName"
            class="input-with-select"
            style="float: right"
          >
            <el-button
              @click="doFilter"
              slot="append"
              icon="el-icon-search"
            ></el-button>
          </el-input>
        </el-row>

        <el-table
          ref="multipleTable"
          :data="tableDataEnd"
          tooltip-effect="dark"
          style="width: 100%"
          highlight-current-column
          border
          @selection-change="handleSelectionChange"
          :header-cell-style="{'height':'40px','border':'1px #95a5a6 solid','padding': ' 0 0','color':'black'}"
        >
          <el-table-column type="selection" width="55"> </el-table-column>
          <el-table-column prop="workName" label="名称" show-overflow-tooltip>
            <template slot-scope="scope">
              <el-button
                type="text"
                @click="getPageInfo(scope.row.workItemOid)"
              >
                {{ scope.row.workName }}
              </el-button>
            </template>
          </el-table-column>
          <el-table-column prop="pboName" label="主题" show-overflow-tooltip>
            <template slot-scope="scope">
              <el-button type="text" @click="getMoreInfo(scope.row.themeOid)">
                {{ scope.row.pboName }}
              </el-button>
            </template>
          </el-table-column>
          <el-table-column prop="workName" label="生产号" show-overflow-tooltip>
          </el-table-column>
          <el-table-column
            prop="workItemReceiveTime"
            label="分配时间"
            show-overflow-tooltip
          >
          </el-table-column>
          <el-table-column
            prop="workRole"
            label="流程启动者"
            show-overflow-tooltip
          >
          </el-table-column>
        </el-table>

        <el-row type="flex" justify="end">
          <el-pagination
            @size-change="handleSizeChange"
            @current-change="handleCurrentChange"
            :current-page="currentPage"
            :page-sizes="[5, 10, 15, 20]"
            :page-size="pageSize"
            layout="total, sizes, prev, pager, next, jumper"
            :total="totalItems"
          >
          </el-pagination>
        </el-row>
      </el-tab-pane>

      <el-tab-pane label="已完成" name="group" :lazy="true"> </el-tab-pane>

      <el-tab-pane label="我发起的" name="role" :lazy="true"> </el-tab-pane>
    </el-tabs>
    <!--    <div class="title">-->
    <!--      <div>我的待办</div>-->
    <!--      <span class="iconfont icon-more" @click="window.open('http://pdm.longcheer.com/Windchill/wtcore/jsp/ext/longcheer/samc/work/showWorkitemPaged.jsp')"></span>-->
    <!--    </div>-->
  </div>
</template>
<script>
// import { mapState } from "vuex";
// import { getMyTaskPresentationPagedInfo } from "@/api/moreInfomation";
// import { gettaskAgentList } from "@/api/todosinfo";
// import {Base64} from 'js-base64'

export default {
  props: {
    // dotasksList: Array,
  },
  data () {
    return {
      activeTab: 'team',
      tableDataName: '', // 搜索姓名
      tableDataEnd: [], // 表格内容列
      currentPage: 1, // 当前2页
      pageSize: 5, // 每页2条数据
      totalItems: 0, // 总数据条数
      filterTableDataEnd: [],
      flag: false,
      multipleSelection: [], // 选中列表
      tableDataBegin: [
        {
          workItemReceiveTime: '2020-10-26;10:27:00',
          workName: 'DBRW模板审核流程',
          pboName: '章节编制分配',
          workRole: '朱朝阳'
        },
        {
          workItemReceiveTime: '2020-10-26;10:27:01',
          workName: 'DBRW模板审核流程',
          pboName: '章节编制分配',
          workRole: '好朝阳'
        },
        {
          workItemReceiveTime: '2020-10-26;10:27:00',
          workName: 'DBRW模板审核流程',
          pboName: '章节编制分配',
          workRole: '李朝阳'
        },
        {
          workItemReceiveTime: '2020-10-26;10:27:00',
          workName: 'DBRW模板审核流程',
          pboName: '章节编制分配',
          workRole: '王朝阳'
        },
        {
          workItemReceiveTime: '2020-10-26;10:27:00',
          workName: 'DBRW模板审核流程',
          pboName: '章节编制分配',
          workRole: '张朝阳'
        },
        {
          workItemReceiveTime: '2020-10-26;10:27:00',
          workName: 'DBRW模板审核流程',
          pboName: '章节编制分配',
          workRole: '朱朝阳'
        }
      ]
    }
  },
  created () {
    // 获取总数据条数
    this.totalItems = this.tableDataBegin.length
    //        总条数        每页条数
    if (this.totalItems > this.pageSize) {
      for (let index = 0; index < this.pageSize; index++) {
        // 表格内容列新增内容
        this.tableDataEnd.push(this.tableDataBegin[index])
      }
    } else {
      this.tableDataEnd = this.tableDataBegin
    }
  },
  methods: {
    // 请求接口数据
    // gettaskAgentList() {
    //   gettaskAgentList(this.currentPage1, this.pageSize).then((response) => {
    //     if (response) {
    //       this.dotasksList = response.data.data;
    //       this.total1 = response.data.total;
    //     }
    //   });
    // },
    // 切换我的待办、已完成、我的发起
    handleClick (tab, event) {
      var that = this
      this.activeTab = tab.name
      console.log('handleClick-------->' + that.activeTab)
      if (tab.name === 'team') {
        this.getAllContainer()
      } else if (tab.name === 'group') {
        this.getAllGroup()
      } else if (tab.name === 'role') {
        this.getAllRole()
      }
    },
    // 名称
    getPageInfo (workItemOid) {
      this.$router.push({
        name: 'Workitem',
        query: {
          workItemOid: workItemOid
        }
      })
    },
    // 主题
    getMoreInfo (oid) {
      this.$router.push({
        name: 'DetailedInfomation',
        query: {
          oid: oid
        }
      })
    },
    // 选中列表
    handleSelectionChange (val) {
      this.multipleSelection = val
      console.log(val, this.multipleSelection)
    },
    // 搜索按钮
    // 前端搜索功能需要区分是否检索,因为对应的字段的索引不同
    // 用两个变量接收currentChangePage函数的参数
    doFilter () {
      // 表格内容列为空
      this.tableDataEnd = []
      // 每次手动将数据置空,因为会出现多次点击搜索情况
      this.filterTableDataEnd = []
      // 获取要搜索的姓名
      let name = this.tableDataName
      if (!name) { // 不存在
        this.filterTableDataEnd = this.tableDataBegin
      } else {
        this.tableDataBegin.forEach((value, index) => {
          if (value.workRole.indexOf(name) >= 0 || value. workItemReceiveTime.indexOf(name) >= 0) {
            this.filterTableDataEnd.push(value)
          }
        })
      }
      // 页面数据改变重新统计数据数量和当前页
      this.currentPage = 1
      this.totalItems = this.filterTableDataEnd.length
      // 渲染表格,根据值
      this.currentChangePage(this.filterTableDataEnd)
      // 页面初始化数据需要判断是否检索过
      this.flag = true
    },
    // 分页组件自带
    handleSizeChange (val) {
      console.log(`每页 ${val} 条`)
      this.pageSize = val
      //                             当前页
      this.handleCurrentChange(this.currentPage)
    },
    // 分页组件自带
    handleCurrentChange (val) {
      console.log(`当前页: ${val}`)
      this.currentPage = val
      // 需要判断是否检索
      if (!this.flag) {
        // tableDataBegin不能写成tableDataEnd，不然在没有进行搜索功能的时候，不能进行分页操作，数据丢失
        this.currentChangePage(this.tableDataBegin)
      } else {
        this.currentChangePage(this.filterTableDataEnd)
      }
    }, // 组件自带监控当前页码
    currentChangePage (list) {
      let from = (this.currentPage - 1) * this.pageSize
      let to = this.currentPage * this.pageSize
      // 表格内容列 为空
      this.tableDataEnd = []
      for (; from < to; from++) {
        if (list[from]) {
          this.tableDataEnd.push(list[from])
        }
      }
    },
    reassign () {
      this.tableDataName = ''
      this.doFilter()
    }
  }
  //   mounted() {
  //    if (!sessionStorage.getItem('Authorization')) {
  //      let token = Base64.encode("lcadmin:lcadmin")
  //      sessionStorage.setItem('Authorization', token);
  //    }
  //     this.gettaskAgentList();
  //   },
  //   // computed: {
  //   //   ...mapState("Body", ["dotasksList"]),
  //   // },
}
</script>
<style scoped lang="less">
#dotaskApp {
  background-color: #ffffff;

  .el-input-group {
    width: 250px;
  }

  .title {
    display: flex;
    justify-content: space-between;
    align-items: center;
    color: #444444;
    height: 54px;
    padding: 0 15px;

    span {
      color: #aaaaaa;

      &:hover {
        cursor: pointer;
      }
    }
  }

  .el-table .cell.el-tooltip {
    white-space: pre-wrap;
  }

  //
  //.el-table .cell {
  //  white-space: pre-line;
  //}
  //.el-table {
  //  table-layout: fixed;
  //  word-wrap: break-word;
  //}
  //
  //div {
  //  word-wrap: break-word;
  //}
  /deep/ .el-table .el-table__cell  {
    padding: 0;
    height: 48px;
}
  .table {
    .header {
      display: flex;
      justify-content: space-around;
      align-items: center;
      height: 54px;
      color: #999999;
      font-size: 14px;

      > div {
        width: 25%;
        text-align: center;
      }

      > div:nth-child(1) {
        width: 10%;
        text-align: center;
      }

      > div:nth-child(3) {
        width: 45%;
        text-align: center;
      }

      > div:nth-child(4) {
        width: 15%;
        text-align: center;
      }
    }

    .content {
      .contentItem {
        display: flex;
        justify-content: space-around;
        align-items: center;
        background-color: #ffffff;
        color: #444444;
        font-size: 13px;

        height: 52px;
        box-shadow: 0px 0px 5px 0px rgba(64, 118, 205, 0.2);
        border-radius: 4px;

        > div {
          width: 25%;
          text-align: center;
        }

        > div:nth-child(1) {
          width: 10%;
          text-align: center;
        }

        > div:nth-child(3) {
          width: 45%;
          text-align: center;
        }

        > div:nth-child(4) {
          width: 15%;
          text-align: center;
        }

        .time {
          div:nth-child(2) {
            color: #aaaaaa;
          }
        }

        .taskName {
          color: #3182dd;
        }

        .assigner {
          display: flex;
          justify-content: center;

          svg {
            width: 22px;
            height: 22px;
          }

          > div {
            display: flex;
            justify-content: center;
            align-items: center;
          }
        }

        .status {
          color: #3182dd;
        }
      }
    }
  }
}
</style>
