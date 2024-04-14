<template>
  <div>Test</div>
</template>

<script>
import {RoomsStore} from "@/modules/rooms/RoomsStore";

export default {
  name: 'RoomsView',
  setup () {
    const store = RoomsStore()
    return { store }
  },
  mounted() {
    this.store.loadRooms();
  },
}
</script>