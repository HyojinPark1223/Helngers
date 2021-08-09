<template>
  <div>
    <bubble-menu
      class="bubble-menu"
      :tippy-options="{ duration: 100 }"
      :editor="editor"
      v-if="editor">
      <button
        @click="editor.chain().focus().toggleBold().run()"
        :class="{ 'is-active': editor.isActive('bold')}">
        Bold
      </button>
      <button
        @click="editor.chain().focus().toggleItalic().run()"
        :class="{ 'is-active': editor.isActive('italic')}">
        Italic
      </button>
      <button
        @click="editor.chain().focus().toggleStrike().run()"
        :class="{ 'is-active': editor.isActive('strike')}">
        Strike
      </button>
    </bubble-menu>
    <div
      class="menubar"
      v-if="editor">
      <button
        @click="editor.chain().focus().toggleBold().run()"
        :class="{ 'is-active': editor.isActive('bold') }">
        <span class="material-icons">
          format_bold
        </span>
      </button>
      <button
        @click="editor.chain().focus().toggleItalic().run()"
        :class="{ 'is-active': editor.isActive('italic') }">
        <span class="material-icons">
          format_italic
        </span>
      </button>
      <button
        @click="editor.chain().focus().toggleStrike().run()"
        :class="{ 'is-active': editor.isActive('strike') }">
        <span class="material-icons">
          strikethrough_s
        </span>
      </button>
      <button
        @click="editor.chain().focus().toggleBulletList().run()"
        :class="{ 'is-active': editor.isActive('bulletList') }">
        <span class="material-icons">
          format_list_bulleted
        </span>
      </button>
      <button
        @click="editor.chain().focus().toggleOrderedList().run()"
        :class="{ 'is-active': editor.isActive('orderedList') }">
        <span class="material-icons">
          format_list_numbered
        </span>
      </button>
      <button @click="editor.chain().focus().setHorizontalRule().run()">
        <span class="material-icons">
          horizontal_rule
        </span>
      </button>
      <button
        @click="editor.chain().focus().undo().run()">
        <span class="material-icons">
          undo
        </span>
      </button>
      <button @click="editor.chain().focus().redo().run()">
        <span class="material-icons">
          redo
        </span>
      </button>
      <button @click="addImage">
        <span class="material-icons">
          image
        </span>
      </button>
      <button
        @click="editor.chain().focus().toggleHeading({ level: 1 }).run()"
        :class="{ 'is-active': editor.isActive('heading', { level: 1 }) }">
        <h3>
          H1
        </h3>
      </button>
      <button
        @click="editor.chain().focus().toggleHeading({ level: 2 }).run()"
        :class="{ 'is-active': editor.isActive('heading', { level: 2 }) }">
        <h3>
          H2
        </h3>
      </button>
      <button
        @click="editor.chain().focus().toggleHeading({ level: 3 }).run()"
        :class="{ 'is-active': editor.isActive('heading', { level: 3 }) }">
        <h3>
          H3
        </h3>
      </button>
    </div>
    <editor-content
      :editor="editor"
      class="content"
      placeholder="search" />
  </div>
</template>

<script>
import { Editor, EditorContent, BubbleMenu  } from '@tiptap/vue-3'
import StarterKit from '@tiptap/starter-kit'
import Image from '@tiptap/extension-image'

export default {
  components: {
    EditorContent,
    BubbleMenu 
  },

  data() {
    return {
      editor: null,
    }
  },
  methods: {
    addImage() {
      const url = window.prompt('URL')

      if (url) {
        this.editor.chain().focus().setImage({ src: url }).run()
      }
    }
  },
  mounted() {
    this.editor = new Editor({
      content: `
      <p>게시물을 작성해주세요!</p>
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      <br />
      `,
      extensions: [
        StarterKit,
        Image,
      ],
    })
  },

  beforeUnmount() {
    this.editor.destroy()
  },
}
</script>

<style lang="scss" scoped>
/* Basic editor styles */
.content {
  background-color: #f5f5f5e8;
}
.ProseMirror {
  > * + * {
    margin-top: 0.75em;
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
    background-color: rgba(#616161, 0.1);
    color: #616161;
  }

  pre {
    background: #0D0D0D;
    color: #FFF;
    font-family: 'JetBrainsMono', monospace;
    padding: 0.75rem 1rem;
    border-radius: 0.5rem;

    code {
      color: inherit;
      padding: 0;
      background: none;
      font-size: 0.8rem;
    }
  }

  img {
    max-width: 100%;
    height: auto;
  }

  blockquote {
    padding-left: 1rem;
    border-left: 2px solid rgba(#0D0D0D, 0.1);
  }

  hr {
    border: none;
    border-top: 2px solid rgba(#0D0D0D, 0.1);
    margin: 2rem 0;
  }
  .is-editor-empty:first-child::before {
    content: attr(data-placeholder);
    float: left;
    color: #333;
    pointer-events: none;
    height: 0;
  }
  .is-empty::before {
    content: attr(data-placeholder);
    float: left;
    column-rule: #333;
    pointer-events: none;
    height: 0;
  }
}
.bubble-menu {
  display: flex;
  background-color: #0D0D0D;
  padding: 0.2rem;
  border-radius: 0.5rem;
  button {
    border: none;
    background: none;
    color: #FFF;
    font-size: 0.85rem;
    font-weight: 500;
    padding: 0 0.2rem;
    opacity: 0.6;

    &:hover,
    &.is-active {
      opacity: 1;
    }
  }
}
.menubar {
  display: flex;
  justify-content: left;
  align-content: center;
  button {
    border: none;
    background-color: #fff;
    span {
      padding-top: 8px;
      height: 43px;
    }
    h3 {
      margin: 0;
      font-size: 23px;
    }
  }
}
</style>