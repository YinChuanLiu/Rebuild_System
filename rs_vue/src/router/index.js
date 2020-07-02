import Vue from 'vue';
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Student from '../views/Student'
import Teacher from '../views/Teacher'
import Director from '../views/Director'
import Manager from '../views/Manager'
import Revise_password1 from '../components/student/Revise_password1'
import Student_main from '../components/student/Student_main'
import Student_personal from '../components/student/Student_personal'
import Revise_password2 from '../components/teacher/Revise_password2'
import Teacher_main from '../components/teacher/Teacher_main'
import Teacher_personal from '../components/teacher/Teacher_personal'
import Revise_password3 from '../components/director/Revise_password3'
import Director_main from '../components/director/Director_main'
import Director_personal from '../components/director/Director_personal'
import Revise_password4 from '../components/manager/Revise_password4'
import Manager_main from '../components/manager/Manager_main'
import Manager_personal from '../components/manager/Manager_personal'

Vue.use(VueRouter);

let routes = [
  {path:'/',component:Login,name:'登录'},
  {
    path:'/Student',
    component:Student,
    name:'学生界面',
    redirect:'/Student_main',
    meta:{requiresAuth:true},
    children:[
      {path:'/Student_main',component:Student_main,name:'重修课程'},
      {path:'/Student_personal',component:Student_personal,name:'个人信息'},
      {path:'/Revise_password1',component:Revise_password1,name:'修改密码1'}
    ]
  },
  {
    path:'/Teacher',
    component:Teacher,
    name:'老师界面',
    meta:{requiresAuth:true},
    redirect:'/Teacher_main',
    children: [
      {path:'/Teacher_main',component:Teacher_main,name:'课程分配'},
      {path:'/Teacher_personal',component:Teacher_personal,name:'个人信息'},
      {path:'/Revise_password2',component:Revise_password2,name:'修改密码2'}
    ]
  },
  {
    path:'/Director',
    component:Director,
    name:'教研室主任',
    redirect:'/Director_main',
    children:[
      {path:'/Director_main',component:Director_main,name:'分配教师'},
      {path:'/Director_personal',component:Director_personal,name:'个人信息'},
      {path:'/Revise_password3',component:Revise_password3,name:'修改密码3'}
    ]
  },
  {
    path:'/Manager',
    component:Manager,
    name:'管理员',
    redirect:'/Manager_main',
    children:[
      {path:'/Manager_main',component:Manager_main,name:'上传文件'},
      {path:'/Manager_personal',component:Manager_personal,name:'个人信息'},
      {path:'/Revise_password4',component:Revise_password4,name:'修改密码4'}
    ]
  }
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

