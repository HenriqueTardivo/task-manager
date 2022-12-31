<template>
  <div class="tarefas container">
    <div class="tarefa">
      <span>{{ infoTarefa.task }}</span>
      <button>
        <Arrow />
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
import Arrow from "../assets/arrow-right.svg";
import PrioridadeIconVue from "./Prioridade-icon.vue";

export default {
  props: {
    infoTarefa: {
      type: Object,
    },
  },
  components: {
    Arrow,
    PrioridadeIconVue,
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
