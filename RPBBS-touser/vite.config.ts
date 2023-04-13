import { fileURLToPath, URL } from 'node:url'
import presetDaisy from 'unocss-preset-daisy'
import { defineConfig } from 'vite'
import vue from '@vitejs/plugin-vue'
import vueJsx from '@vitejs/plugin-vue-jsx'
import Unocss from 'unocss/vite'
import { presetUno, presetAttributify, presetIcons, transformerDirectives } from 'unocss'


// https://vitejs.dev/config/
export default defineConfig({
  plugins: [vue(), vueJsx(),
  Unocss({
    transformers: [transformerDirectives()],
    presets: [
      presetUno(),
      presetAttributify(),
      presetIcons(),
      presetDaisy()
    ],
  }),

]
  ,
  resolve: {
    alias: {
      '@': fileURLToPath(new URL('./src', import.meta.url))
    }
  },
//解决跨域
  server: {
    proxy: {
      '/api': {
        target: 'http://localhost:8081/',
        changeOrigin: true,
        rewrite: (path:any) => path.replace(/^\/api/, '')
      }
    }
  }
})

