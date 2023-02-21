import { defineConfig, presetAttributify, presetUno, presetIcons } from 'unocss'

export default defineConfig({
    presets: [presetUno(), presetAttributify(), presetIcons({ scale: 1.2, warn: true })],
    shortcuts: [
        ['wh-full', 'w-full h-full'],
        ['f-c-c', 'flex justify-center items-center'],
        ['flex-col', 'flex flex-col'],
        ['text-ellipsis', 'truncate'],
        ['icon-btn', 'text-16 inline-block cursor-pointer select-none opacity-75 transition duration-200 ease-in-out hover:opacity-100 hover:text-primary !outline-none']
    ],
    rules: [
        [/^bc-(.+)$/, ([, color]) => ({ 'border-color': `#${color}` })],
        ['card-shadow', { 'box-shadow': '0 1px 2px -2px #00000029, 0 3px 6px #0000001f, 0 5px 12px 4px #00000017' }],
    ],
    theme: {
        colors: {
            primary: 'hsla(var(--p))',
            'primary-focus': 'hsla(var(--pf))',
            'primary-content': 'hsla(var(--pc))',
            secondary: 'hsla(var(--s))',
            'secondary-focus': 'hsla(var(--sf))',
            'secondary-content': 'hsla(var(--sc))',
            accent: 'hsla(var(--a))',
            'accent-focus': 'hsla(var(--af))',
            'accent-content': 'hsla(var(--ac))',
            neutral: 'hsla(var(--n))',
            'neutral-focus': 'hsla(var(--nf))',
            'neutral-content': 'hsla(var(--nc))',
            'base-100': 'hsla(var(--b1))',
            'base-200': 'hsla(var(--b2))',
            'base-300': 'hsla(var(--b3))',
            'base-content': 'hsla(var(--bc))',
            info: 'hsla(var(--in))',
            'info-content': 'hsla(var(--inc))',
            success: 'hsla(var(--su))',
            'success-content': 'hsla(var(--suc))',
            warning: 'hsla(var(--wa))',
            'warning-content': 'hsla(var(--wac))',
            error: 'hsla(var(--er))',
            'error-content': 'hsla(var(--erc))',
        },
    },
})