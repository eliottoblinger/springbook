<template>
  <div>{{ room.name }}</div>
</template>

<script>
export default {
  name: 'RoomsView',
  props: {
    room: {}
  }
}
</script>