<template>
    <div class="">
        <input id="input" :type="type" v-model="inputvalue" @input="handleChange" :class="{ 'border-red-500': error } "
            class="mt-1 block w-full rounded-md border-gray-300 shadow-sm focus:border-indigo-300 focus:ring focus:ring-indigo-200 focus:ring-opacity-50 input input-bordered">
        <span v-if="error" class="mt-2 text-sm text-red-600">{{ error }}</span>
    </div>
</template>

<script lang="ts" setup>
import { ref } from 'vue'
const inputvalue = ref('')
const error = ref('')

// A function to handle input change event
function handleChange(e: Event) {
    const value = (e.target as HTMLInputElement).value
    inputvalue.value = value
    // If the input is empty and required, set the error message
    if (!value && props.required) {
        error.value = props.errorValue || '此项为必填项'
        return
    }
    // If the input is not empty and does not match the pattern, set the error message
    if (value && props.pattern && !props.pattern.test(value)) {
        error.value = props.errorValue || '请输入有效的格式'
        return
    }
    // Otherwise, clear the error message
    error.value = ''
}


interface Props {
    type: string,
    pattern: RegExp,
    required: Boolean,
    errorValue: string,
}
const props = withDefaults(defineProps<Props>(), {
})
</script>

