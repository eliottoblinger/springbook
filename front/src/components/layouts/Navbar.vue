<template>
  <nav>
    <div class="max-w-screen-xl flex flex-wrap items-center justify-start px-24 py-6">
      <RouterLink
        to="/"
        class="flex items-center space-x-3 rtl:space-x-reverse"
      >
        <span class="self-center text-2xl font-semibold whitespace-nowrap text-dark">Spring Book</span>
      </RouterLink>
    </div>
  </nav>
</template>
  
  <script>
  import {useRoute} from "vue-router";

  export default {
    name: 'Navbar',
    computed: { route: () => useRoute() },
  }
  </script>
  