import { defineStore } from 'pinia'
import {ApiRoutes} from "@/api";

export const RoomsStore = defineStore('rooms', {
  state: () => ({ _rooms: [] }),
  getters: {
    rooms: (state) => state._rooms
  },
  actions: {
    async loadRooms() {
      this._rooms = await (await fetch(ApiRoutes.Rooms)).json();
    },
  },
})