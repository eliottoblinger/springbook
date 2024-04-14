<template>
  <div
    v-for="room in store.rooms"
    :key="room.id"
  >
    {{ room }}
  </div>
</template>

<script>
import {RoomsStore} from "@/modules/rooms/RoomsStore";

export default {
  name: 'HomeView',
  setup () {
    const store = RoomsStore()
    return { store }
  },
  mounted() {
    this.store.loadRooms();
  },
}
</script>