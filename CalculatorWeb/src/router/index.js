import { createRouter, createWebHistory } from "vue-router";
import Calculate from "../views/Calculate.vue";

const routes = [
  {
    path: "/",
    redirect: {name: "Calculate"}
  },
  {
    path: "/calc",
    name: "Calculate",
    component: Calculate
  },
];

const router = createRouter({
  history: createWebHistory(process.env.BASE_URL),
  routes,
});

export default router;
