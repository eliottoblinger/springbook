import { defineStore } from 'pinia'
import {ApiRoutes} from "@/api";

export const UsersStore = defineStore('users', {
  state: () => ({ _users: [] }),
  getters: {
    users: (state) => state._users
  },
  actions: {
    async loadUsers() {
      this._users = await (await fetch(ApiRoutes.Users)).json();
    },
  },
})