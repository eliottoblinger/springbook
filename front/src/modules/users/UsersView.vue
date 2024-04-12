<template>
  <div>
    Userssss
    <div
      v-for="user in store.users"
      :key="user.id"
    >
      {{ user.username }}
    </div>
  </div>
</template>

<script>
import {UsersStore} from "@/modules/users/UsersStore";

export default {
  name: 'UsersView',
  setup () {
    const store = UsersStore()
    return { store }
  },
  mounted() {
    this.store.loadUsers();
  },
}
</script>