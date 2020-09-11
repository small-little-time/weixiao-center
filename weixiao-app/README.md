# weixiao-app

> A Vue.js project

## Build Setup

``` bash
# install dependencies
npm install

# serve with hot reload at localhost:8080
npm run dev

# build for production with minification
npm run build

# build for production and view the bundle analyzer report
npm run build --report
```

For a detailed explanation on how things work, check out the [guide](http://vuejs-templates.github.io/webpack/) and [docs for vue-loader](http://vuejs.github.io/vue-loader).

##解决store刷新内容清空
```App.vue添加：
created () {
    // 在页面加载时读取sessionStorage
    if (sessionStorage.getItem('store')) {
      this.$store.replaceState(Object.assign({}, this.$store.state, JSON.parse(sessionStorage.getItem('store'))))
    }
    // 在页面刷新时将store保存到sessionStorage里
    window.addEventListener('beforeunload', () => {
      sessionStorage.setItem('store', JSON.stringify(this.$store.state))
    })
  }
```

##安装vant最新版本 √


##文字超出行显示小点
```
overflow: hidden;
-webkit-line-clamp: 2;
-webkit-box-orient: vertical;
text-overflow: ellipsis;
display: -webkit-box;
```

##存入换行空格显示换行空格
```
content为textarea输入框获取的值
使用字符串替换存入this.content.replace(/\r\n/g, '<br/>').replace(/\n/g, '<br/>').replace(/\s/g, '&nbsp;')
v-html="content"用标签v-html显示
```

##后台管理，将活动、动态内容展示改为v-html

##解决元素scroll条到底部
```
this.$nextTick(() => {
  document.documentElement.scrollTop = this.$refs.container.scrollHeight
})
有时候有效，有时候无效
```

##实现前进刷新，后退缓存
npm i -S vue-navigation
main.js
```
import Navigation from 'vue-navigation'

Vue.use(Navigation, {router})
```
App.vue
```
<template>
  <navigation>
    <router-view></router-view>
  </navigation>
</template>
```

##Object转数组
```
let arr = Object.values(obj)
let arr = Object.keys(obj)
let arr = Object.entries(obj)
```

##netty服务器地址修改
@/store/user.js
@/pages/chat/Index
@/pages/index/content.js

##使用vue-navigation报错
```
npm i vue-router@3.0 -S
```