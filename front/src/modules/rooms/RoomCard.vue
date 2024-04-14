<template>
  <div class="w-72 mx-auto">
    <img
      v-if="room.imageUrl"
      :src="room.imageUrl"
      class="object-cover w-full h-72 rounded"
    >
    <div
      v-else
      class="object-cover w-full h-72 w-72 rounded border border-gray-300"
    />
    <div class="flex justify-between mt-1">
      <div>{{ room.name }}</div>
      <div class="font-semibold">
        {{ room.pricePerNight / 100 }}$
      </div>
    </div>
  </div>
</template>

<script>
export default {
  name: 'RoomCard',
  props: {
    room: {
      name: String,
      pricePerNight: Number
    }
  }
}
</script>