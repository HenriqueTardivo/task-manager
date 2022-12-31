<template>
  <div class="task-container">
    <section class="to-do">
      <span>A fazer</span>
      <div class="tarefas">
        <Tarefas
          :infoTarefa="{
            prazo: '10/10/2023',
            task: 'Fazer o trabalho',
            categoria: 'Estudos',
            prioridade: 'Urgente',
          }"
        />
      </div>
    </section>
    <section class="done">
      <span>Feito</span>
    </section>
  </div>
</template>

<script>
import Tarefas from "../components/Tarefas.vue";

export default { components: { Tarefas } };
</script>

<style lang="scss" scoped>
.task-container {
  flex: 1;
  display: flex;
  justify-content: center;
  align-items: initial;
  gap: 60px;
  flex-direction: row;
  padding: 50px;
}

section {
  //   border: 2px solid;
  padding: 15px;
  width: 100%;
  height: 500px;
  background-color: #e0e0e0;
  border-radius: 10px;
  display: flex;
  justify-content: flex-start;
  flex-direction: column;

  span {
    text-align: center;
    color: #4780cc;
    font-size: 25px;
    font-weight: bold;
  }

  .tarefas {
    width: 100%;
    margin-top: 20px;
    margin-bottom: 20px;
    display: flex;
    justify-content: center;
  }
}
</style>
