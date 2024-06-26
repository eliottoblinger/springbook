import { createWebHistory, createRouter } from 'vue-router'
import HomeView from "@/modules/home/HomeView.vue";
import RoomsView from "@/modules/rooms/RoomsView.vue";

const routes = [
  { path: '/', name: 'home', component: HomeView },
  { path: '/room/:id', name: 'room', component: RoomsView },
]

export const router = createRouter({
  history: createWebHistory(),
  routes,
});