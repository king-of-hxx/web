import Vue from "vue";
import Router from "vue-router";
import cookie from "js-cookie";
Vue.use(Router);

const originalPush = Router.prototype.push;
Router.prototype.push = function push(location) {
  return originalPush.call(this, location).catch((err) => err);
};

const routes = [
  {
    path: "/",
    redirect: "Login",
  },
  {
    path: "/login",
    name: "Login",
    component: () => import("@/views/Login"),
  },
  {
    path: "/home",
    name: "Home",
    // redirect: "/home",
    meta: {
      title: "home",
    },
    component: () => import("@/views/Home.vue"),
    children: [
      {
        path: "personManage",
        name: "PersonManage",
        redirect: "/home/personManage/userManage",
        component: () => import("@/views/manageUser/PersonManage.vue"),
        children: [
          {
            path: "/home/personManage/userManage",
            name: "UserManage",
            component: () => import("@/components/manageUser/UserManage.vue"),
          },
          {
            path: "/home/personManage/organizationManage",
            name: "OrganizationManage",
            component: () =>
              import("@/components/manageUser/OrganizationManage.vue"),
          },
          {
            path: "/home/personManage/roleManage",
            name: "RoleManage",
            component: () => import("@/components/manageUser/RoleManage.vue"),
          },
        ],
      },
      {
        path: "panicDetection",
        name: "densityDetection",
        component: () => import("@/components/densityDdetection"),
      },
      {
        path: "behaviorDetection",
        name: "behaviorDetection",
        component: () => import("@/components/behaviorDetection"),
      },
      {
        path: "panicDetection",
        name: "panicDetection",
        component: () => import("@/components/panicDetection"),
      },
    ],
  },
];

const router = new Router({
  mode: "history",
  routes,
});

// router.beforeEach((to, from, next) => {
//   // console.log(to, from);
//   let token = cookie.get("token");
//   let refreshToken = cookie.get("refreshToken");
//   if (to.path == "/login" || (token && refreshToken)) {
//     next();
//   } else {
//     next({
//       path: "/login",
//     });
//   }
// });

export default router;
