import Vue from 'vue';
import VueRouter from 'vue-router'
import Login from '../views/Login'
import Student from '../views/Student'
import Teacher from '../views/Teacher'

Vue.use(VueRouter);

let routes = [
  {path:'/',component:Login,name:'登录'},
  {path:'/Student',component:Student,name:'学生界面'},
  {path:'/Teacher',component:Teacher,name:'老师界面'}
];

const  concat = (router) => {
  routes = routes.concat(router)
};
const router = new VueRouter({
  routes
});
export default router;

