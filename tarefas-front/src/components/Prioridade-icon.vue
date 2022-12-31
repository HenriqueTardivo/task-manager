<template>
  <div
    v-if="prioridade === 'Baixa'"
    class="bolinha"
    style="background-color: green"
  ></div>
  <div
    v-if="prioridade === 'Media'"
    class="bolinha"
    style="background-color: blue"
  ></div>
  <div
    v-if="prioridade === 'Alta'"
    class="bolinha"
    style="background-color: red"
  ></div>
  <div
    v-if="prioridade === 'Urgente'"
    class="bolinha"
    style="background-color: purple"
  ></div>
</template>

<script lang="js">
export default {
    props:{
        prioridade:{
            type: String
        }
    }
};
</script>

<style lang="scss" scoped>
.bolinha {
  width: 20px;
  height: 20px;
  border-radius: 80px;
}
</style>
