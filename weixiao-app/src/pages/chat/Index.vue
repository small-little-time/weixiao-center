<template>
  <div>
    <van-sticky>
      <van-nav-bar
        :title="receiverNickname"
        left-arrow
        @click-left="onClickLeft"
      />
    </van-sticky>

    <div style="padding-bottom: 0px;" @click="hideClass = false">
      <div class="chatBox-content" ref="container">
          <div class="chatBox-content-demo" id="chatBox-content-demo">

            <div v-for="(item, index) in chatHistory" :key="index" class="clearfloat">
              <div class="author-name">
                <small class="chat-date">{{item.dateTime}}</small>
              </div>

              <div v-if="item.type === 1" class="left">
                <div class="chat-avatars"><img :src="receiverAvatar" alt="头像"/></div>
                <div class="chat-message">
                  <van-image v-if="item.chatType === 4" :src="item.content" @click="previewImage(item.content)"/>
                  <span v-else v-html="item.content"></span>
                </div>
              </div>

              <div v-else class="right">
                <div class="chat-message">
                  <van-image v-if="item.chatType === 4" :src="item.content" />
                  <span v-else v-html="item.content"></span>
                </div>
                <div class="chat-avatars"><img :src="myAvatar" alt="头像"/></div>
              </div>
            </div>

              <!-- <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="right">
                      <div class="chat-message">嗯，适合做壁纸</div>
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                  </div>
              </div>
              <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="left">
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                      <div class="chat-message">
                          给你看张图
                      </div>
                  </div>
              </div>

              <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="left">
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                      <div class="chat-message">
                          给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图
                      </div>
                  </div>
              </div>
              <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="left">
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                      <div class="chat-message">
                          给你看张图
                      </div>
                  </div>
              </div>
              <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="left">
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                      <div class="chat-message">
                          给你看张图
                      </div>
                  </div>
              </div>
              <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="left">
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                      <div class="chat-message">
                          给你看张图
                      </div>
                  </div>
              </div>
              <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="left">
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                      <div class="chat-message">
                          给你看张图
                      </div>
                  </div>
              </div>

              <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="left">
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                      <div class="chat-message">
                          <van-image src="https://img.yzcdn.cn/vant/cat.jpeg" alt=""/>
                      </div>
                  </div>
              </div>

              <div class="clearfloat">
                  <div class="author-name">
                      <small class="chat-date">2017-12-02 14:26:58</small>
                  </div>
                  <div class="right">
                      <div class="chat-message">嗯，适合做壁纸</div>
                      <div class="chat-avatars"><img src="https://img.yzcdn.cn/vant/cat.jpeg" alt="头像"/></div>
                  </div>
              </div> -->

              <div style="height: 72px;"></div>

          </div>
      </div>
    </div>

    <div class="bottomInput" :class="{'nav-hide': hideClass }">

      <van-field
        v-model="message"
        rows="1"
        :autosize="inputSize"
        type="textarea"
        right-icon="smile-o"
        placeholder=""
        @focus="scrollFocus"
        @keyup.27="scrollBlur"
      >
        <template #button>
          <van-button type="default" round size="mini" v-show="message === ''">+</van-button>
          <van-button type="info" round size="mini" @click="send" v-show="message !== ''">发送</van-button>
        </template>
      </van-field>
    </div>
  </div>
</template>

<script>
import { ImagePreview } from 'vant'
export default {
  name: 'ChatPage',
  data () {
    return {
      myId: this.$store.getters.id,
      myNickname: this.$store.getters.nickname,
      myAvatar: this.$store.getters.faceImgMin,
      show: false,
      message: '',
      receiverNickname: '',
      receiverId: '',
      receiverAvatar: '',
      inputSize: {
        maxHeight: 60,
        minHeight: 20
      },
      hideClass: false,
      chatHistory: [],
      // chatHistory: [{
      //   type: 1,
      //   chatType: 2,
      //   content: '给你看张图',
      //   dateTime: '2017-12-02 14:26:58'
      // }, {
      //   type: 1,
      //   chatType: 2,
      //   content: '给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图给你看张图',
      //   dateTime: '2017-12-02 14:26:58'
      // }, {
      //   type: 1,
      //   chatType: 2,
      //   content: '给你看张图',
      //   dateTime: '2017-12-02 14:26:58'
      // }, {
      //   type: 1,
      //   chatType: 2,
      //   content: '给你看张图',
      //   dateTime: '2017-12-02 14:26:58'
      // }, {
      //   type: 1,
      //   chatType: 2,
      //   content: '给你看张图',
      //   dateTime: '2017-12-02 14:26:58'
      // }, {
      //   type: 1,
      //   chatType: 2,
      //   content: '给你看张图',
      //   dateTime: '2017-12-02 14:26:58'
      // }, {
      //   type: 1,
      //   chatType: 4,
      //   content: 'https://img.yzcdn.cn/vant/cat.jpeg',
      //   dateTime: '2017-12-02 14:26:58'
      // }, {
      //   type: 2,
      //   chatType: 2,
      //   content: '嗯，适合做壁纸',
      //   dateTime: '2017-12-02 14:26:58'
      // }],
      path: 'ws://locahost:8088/ws',
      socket: '',
      receiverContent: [],
      sendTime: '',
      chatType: {
        connect: 1,
        word: 2,
        emoji: 3,
        img: 4,
        video: 5,
        singed: 6,
        keepalive: 7
      },
      index: -1
    }
  },
  updated () {
    this.$nextTick(function () {
      if (this.$refs.container.scrollHeight) {
        this.$refs.container.scrollTop = this.$refs.container.scrollHeight
      }
    })
  },
  methods: {
    send () {
      this.sendTime = new Date(+new Date() + 8 * 3600 * 1000).toISOString().replace(/T/g, ' ').replace(/\.[\d]{3}Z/, '')
      const content = this.message.replace(/\r\n/g, '<br/>').replace(/\n/g, '<br/>').replace(/\s/g, '&nbsp;')
      this.message = ''
      const chatMessage = {
        type: 2,
        chatType: 1,
        content: content,
        dateTime: this.sendTime
      }
      this.setHistory(chatMessage)
      this.hideClass = false
      this.scrollToBottom()
      const dataContent = this.getDataContent(content, this.chatType.word)
      this.websocketsend(dataContent)
    },
    setHistory (chatMessage) {
      // 处理聊天消息
      if (this.chatHistory === '' || this.chatHistory === null || this.chatHistory === undefined) {
        const history = [{
          type: chatMessage.type,
          chatType: chatMessage.chatType,
          content: chatMessage.content,
          dateTime: chatMessage.dateTime
        }]
        this.chatHistory = history
        localStorage.setItem(this.myId + '-' + this.receiverId, JSON.stringify(this.chatHistory))
      } else {
        const item = {
          type: chatMessage.type,
          chatType: chatMessage.chatType,
          content: chatMessage.content,
          dateTime: chatMessage.dateTime
        }
        this.chatHistory.push(item)
        localStorage.setItem(this.myId + '-' + this.receiverId, JSON.stringify(this.chatHistory))
      }

      // 处理聊天列表
      const dataobj = JSON.parse(localStorage.getItem(this.myId + '-chatList'))
      if (dataobj === '' || dataobj === null || dataobj === undefined) {
        const data = [{
          receiverId: this.receiverId,
          avatar: this.receiverAvatar,
          nickname: this.receiverNickname,
          lastMessage: chatMessage.content,
          time: this.sendTime,
          state: 0
        }]
        localStorage.setItem(this.myId + '-chatList', JSON.stringify(data))
      } else {
        const data = {
          receiverId: this.receiverId,
          avatar: this.receiverAvatar,
          nickname: this.receiverNickname,
          lastMessage: chatMessage.content,
          time: this.sendTime,
          state: 0
        }
        dataobj.map((item, ind) => {
          if (item.receiverId === this.receiverId) {
            this.index = ind
            item.lastMessage = chatMessage.content
            item.time = chatMessage.dateTime
          }
        })
        if (this.index === -1) {
          dataobj.push(data)
        }
        localStorage.setItem(this.myId + '-chatList', JSON.stringify(dataobj))
      }
    },
    setMessage (chatMessage) {
      // 处理聊天消息
      if (this.chatHistory === '' || this.chatHistory === null || this.chatHistory === undefined) {
        const history = [{
          type: 1,
          chatType: chatMessage.action,
          content: chatMessage.chatInfo.message,
          dateTime: chatMessage.extend
        }]
        this.chatHistory = history
        localStorage.setItem(this.myId + '-' + this.receiverId, JSON.stringify(this.chatHistory))
      } else {
        const item = {
          type: 1,
          chatType: chatMessage.action,
          content: chatMessage.chatInfo.message,
          dateTime: chatMessage.extend
        }
        this.chatHistory.push(item)
        localStorage.setItem(this.myId + '-' + this.receiverId, JSON.stringify(this.chatHistory))
      }

      // 处理聊天列表
      const dataobj = JSON.parse(localStorage.getItem(this.myId + '-chatList'))
      if (dataobj === '' || dataobj === null || dataobj === undefined || dataobj.length === 0) {
        console.log('null')
        console.log(dataobj)
        const data = [{
          receiverId: chatMessage.chatInfo.senderId,
          avatar: chatMessage.chatInfo.senderAvatar,
          nickname: chatMessage.chatInfo.senderNickname,
          lastMessage: chatMessage.chatInfo.message,
          time: chatMessage.extend,
          state: 0
        }]
        localStorage.setItem(this.myId + '-chatList', JSON.stringify(data))
      } else {
        console.log('notNull')
        console.log(dataobj)
        const data = {
          receiverId: chatMessage.chatInfo.senderId,
          avatar: chatMessage.chatInfo.senderAvatar,
          nickname: chatMessage.chatInfo.senderNickname,
          lastMessage: chatMessage.chatInfo.message,
          time: chatMessage.extend,
          state: 0
        }
        dataobj.map((item, ind) => {
          if (item.receiverId === chatMessage.chatInfo.senderId) {
            this.index = ind
            item.lastMessage = chatMessage.chatInfo.message
            item.time = chatMessage.extend
          }
        })
        if (this.index === -1) {
          console.log('push')
          dataobj.push(data)
        }
        localStorage.setItem(this.myId + '-chatList', JSON.stringify(dataobj))
      }
    },
    onClickLeft () {
      this.$router.go(-1)
    },
    scrollFocus (e) {
      this.scrollToBottom()
      this.hideClass = true
    },
    scrollBlur (e) {
      this.hideClass = false
    },
    getReceiverInfo () {
      this.receiverId = this.$route.params.receiverId
      this.receiverNickname = this.$route.params.nickname
      this.receiverAvatar = this.$route.params.avatar
      this.chatHistory = JSON.parse(localStorage.getItem(this.myId + '-' + this.receiverId))
    },
    scrollToBottom () {
      this.$nextTick(() => {
        if (this.$refs.container.scrollHeight) {
          document.documentElement.scrollTop = this.$refs.container.scrollHeight
        }
      })
    },
    previewImage (image) {
      ImagePreview({
        images: [
          image
        ],
        closeable: true
      })
    },
    initWebSocket () {
      this.socket = this.$store.getters.websocket
      // this.socket = JSON.parse(sessionStorage.getItem('socket'))
      console.log(this.socket)
      if (this.socket === null || this.socket === undefined || this.socket === '{}') {
        console.log('init')
        this.socket = new WebSocket(this.path)
      }
      // this.socket.onmessage = this.websocketonmessage
      this.socket.onopen = this.websocketonopen
      this.socket.onerror = this.websocketonerror
      this.socket.onclose = this.websocketclose
    },
    websocketonopen () {
      console.log('socket连接成功')
      // console.log(this.socket)
      const dataContent = this.getDataContent('', this.chatType.connect)
      this.websocketsend(dataContent)
    },
    websocketonerror () {
      this.initWebSocket()
    },
    websocketonmessage (e) {
      console.log('收到消息')
      console.log(e.data)
      const data = JSON.parse(e.data)
      this.setMessage(data)
      setTimeout(() => {
        this.bus.$emit('chatMessage')
      }, 100)
      this.scrollToBottom()
    },
    websocketsend (Data) {
      this.socket.send(JSON.stringify(Data))
    },
    websocketclose (e) {
      console.log('断开连接', e)
    },
    getDataContent (message, type) {
      const chatInfo = {
        senderId: this.myId,
        senderAvatar: this.myAvatar,
        senderNickname: this.myNickname,
        receiverId: this.receiverId,
        message: message,
        msgId: 0
      }
      const dataContent = {
        action: type,
        chatInfo: chatInfo,
        extend: this.sendTime
      }
      return dataContent
    },
    getHistoryListen () {
      this.bus.$on('chatHistory', () => {
        this.chatHistory = JSON.parse(localStorage.getItem(this.myId + '-' + this.receiverId))
      })
    }
  },
  mounted: function () {
    this.getReceiverInfo()
    this.scrollToBottom()
    this.initWebSocket()
    this.getHistoryListen()
  }
}
</script>

<style scoped>
.bottomInput {
  position: fixed;
  bottom: 0;
  width: 100%;
  overflow:visible;
}
.van-button--mini {
  min-width: 40px;
}
.nav-hide {
}
</style>

<style scoped>
.chatBox-content{
    width: 100%;
}
.chatBox-content-demo{
    width: 100%;
    overflow-y: scroll;
    padding-bottom: 44px;
}
.clearfloat:after{
    display:block;
    clear:both;
    content:"";
    visibility:hidden;
    height:0
}
.clearfloat{
    zoom:1;
    margin: 10px 10px;
}
.clearfloat .right{
    float: right;
}
.author-name{
    text-align: center;
    margin: 15px 0 5px 0;
    color: #888;
}

.clearfloat .chat-message{
    max-width: 252px;
    text-align: left;
    padding: 8px 12px;
    border-radius: 6px;
    word-wrap:break-word;
    display: inline-block;
    position: relative;
}

.clearfloat .left .chat-message{
    background: #D9D9D9;
    min-height: 24px;
}
.clearfloat .left .chat-message:before{
    position: absolute;
    content: "";
    top: 8px;
    left: -6px;
    border-top: 10px solid transparent;
    border-bottom: 10px solid transparent;
    border-right: 10px solid #D9D9D9;
}

.clearfloat .right{
    text-align: right;
}
.clearfloat .right .chat-message{
    background: #8c85e6;
    color: #fff;
    text-align: left;
    min-height: 24px;
}
.clearfloat .right .chat-message:before{
    position: absolute;
    content: "";
    top: 8px;
    right: -6px;
    border-top: 10px solid transparent;
    border-bottom: 10px solid transparent;
    border-left: 10px solid #8c85e6;
}

.clearfloat .chat-avatars{
    display: inline-block;
    width: 30px;
    height: 30px;
    border-radius: 50%;
    background: #eee;
    vertical-align: top;
    overflow: hidden;
}
.clearfloat .chat-avatars>img{
    width: 30px;
    height: 30px;
}
.clearfloat .left .chat-avatars{
    margin-right: 10px;
}
.clearfloat .right .chat-avatars{
    margin-left: 10px;
}
.left {
  text-align: left;
}
</style>
