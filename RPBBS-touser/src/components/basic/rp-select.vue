<template>
    <div>
        <select v-model="selected" class="select select-bordered w-full max-w-xs" @change="emitValue">
            <option disabled selected>请选择</option>
            <option v-for="(item, index) in options" :key="index" :value="item.value">{{ item.label }}</option>
        </select>
    </div>
</template>

<script setup lang='ts'>

// 定义props类型
interface Props {
    modelValue: string | number
    options: Array<{ value: string | number; label: string }>
}

// 定义props
const props = defineProps<Props>()

// 定义emit事件
const emit = defineEmits(['update:modelValue'])

// 定义响应式变量
let selected = props.modelValue

// 定义方法
const emitValue = () => {
    emit('update:modelValue', selected)
}
</script>