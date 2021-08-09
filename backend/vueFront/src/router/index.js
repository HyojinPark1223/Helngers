import Vue from "vue";
import VueRouter from "vue-router";
import Login from '../views/Login';
import Register from '../views/Register';
import Profile from '../views/Profile';
import NotFound from '../views/NotFound';
import Unauthorized from '../views/Unauthorized';

import Role from '../models/role';
import Store from '../store';

Vue.use(VueRouter);

const routes = [
    //public pages
    {
        path: '/',
        name: 'login',
        component: Login
    },
    {
        path: '/login',
        component: Login
    },
    {
        path: '/register',
        component: Register
    },
    //User and admin
    {
        path: '/profile',
        component: Profile,
        meta: { roles: [Role.ADMIN, Role.USER] }
    },
    //Only admin
    {
        path: '/home',
        name: 'home',
        // route level code-splitting
        // this generates a separate chunk (about.[hash].js) for this route
        // which is lazy-loaded when the route is visited.
        component: () => import("../views/Home.vue"),
        meta: { roles: [Role.ADMIN] }
    },
    //public pages
    {
        path: '/404',
        component: NotFound
    },
    {
        path: '/401',
        component: Unauthorized
    },
    //Otherwise redirect to not found page: unknown pages.
    {
        path: '*',
        redirect: '/404',
    }
];

const router = new VueRouter({
  mode: "history",
  base: process.env.BASE_URL,
  routes
});

router.beforeEach((to, from, next) => {
    const { roles } = to.meta;
    const currentUser = Store.getters['user'];

    if(roles) {
        if(!currentUser) {
            return next({path: '/login'});
        }

        if (roles.length && !roles.includes(currentUser.role)) {
            return next( { path: '/401' });
        }
    }
    next();
})

export default router;
