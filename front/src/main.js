import { createApp } from 'vue'
import App from './App.vue'
import './index.css'
import { router } from './router'
import { createPinia } from 'pinia'

const pinia = createPinia()
const app = createApp(App)

const components = require.context('.', true, /\.vue$/i);

components.keys().map(key => app.component(components(key).default.name, components(key).default));

app
  .use(router)
  .use(pinia)
  .mount('#app')
