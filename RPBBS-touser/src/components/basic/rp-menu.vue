<template>
    <ul class="menu bg-base-100 w-56 p-2 h-a mx-auto rounded-box b-1 float-right">
        <li v-for="(item, index) in props.tablist" :key="index">
            <a>
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
    tablist?: Array<{ icon: string, text: string,rouer:string }>,

}
const props = withDefaults(defineProps<Props>(), {
    tablist: () => {
        return [
            {
                icon: '20',
                text: '主页',
                rouer:'1'
            },
            {
                icon: '20',
                text: '主页',
                rouer:'1'
            },
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