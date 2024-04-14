<template>
  <div class="h-[500px] bg-black relative">
    <img
      :src="bgPath"
      class="object-cover w-full h-[500px] opacity-75"
    >

    <div class="absolute top-1/2 left-1/2 -translate-y-1/2 -translate-x-1/2 uppercase text-white">
      <h1 class="text-5xl text-center font-bold">
        Find your best place to chill
      </h1>
      <h2 class="text-3xl text-center font-semibold">
        Everywhere in the world
      </h2>
    </div>

    <div />
    <div class="grid xl:grid-cols-4 lg:grid-cols-3 grid-cols-2 gap-6 auto-cols-max mt-6">
      <RoomCard
        v-for="room in store.rooms"
        :key="room.id"
        :room="room"
      />
    </div>
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
  data() {
    return {
      bgPath: require('@/assets/bg-home.jpg')
    }
  },
  mounted() {
    this.store.loadRooms();
  }
}
</script>