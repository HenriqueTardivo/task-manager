<template>
  <div class="tarefas container">
    <div class="tarefa">
      <span>{{ infoTarefa.task }}</span>
      <button>
        <div v-if="infoTarefa.realizada">
          <a @click="handleTarefa(infoTarefa.id, 'undoRealizar')">
            <ArrowLeft />
          </a>

          <a @click="handleTarefa(infoTarefa.id, 'deletar')">
            <TrashSimple />
          </a>
        </div>
        <div v-else>
          <a @click="handleTarefa(infoTarefa.id, 'realizar')">
            <ArrowRight />
          </a>
        </div>
      </button>
    </div>

    <table>
      <tr>
        <th>Prazo</th>
        <th>Categoria</th>
        <th>Prioridade</th>
      </tr>
      <tr>
        <td>{{ infoTarefa.prazo }}</td>
        <td>{{ infoTarefa.categoria }}</td>
        <td>
          <div class="prioridade">
            {{ infoTarefa.prioridade }}
            <PrioridadeIconVue :prioridade="infoTarefa.prioridade" />
          </div>
        </td>
      </tr>
    </table>
  </div>
</template>

<script>
import ArrowRight from "../assets/arrow-right.svg";
import ArrowLeft from "../assets/arrow-left.svg";
import TrashSimple from "../assets/trash-simple.svg";
import PrioridadeIconVue from "./Prioridade-icon.vue";

export default {
  props: {
    infoTarefa: {
      type: Object,
    },
  },
  components: {
    ArrowRight,
    ArrowLeft,
    TrashSimple,
    PrioridadeIconVue,
  },
  methods: {
    handleTarefa(id, action) {
      this.$emit("clicked", { id, action });
    },
  },
};
</script>

<style lang="scss" scoped>
.container {
  display: flex;
  justify-content: space-between;
  width: 80%;
  height: 150px;
  border: 1px solid;
  border-radius: 10px;
  background-color: white;
  box-shadow: 2px 2px 2px 2px #ccc;
  border: 0px;
  flex-direction: column;
  padding: 15px;

  .tarefa {
    display: flex;
    justify-content: space-between;
    margin-bottom: 15px;

    button {
      background-color: white;
      border: 0;

      div {
        display: flex;
        gap: 28px;
      }
    }
  }

  svg {
    width: 30px;
    height: 30px;
    transition: 0.2s;
  }

  svg:hover {
    transform: scale(1.5);
  }

  span {
    font-size: x-large;
  }

  table {
    padding: 5px;
    border-radius: 5px;
    text-align: left;
    border: 1px solid black;

    .prioridade {
      display: flex;
      flex-direction: row;
      gap: 15px;
    }
  }
}
</style>
