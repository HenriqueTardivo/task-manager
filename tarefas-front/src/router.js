import { createRouter, createWebHistory } from "vue-router";
import TaskForm from "./pages/TaskForm.vue";
import TasksVue from "./pages/Tasks.vue";
import Error404 from "./pages/Error404.vue";

export default createRouter({
  history: createWebHistory(),
  routes: [
    {
      path: "/",
      component: TasksVue,
    },
    {
      path: "/form",
      component: TaskForm,
    },
    {
      path: "/erro404",
      component: Error404,
    },
  ],
});
