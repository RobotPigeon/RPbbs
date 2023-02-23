<template>
    <ul class="menu bg-base-100 w-56 p-2 h-a mx-auto rounded-box b-1 float-right bg-base-100">
        <li v-for="(item, index) in props.tablist" :key="index">
            <a :href="item.path">
                <svg xmlns="http://www.w3.org/2000/svg" class="h-5 w-5" fill="none" viewBox="0 0 24 24"
                    stroke="currentColor">
                    <path stroke-linecap="round" stroke-linejoin="round" stroke-width="2" :d="item.icon" />
                </svg>
                {{ item.text }}
            </a>
        </li>
    </ul>
</template>

<script lang="ts" setup>

// 属性 
interface Props {
    tablist?: Array<{ icon: string, text: string, path: string }>,

}
const props = withDefaults(defineProps<Props>(), {
    tablist: () => {
        return [
            {
                icon: "M3 12l2-2m0 0l7-7 7 7M5 10v10a1 1 0 001 1h3m10-11l2 2m-2-2v10a1 1 0 01-1 1h-3m-6 0a1 1 0 001-1v-4a1 1 0 011-1h2a1 1 0 011 1v4a1 1 0 001 1m-6 0h6",
                text: "首页",
                path: "/home"
            }
        ]
    }
})

// 方法
// const emit = defineEmits(["update"])

// const update = (e: Event) => {
//     console.log(e);
//     console.log(props.label);
//     emit("update", { name: props.label, value: 22222222222222222222 })
// }
</script>