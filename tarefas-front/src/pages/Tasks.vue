<template>
  <div class="task-container">
    <section class="to-do">
      <span>A fazer</span>
      <div class="tarefas" v-for="tarefa in pendentes">
        <Tarefas
          :infoTarefa="{
            id: tarefa.id,
            prazo: tarefa.dataDeEntrega,
            task: tarefa.task,
            categoria: tarefa.categoria,
            prioridade: tarefa.prioridade,
            realizada: tarefa.realizada,
          }"
          @clicked="handle"
        />
      </div>
    </section>
    <section class="done">
      <span>Feito</span>
      <div class="tarefas" v-for="tarefa in realizadas">
        <Tarefas
          :infoTarefa="{
            id: tarefa.id,
            prazo: tarefa.dataDeEntrega,
            task: tarefa.task,
            categoria: tarefa.categoria,
            prioridade: tarefa.prioridade,
            realizada: tarefa.realizada,
          }"
          @clicked="handle"
        />
      </div>
    </section>
  </div>
</template>

<script>
import Tarefas from "../components/Tarefas.vue";
import axios from "axios";

export default {
  data() {
    return {
      pendentes: null,
      realizadas: null,
      refresh: true,
    };
  },
  components: {
    Tarefas,
  },
  mounted() {
    this.buscaDados();
  },
  watch: {
    refresh() {
      this.buscaDados();
    },
  },
  methods: {
    buscaDados() {
      axios.get("http://localhost:8080/tarefa").then((response) => {
        const result = response.data.reduce(
          (acc, curr) => {
            curr.realizada
              ? acc.realizadas.push(curr)
              : acc.pendentes.push(curr);

            return acc;
          },
          {
            pendentes: [],
            realizadas: [],
          }
        );

        this.pendentes = result.pendentes;
        this.realizadas = result.realizadas;
      });
    },
    handle({ operacao, id }) {
      switch (operacao) {
        case "deletar":
          axios
            .delete("http://localhost:8080/tarefa/" + id)
            .then(() => (this.refresh = !this.refresh));

        case "realizar":
          axios
            .patch("http://localhost:8080/tarefa/" + id)
            .then(() => (this.refresh = !this.refresh));

        case "undoRealizar":
          axios
            .patch("http://localhost:8080/tarefa/" + id)
            .then(() => (this.refresh = !this.refresh));
      }
    },
  },
};
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
  height: 600px;
  background-color: #e0e0e0;
  border-radius: 10px;
  display: flex;
  justify-content: flex-start;
  flex-direction: column;
  overflow-y: scroll;

  span {
    text-align: center;
    color: #4780cc;
    font-size: 25px;
    font-weight: bold;
  }

  .tarefas {
    display: flex;
    justify-content: center;
    width: 100%;
    margin-top: 10px;
  }
}
</style>
