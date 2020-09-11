import Vue from 'vue'
import Router from 'vue-router'

Vue.use(Router)

export default new Router({
  routes: [
    {
      path: '/',
      name: 'Login',
      component: () => import('@/pages/login/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/register',
      name: 'Register',
      component: () => import('@/pages/register/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/index',
      name: 'Index',
      component: () => import('@/pages/index/Index'),
      meta: {
        showTabbar: true
      }
    },
    {
      path: '/addcontent',
      name: 'AddContent',
      component: () => import('@/pages/content/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/addactivity',
      name: 'AddActivity',
      component: () => import('@/pages/activityadd/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/chat',
      name: 'Chat',
      component: () => import('@/pages/chat/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/chatlist',
      name: 'ChatList',
      component: () => import('@/pages/chatlist/Index'),
      meta: {
        showTabbar: true
      }
    },
    {
      path: '/home',
      name: 'Home',
      component: () => import('@/pages/home/Index'),
      meta: {
        showTabbar: true
      }
    },
    {
      path: '/activity',
      name: 'Activity',
      component: () => import('@/pages/activity/Index'),
      meta: {
        showTabbar: true
      }
    },
    {
      path: '/setting',
      name: 'Setting',
      component: () => import('@/pages/setting/Index'),
      meta: {
        showTabbar: true
      }
    },
    {
      path: '/info',
      name: 'Info',
      component: () => import('@/pages/info/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/myinfo',
      name: 'MyInfo',
      component: () => import('@/pages/myinfo/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/mysetting',
      name: 'MySetting',
      component: () => import('@/pages/mysetting/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/mycollect',
      name: 'MyCollect',
      component: () => import('@/pages/mycollect/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/mycontent',
      name: 'MyContent',
      component: () => import('@/pages/mycontent/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/myactivity',
      name: 'MyActivity',
      component: () => import('@/pages/myactivity/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/mypublish',
      name: 'MyPublish',
      component: () => import('@/pages/myactivity/MyPublish'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/myparticipation',
      name: 'MyParticipation',
      component: () => import('@/pages/myactivity/MyParticipation'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/myfollow',
      name: 'MyFollow',
      component: () => import('@/pages/myfollow/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/sign',
      name: 'Sign',
      component: () => import('@/pages/sign/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/signlist',
      name: 'SignList',
      component: () => import('@/pages/signlist/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/report',
      name: 'Report',
      component: () => import('@/pages/Report/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/feedback',
      name: 'Feedback',
      component: () => import('@/pages/feedback/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/contentdetail',
      name: 'ContentDetail',
      component: () => import('@/pages/contentdetail/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/activitydetail',
      name: 'ActivityDetail',
      component: () => import('@/pages/activitydetail/Index'),
      meta: {
        showTabbar: false
      }
    },
    {
      path: '/success',
      name: 'Success',
      component: () => import('@/components/Example'),
      meta: {
        showTabbar: true
      }
    }
  ]
})
