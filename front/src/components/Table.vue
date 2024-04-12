<template />

<script>
import {useRoute} from "vue-router";

export default {
  name: 'Navbar',
  computed: { route: () => useRoute() },
}
</script>