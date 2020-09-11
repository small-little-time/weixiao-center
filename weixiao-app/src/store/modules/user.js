import { login, logout, getInfo } from '@/api/login'
import { getToken, setToken, removeToken } from '@/utils/auth'
const user = {
  state: {
    id: '',
    token: getToken(),
    username: '',
    truename: '',
    nickname: '',
    sex: '',
    age: '',
    area: '',
    number: '',
    phone: '',
    faceImg: '',
    faceImgMin: '',
    academy: '',
    academyId: '',
    autograph: '',
    hide: '',
    roles: [],
    websocket: {}
  },

  mutations: {
    SET_TOKEN: (state, token) => {
      state.token = token
    },
    SET_WS: (state, ws) => {
      state.websocket = ws
    },
    SET_ROLES: (state, roles) => {
      state.roles = roles
    },
    SET_AVATAR: (state, avatar) => {
      state.faceImgMin = avatar
    },
    SET_INFO: (state, studentInfo) => {
      state.id = studentInfo.id
      state.username = studentInfo.username
      state.truename = studentInfo.truename
      state.nickname = studentInfo.nickname
      state.sex = studentInfo.sex === 1 ? '男' : studentInfo.sex === 2 ? '女' : '未知'
      state.age = studentInfo.age
      state.area = studentInfo.area
      state.number = studentInfo.number
      state.phone = studentInfo.phone
      state.faceImg = studentInfo.faceImg
      state.faceImgMin = studentInfo.faceImgMin
      state.academy = studentInfo.academy
      state.academyId = studentInfo.academyId
      state.autograph = studentInfo.autograph
      state.hide = studentInfo.hide
    },
    SET_HIDE: (state, hide) => {
      state.hide = hide
    }
    // SET_MESSAGE: (state, chatMessage) => {
    //   const receiverId = chatMessage.chatInfo.senderId
    //   const chatHistory = JSON.parse(localStorage.getItem(state.id + '-' + receiverId))
    //   if (chatHistory === '' || chatHistory === null || chatHistory === undefined) {
    //     const history = [{
    //       type: 1,
    //       chatType: chatMessage.action,
    //       content: chatMessage.chatInfo.message,
    //       dateTime: chatMessage.extend
    //     }]
    //     chatHistory = history
    //     localStorage.setItem(state.id + '-' + receiverId, JSON.stringify(chatHistory))
    //   } else {
    //     const item = {
    //       type: 1,
    //       chatType: chatMessage.action,
    //       content: chatMessage.chatInfo.message,
    //       dateTime: chatMessage.extend
    //     }
    //     chatHistory.push(item)
    //     localStorage.setItem(state.id + '-' + receiverId, JSON.stringify(chatHistory))
    //   }

    //   // 处理聊天列表
    //   const dataobj = JSON.parse(localStorage.getItem(state.id + '-chatList'))
    //   if (dataobj === '' || dataobj === null || dataobj === undefined) {
    //     const data = [{
    //       receiverId: chatMessage.chatInfo.senderId,
    //       avatar: chatMessage.chatInfo.senderAvatar,
    //       nickname: chatMessage.chatInfo.nickname,
    //       lastMessage: chatMessage.content,
    //       time: chatMessage.extend,
    //       state: 0
    //     }]
    //     localStorage.setItem(state.id + '-chatList', JSON.stringify(data))
    //   } else {
    //     const data = {
    //       receiverId: chatMessage.chatInfo.senderId,
    //       avatar: chatMessage.chatInfo.senderAvatar,
    //       nickname: chatMessage.chatInfo.nickname,
    //       lastMessage: chatMessage.content,
    //       time: chatMessage.extend,
    //       state: 0
    //     }
    //     const index = -1
    //     dataobj.map((item, ind) => {
    //       if (item.receiverId === chatMessage.chatInfo.senderId) {
    //         index = ind
    //         item.lastMessage = chatMessage.chatInfo.message
    //         item.time = chatMessage.extend
    //       }
    //     })
    //     if (index === -1) {
    //       dataobj.push(data)
    //     }
    //     localStorage.setItem(state.id + '-chatList', JSON.stringify(dataobj))
    //   }
    // }

  },

  actions: {

    SetFace ({ commit }, avatar) {
      commit('SET_AVATAR', avatar)
    },

    SetHide ({ commit }, hide) {
      commit('SET_HIDE', hide)
    },

    // 登录
    Login ({ commit }, userInfo) {
      const username = userInfo.username.trim()
      return new Promise((resolve, reject) => {
        login(username, userInfo.password).then(response => {
          const data = response.data
          const token = data.tokenHead + data.token
          setToken(token)
          commit('SET_TOKEN', token)
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 获取用户信息
    GetInfo ({ commit, state }) {
      return new Promise((resolve, reject) => {
        getInfo(state.token.slice(6)).then(response => {
          const data = response.data
          if (data.roles && data.roles.length > 0) { // 验证返回的roles是否是一个非空数组
            commit('SET_ROLES', data.roles)
          } else {
            // reject('getInfo: roles must be a non-null array !')
            const role = ['common']
            commit('SET_ROLES', role)
          }
          const ws = new WebSocket('ws://localhost:8088/ws')
          ws.onopen = () => {
            console.log('socket连接成功')
            const chatInfo = {
              senderId: data.id,
              senderAvatar: '',
              senderNickname: '',
              receiverId: '',
              message: '',
              msgId: 0
            }
            const dataContent = {
              action: 1,
              chatInfo: chatInfo,
              extend: ''
            }
            ws.send(JSON.stringify(dataContent))
            const heartMessage = {
              action: 7,
              chatInfo: chatInfo,
              extend: '发送心跳'
            }
            setInterval(() => {
              ws.send(JSON.stringify(heartMessage))
            }, 7000)
          }
          commit('SET_WS', ws)
          console.log(data)
          commit('SET_INFO', data)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    GetInfo2 ({ commit, state }) {
      return new Promise((resolve, reject) => {
        getInfo(state.token.slice(6)).then(response => {
          const data = response.data
          if (data.roles && data.roles.length > 0) { // 验证返回的roles是否是一个非空数组
            commit('SET_ROLES', data.roles)
          } else {
            // reject('getInfo: roles must be a non-null array !')
            const role = ['common']
            commit('SET_ROLES', role)
          }
          commit('SET_INFO', data)
          resolve(response)
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 登出
    LogOut ({ commit, state }) {
      return new Promise((resolve, reject) => {
        logout(state.token).then(() => {
          commit('SET_TOKEN', '')
          commit('SET_ROLES', [])
          removeToken()
          resolve()
        }).catch(error => {
          reject(error)
        })
      })
    },

    // 前端 登出
    FedLogOut ({ commit }) {
      return new Promise(resolve => {
        commit('SET_TOKEN', '')
        removeToken()
        resolve()
      })
    }
  }
}

export default user
