import VueRouter from 'vue-router'

//引入组件
import Index from '../pages'
import Home from '../pages/home/home'
import Login from '../pages/login/login'
import Register from '../pages/register/register'
import Center from '../pages/center/center'
import Storeup from '../pages/storeup/list'
import News from '../pages/news/news-list'
import NewsDetail from '../pages/news/news-detail'
import yonghuList from '../pages/yonghu/list'
import yonghuDetail from '../pages/yonghu/detail'
import yonghuAdd from '../pages/yonghu/add'
import yinlefenleiList from '../pages/yinlefenlei/list'
import yinlefenleiDetail from '../pages/yinlefenlei/detail'
import yinlefenleiAdd from '../pages/yinlefenlei/add'
import geshouxinxiList from '../pages/geshouxinxi/list'
import geshouxinxiDetail from '../pages/geshouxinxi/detail'
import geshouxinxiAdd from '../pages/geshouxinxi/add'
import gequxinxiList from '../pages/gequxinxi/list'
import gequxinxiDetail from '../pages/gequxinxi/detail'
import gequxinxiAdd from '../pages/gequxinxi/add'
import yinlezhuanjiList from '../pages/yinlezhuanji/list'
import yinlezhuanjiDetail from '../pages/yinlezhuanji/detail'
import yinlezhuanjiAdd from '../pages/yinlezhuanji/add'
import yinlemvList from '../pages/yinlemv/list'
import yinlemvDetail from '../pages/yinlemv/detail'
import yinlemvAdd from '../pages/yinlemv/add'
import lepingxinxiList from '../pages/lepingxinxi/list'
import lepingxinxiDetail from '../pages/lepingxinxi/detail'
import lepingxinxiAdd from '../pages/lepingxinxi/add'
import yinlebangdanList from '../pages/yinlebangdan/list'
import yinlebangdanDetail from '../pages/yinlebangdan/detail'
import yinlebangdanAdd from '../pages/yinlebangdan/add'
import niandubangdanList from '../pages/niandubangdan/list'
import niandubangdanDetail from '../pages/niandubangdan/detail'
import niandubangdanAdd from '../pages/niandubangdan/add'


import gequtuijianList from '../pages/gequtuijian/list'
import gequtuijianDetail from '../pages/gequtuijian/detail'
import gequtuijianAdd from '../pages/gequtuijian/add'

const originalPush = VueRouter.prototype.push
VueRouter.prototype.push = function push(location) {
	return originalPush.call(this, location).catch(err => err)
}

//配置路由
export default new VueRouter({
	routes:[
		{
      path: '/',
      redirect: '/index/home'
    },
		{
			path: '/index',
			component: Index,
			children:[
				{
					path: 'home',
					component: Home
				},
				{
					path: 'center',
					component: Center,
				},
				{
					path: 'storeup',
					component: Storeup
				},
				{
					path: 'news',
					component: News
				},
				{
					path: 'newsDetail',
					component: NewsDetail
				},
				{
					path: 'yonghu',
					component: yonghuList
				},
				{
					path: 'yonghuDetail',
					component: yonghuDetail
				},
				{
					path: 'yonghuAdd',
					component: yonghuAdd
				},
				{
					path: 'yinlefenlei',
					component: yinlefenleiList
				},
				{
					path: 'yinlefenleiDetail',
					component: yinlefenleiDetail
				},
				{
					path: 'yinlefenleiAdd',
					component: yinlefenleiAdd
				},
				{
					path: 'geshouxinxi',
					component: geshouxinxiList
				},
				{
					path: 'geshouxinxiDetail',
					component: geshouxinxiDetail
				},
				{
					path: 'geshouxinxiAdd',
					component: geshouxinxiAdd
				},
				{
					path: 'gequxinxi',
					component: gequxinxiList
				},
				{
					path: 'gequxinxiDetail',
					component: gequxinxiDetail
				},
				{
					path: 'gequxinxiAdd',
					component: gequxinxiAdd
				},
				{
					path: 'yinlezhuanji',
					component: yinlezhuanjiList
				},
				{
					path: 'yinlezhuanjiDetail',
					component: yinlezhuanjiDetail
				},
				{
					path: 'yinlezhuanjiAdd',
					component: yinlezhuanjiAdd
				},
				{
					path: 'yinlemv',
					component: yinlemvList
				},
				{
					path: 'yinlemvDetail',
					component: yinlemvDetail
				},
				{
					path: 'yinlemvAdd',
					component: yinlemvAdd
				},
				{
					path: 'lepingxinxi',
					component: lepingxinxiList
				},
				{
					path: 'lepingxinxiDetail',
					component: lepingxinxiDetail
				},
				{
					path: 'lepingxinxiAdd',
					component: lepingxinxiAdd
				},
				{
					path: 'yinlebangdan',
					component: yinlebangdanList
				},
				{
					path: 'yinlebangdanDetail',
					component: yinlebangdanDetail
				},
				{
					path: 'yinlebangdanAdd',
					component: yinlebangdanAdd
				},
				{
					path: 'niandubangdan',
					component: niandubangdanList
				},
				{
					path: 'niandubangdanDetail',
					component: niandubangdanDetail
				},
				{
					path: 'niandubangdanAdd',
					component: niandubangdanAdd
				},




				{
					path: 'gequtuijian',
					component: gequtuijianList
				},
				{
					path: 'gequtuijianDetail',
					component: gequtuijianDetail
				},
				{
					path: 'gequtuijianAdd',
					component: gequtuijianAdd
				},


			]
		},
		{
			path: '/login',
			component: Login
		},
		{
			path: '/register',
			component: Register
		},
	]
})
