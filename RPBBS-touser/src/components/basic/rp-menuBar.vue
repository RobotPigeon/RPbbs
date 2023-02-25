<template>
    <div>
        <template v-for="(item, index) in items">
            <div class="divider" v-if="item.type === 'divider'" :key="`divider${index}`" />
            <menu-item v-else :key="index" v-bind="item" />
        </template>
    </div>
</template>

<script>
import MenuItem from './rp-menuItem.vue'
import { ref, reactive } from 'vue'
export default {
    components: {
        MenuItem
    },

    props: {
        editor: {
            type: Object,
            required: true
        }
    },
    setup(props) {
        const items = reactive([
            {
                icon: 'bold',
                title: 'Bold',
                action: () => props.editor.chain().focus().toggleBold().run(),
                isActive: () => props.editor.isActive('bold')
            },
            {
                icon: 'strikethrough',
                title: 'Strike',
                action: () => props.editor.chain().focus().toggleStrike().run(),
                isActive: () => props.editor.isActive('strike')
            },
            {
                icon: 'code-view',
                title: 'Code',
                action: () => props.editor.chain().focus().toggleCode().run(),
                isActive: () => props.editor.isActive('code')
            },
            {
                type: 'divider'
            },
            {
                icon: 'paragraph',
                title: 'Paragraph',
                action: () => props.editor.chain().focus().setParagraph().run(),
                isActive: () => props.editor.isActive('paragraph')
            },
            {
                icon: 'code-box-line',
                title: 'Code Block',
                action: () => props.editor.chain().focus().toggleCodeBlock().run(),
                isActive: () => props.editor.isActive('codeBlock')
            },
            {
                type: 'divider'
            },
            {
                icon: 'double-quotes-l',
                title: 'Blockquote',
                action: () => props.editor.chain().focus().toggleBlockquote().run(),
                isActive: () => props.editor.isActive('blockquote')
            },
            {
                icon: 'separator',
                title: 'Horizontal Rule',
                action: () => props.editor.chain().focus().setHorizontalRule().run()
            },
            {
                type: 'divider'
            },
            {
                icon: 'text-wrap',
                title: 'Hard Break',
                action: () => props.editor.chain().focus().setHardBreak().run()
            },
            {
                type: 'divider'
            },
            {
                icon: 'arrow-go-back-line',
                title: 'Undo',
                action: () => props.editor.chain().focus().undo().run()
            },
            {
                icon: 'arrow-go-forward-line',
                title: 'Redo',
                action: () => props.editor.chain().focus().redo().run()
            }
        ])
        return {
            items
        }
    },
}
</script>
  
<style lang="less" scope>

</style>