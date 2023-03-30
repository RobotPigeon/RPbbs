<template>
    <div>
        <input :type="type" v-model="localValue" @blur="handleChange" @input="handleChange"
            :class="{ 'border-red-500': error }"
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50 input input-bordered">
        <span v-if="error" class="mt-2 text-sm text-red-600">{{ error }}</span>
    </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const localValue = ref('')
const error = ref('')

// A function to handle input change event
function handleChange(e: Event) {
    const value = (e.target as HTMLInputElement).value
    localValue.value = value
    // If the input is empty and required, set the error message
    if (!value && props.required) {
        error.value = '请输入内容'
        return
    }
    // If the input is not empty and does not match the pattern, set the error message
    if (value && props.pattern && !props.pattern.test(value)) {
        error.value = props.errorValue || '请输入有效的格式'
        emit('change', false)
        return
    }
    // Otherwise, clear the error message
    error.value = ''
    emit('change', true)
    emit('update:modelValue', (e.target as HTMLInputElement).value) // Emit an update event to sync with parent data
}

const emit = defineEmits(['change', 'update:modelValue'])

interface Props {
    type: string,
    pattern?: RegExp,
    required: Boolean,
    errorValue: string,
}
const props = withDefaults(defineProps<Props>(), {
})
</script>

