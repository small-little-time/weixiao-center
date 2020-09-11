<template>
  <div>
    <van-swipe class="iconSwipe" :show-indicators="false">
      <van-swipe-item v-for="(page, index) of pages" :key="index">
        <div class="animated fadeIn">
          <van-grid :column-num="4" :border="false">
            <van-grid-item
              v-for="item of page"
              :key="item.id"
              :text="item.desc"
              icon="add-o"
            >
              <div>
                <van-image round :src="item.url" width="48px" height="48px" style="display: block;"/>
                <span>{{item.desc}}</span>
              </div>
            </van-grid-item>
          </van-grid>
        </div>
      </van-swipe-item>
    </van-swipe>
  </div>
</template>

<script>
export default {
  name: 'HomeIcon',
  data () {
    return {
      iconList: [{
        id: '1',
        url: 'http://zcoder.top:8080/images/home/study.jpg',
        desc: '学习'
      }, {
        id: '2',
        url: 'http://zcoder.top:8080/images/home/sport.jpg',
        desc: '运动'
      }, {
        id: '3',
        url: 'http://zcoder.top:8080/images/home/car.jpg',
        desc: '拼车'
      }, {
        id: '4',
        url: 'http://zcoder.top:8080/images/home/search.jpg',
        desc: '搜用户'
      }, {
        id: '5',
        url: 'http://zcoder.top:8080/images/home/activity.jpg',
        desc: '活动'
      }, {
        id: '6',
        url: 'http://zcoder.top:8080/images/home/discover.jpg',
        desc: '发现'
      }, {
        id: '7',
        url: 'http://zcoder.top:8080/images/home/talking.jpg',
        desc: '话题'
      }, {
        id: '8',
        url: 'http://zcoder.top:8080/images/home/debunk.jpg',
        desc: '吐槽'
      }, {
        id: '9',
        url: 'http://zcoder.top:8080/images/home/class.jpg',
        desc: '班级'
      }, {
        id: '10',
        url: 'http://zcoder.top:8080/images/home/room.jpg',
        desc: '寝室'
      }, {
        id: '11',
        url: 'http://zcoder.top:8080/images/home/more.jpg',
        desc: '更多'
      }]
    }
  },
  computed: {
    pages () {
      const pages = []
      this.iconList.forEach((item, index) => {
        const page = Math.floor(index / 8)
        if (!pages[page]) {
          pages[page] = []
        }
        pages[page].push(item)
        if (index === this.iconList.length - 1) {
          const other = 8 - this.iconList.length % 8
          for (var i = 1; i <= other; i++) {
            const data = {
              id: 0 - i,
              url: '',
              desc: ''
            }
            if (data.id > 0) {
              pages[page].push(data)
            }
          }
        }
      })
      console.log(pages)
      return pages
    }
  }
}
</script>

<style scoped>
.iconSwipe {
  margin: 5px;
}
.van-grid-item >>> .van-grid-item__content {
  padding: 5px;
  background: #F0F8FF;
  height: 79px;
}
.van-grid {
  background: #F0F8FF;
  height: 100%;
}
</style>
