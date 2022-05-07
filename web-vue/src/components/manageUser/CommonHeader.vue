<template>
  <div>
    <header>
      <slot></slot>
      <i class="el-icon-search"></i>
    </header>
  </div>
</template>
<style lang="scss" scoped>
header {
  display: flex;
  justify-content: space-between;
  align-items: center;
  height: 50px;
  line-height: 50px;
  padding-left: 20px;
  border-bottom: 1px solid gray;
  i {
    font-size: 1.5rem;
    cursor: pointer;
  }
}
</style>