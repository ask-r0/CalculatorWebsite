<template>
  <div class="log">
      <h2>Logg:</h2>
      <ul>
        <li v-for="(c, index) in calculations" :key="index">{{ c.expression  + " = " + c.answer}}</li>
      </ul>
  </div>
</template>

<script>
export default {
  props: {
    calculations: {
      type: Array,
      required: true,
    },
  }
}
</script>
<style scoped>
ul {
  display: inline-block;
    list-style-type: none;
    margin: 0;
    padding: 0;
    overflow: hidden;
}
li {
  margin: 5px;
}
</style>