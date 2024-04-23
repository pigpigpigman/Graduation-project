import Vue from 'vue';
//配置路由
import VueRouter from 'vue-router'
Vue.use(VueRouter);
//1.创建组件
import Index from '@/views/index'
import Home from '@/views/home'
import Login from '@/views/login'
import NotFound from '@/views/404'
import UpdatePassword from '@/views/update-password'
import pay from '@/views/pay'
import register from '@/views/register'
import center from '@/views/center'
    import news from '@/views/modules/news/list'
    import geshouxinxi from '@/views/modules/geshouxinxi/list'
    import discussyinlezhuanji from '@/views/modules/discussyinlezhuanji/list'
    import yinlezhuanji from '@/views/modules/yinlezhuanji/list'
    import niandubangdan from '@/views/modules/niandubangdan/list'
    import yinlebangdan from '@/views/modules/yinlebangdan/list'
    import discusslepingxinxi from '@/views/modules/discusslepingxinxi/list'
    import discussgequxinxi from '@/views/modules/discussgequxinxi/list'
    import discussyinlebangdan from '@/views/modules/discussyinlebangdan/list'
    import discussyinlemv from '@/views/modules/discussyinlemv/list'
    import yonghu from '@/views/modules/yonghu/list'
    import chat from '@/views/modules/chat/list'
    import discussgeshouxinxi from '@/views/modules/discussgeshouxinxi/list'
    import discussniandubangdan from '@/views/modules/discussniandubangdan/list'
    import yinlefenlei from '@/views/modules/yinlefenlei/list'
    import lepingxinxi from '@/views/modules/lepingxinxi/list'
    import config from '@/views/modules/config/list'
    import gequxinxi from '@/views/modules/gequxinxi/list'
    import yinlemv from '@/views/modules/yinlemv/list'


//2.配置路由   注意：名字
const routes = [{
    path: '/index',
    name: 'System home page',
    component: Index,
    children: [{
      // 这里不设置值，是把main作为默认页面
      path: '/',
      name: 'System home page',
      component: Home,
      meta: {icon:'', title:'center'}
    }, {
      path: '/updatePassword',
      name: 'Change password',
      component: UpdatePassword,
      meta: {icon:'', title:'updatePassword'}
    }, {
      path: '/pay',
      name: '支付',
      component: pay,
      meta: {icon:'', title:'pay'}
    }, {
      path: '/center',
      name: 'Personal INFO',
      component: center,
      meta: {icon:'', title:'center'}
    }
      ,{
	path: '/news',
        name: 'Music INFO',
        component: news
      }
      ,{
	path: '/geshouxinxi',
        name: 'Singer INFO',
        component: geshouxinxi
      }
      ,{
	path: '/discussyinlezhuanji',
        name: 'Music album review',
        component: discussyinlezhuanji
      }
      ,{
	path: '/yinlezhuanji',
        name: 'Music album',
        component: yinlezhuanji
      }
      ,{
	path: '/niandubangdan',
        name: 'Annual list',
        component: niandubangdan
      }
      ,{
	path: '/yinlebangdan',
        name: 'Music charts',
        component: yinlebangdan
      }
      ,{
	path: '/discusslepingxinxi',
        name: 'Music review INFO review',
        component: discusslepingxinxi
      }
      ,{
	path: '/discussgequxinxi',
        name: 'Song INFO review',
        component: discussgequxinxi
      }
      ,{
	path: '/discussyinlebangdan',
        name: 'Music charts review',
        component: discussyinlebangdan
      }
      ,{
	path: '/discussyinlemv',
        name: 'Music MV review',
        component: discussyinlemv
      }
      ,{
	path: '/yonghu',
        name: ' user ',
        component: yonghu
      }
      ,{
	path: '/chat',
        name: 'Help center',
        component: chat
      }
      ,{
	path: '/discussgeshouxinxi',
        name: 'Singer INFO review',
        component: discussgeshouxinxi
      }
      ,{
	path: '/discussniandubangdan',
        name: 'Annual list review',
        component: discussniandubangdan
      }
      ,{
	path: '/yinlefenlei',
        name: 'Music classification',
        component: yinlefenlei
      }
      ,{
	path: '/lepingxinxi',
        name: 'Music review INFO',
        component: lepingxinxi
      }
      ,{
	path: '/config',
        name: 'Rotation chart MGT',
        component: config
      }
      ,{
	path: '/gequxinxi',
        name: 'Song INFO',
        component: gequxinxi
      }
      ,{
	path: '/yinlemv',
        name: 'Music MV',
        component: yinlemv
      }
    ]
  },
  {
    path: '/login',
    name: 'login',
    component: Login,
    meta: {icon:'', title:'login'}
  },
  {
    path: '/register',
    name: 'register',
    component: register,
    meta: {icon:'', title:'register'}
  },
  {
    path: '/',
    name: 'System home page',
    redirect: '/index'
  }, /*默认跳转路由*/
  {
    path: '*',
    component: NotFound
  }
]
//3.实例化VueRouter  注意：名字
const router = new VueRouter({
  mode: 'hash',
  /*hash模式改为history*/
  routes // （缩写）相当于 routes: routes
})
const originalPush = VueRouter.prototype.push
//edit原型对象中的push方法
VueRouter.prototype.push = function push(location) {
   return originalPush.call(this, location).catch(err => err)
}
export default router;
