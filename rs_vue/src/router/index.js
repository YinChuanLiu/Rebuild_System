import Vue from 'vue';
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Student from '../views/Student'
import Teacher from '../views/Teacher'
import Revise_password from '../views/Revise_password'
import Student_main from '../components/student/Student_main'
import Student_personal from '../components/student/Student_personal'

Vue.use(VueRouter);

let routes = [
  {path:'/',component:Login,name:'登录'},
  {
    path:'/Student',
    component:Student,
    name:'学生界面',
    redirect:'/Student_main',
    children:[
      {path:'/Student_main',component:Student_main,name:'重修课程'},
      {path:'/Student_personal',component:Student_personal,name:'个人信息'},
      {path:'/Revise_password',component:Revise_password,name:'修改密码'}
    ]
  },
  {path:'/Teacher',component:Teacher,name:'老师界面'}
];

// const  concat = (router) => {
//   routes = routes.concat(router)
// };
const router = new VueRouter({
  routes
});

//路由导航守卫控制访问权限
router.beforeEach((to,from,next)=>{
  if (to.path==='/') return next();
  const tokenstr = window.sessionStorage.getItem('token');
  if (!tokenstr) return next('/');
  next()
});

export default router;

