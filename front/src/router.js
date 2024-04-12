import { createMemoryHistory, createRouter } from 'vue-router'
import HomeView from "@/modules/home/HomeView.vue";
import RoomsView from "@/modules/rooms/RoomsView.vue";
import ReservationsView from "@/modules/reservations/ReservationsView.vue";
import UsersView from "@/modules/users/UsersView.vue";

const routes = [
  { path: '/', name: 'home', component: HomeView },
  { path: '/rooms', name: 'rooms', component: RoomsView },
  { path: '/reservations', name: 'reservations', component: ReservationsView },
  { path: '/users', name: 'users', component: UsersView },
]

export const router = createRouter({
  history: createMemoryHistory(),
  routes,
});