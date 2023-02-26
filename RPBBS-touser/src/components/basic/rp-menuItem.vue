<template>
    <button class="menu-item" :class="{ 'is-active': isActive ? isActive() : null }" @click="action()" :title="title">
        <svg class="remix">
            <use :xlink:href="`${iconUrl}#ri-${icon}`" />
        </svg>
    </button>
</template>
  
<script lang="ts">
import remixiconUrl from 'remixicon/fonts/remixicon.symbol.svg'
import { ref, reactive } from 'vue'

export default {
    props: {
        icon: {
            type: String,
            required: true
        },

        title: {
            type: String,
            required: true
        },

        action: {
            type: Function,
            required: true
        },

        isActive: {
            type: Function,
            default: null
        }
    },
    setup() {
        const iconUrl = ref(remixiconUrl)
        return {
            iconUrl
        }
    }
}
</script>
  
<style lang="less">
.menu-item {
    width: 1.75rem;
    height: 1.75rem;
    color: #0d0d0d;
    border: none;
    background-color: transparent;
    border-radius: .4rem;
    padding: .25rem;
    margin-right: .25rem;

    svg {
        width: 100%;
        height: 100%;
        fill: currentColor;
    }

    &.is-active,
    &:hover {
        color: #fff;
        background-color: #0d0d0d;
    }
}
</style>