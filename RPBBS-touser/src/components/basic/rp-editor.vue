<template>
    <div class="editor input-bordered w-full b-3 bg-base-100" v-if="editor" :style="{ width }">
        <MenuBar class="editor-header" :editor="editor" />
        <editor-content class="editor-content" :editor="editor" />
    </div>
</template>

<script lang="ts">
import { Editor, EditorContent } from '@tiptap/vue-3'
import StarterKit from '@tiptap/starter-kit'
import { defineComponent } from 'vue'
import MenuBar from './rp-menuBar.vue'

export default defineComponent({
    components: {
        EditorContent,
        MenuBar
    },
    props: {
        width: {
            type: String,
            default: '100%'
        }
    },
    emits: ['contentChanged'], // declare the event here
    setup(props, { emit }) {
        const editor = new Editor({
            content: '<p>在此编辑内容 🎉</p>',
            extensions: [
                StarterKit
            ],
            onUpdate() {
                const html = editor.getHTML()
                // trigger the event here with the new content as an argument
                emit('contentChanged', html)
            }
        })
        return {
            editor
        }
    }

})
</script>

<style lang="less" scope>
.editor {
    display: flex;
    flex-direction: column;
    max-height: 26rem;
    background-color: #fff;
    border-radius: .75rem;

    &-header {
        display: flex;
        align-items: center;
        flex: 0 0 auto;
        flex-wrap: wrap;
        padding: .25rem;
        border-bottom: 3px solid;
    }

    &-content {
        padding: .7rem .5rem;
        flex: 1 1 auto;
        overflow-x: hidden;
        overflow-y: auto;
        -webkit-overflow-scrolling: touch;
    }
}


/* 基本编辑器样式 */
.ProseMirror {
    height: 100%;

    &:focus {
        outline: none;
    }

    ul,
    ol {
        padding: 0 1rem;
    }

    h1,
    h2,
    h3,
    h4,
    h5,
    h6 {
        line-height: 1.1;
    }

    code {
        background-color: rgba(#616161, .1);
        color: #616161;
    }

    pre {
        background: #0d0d0d;
        color: #fff;
        font-family: 'JetBrainsMono', monospace;
        padding: .75rem 1rem;
        border-radius: .5rem;

        code {
            color: inherit;
            padding: 0;
            background: none;
            font-size: .8rem;
        }
    }

    mark {
        background-color: #faf594;
    }

    img {
        max-width: 100%;
        height: auto;
    }

    hr {
        margin: 1rem 0;
    }

    blockquote {
        padding-left: 1rem;
        border-left: 2px solid rgba(#0d0d0d, .1);
    }

    hr {
        border: none;
        border-top: 2px solid rgba(#0d0d0d, .1);
        margin: 2rem 0;
    }

    ul[data-type="taskList"] {
        list-style: none;
        padding: 0;

        li {
            display: flex;
            align-items: center;

            >label {
                flex: 0 0 auto;
                margin-right: .5rem;
                user-select: none;
            }

            >div {
                flex: 1 1 auto;
            }
        }
    }
}
</style>