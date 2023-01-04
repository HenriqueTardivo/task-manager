<template>
  <div class="formContainer">
    <form @submit.prevent="submit">
      <div class="center">
        <span> Cadastro de tarefas </span>
      </div>

      <div>
        <label for="task">Tarefa</label>
        <textarea rows="4" name="task" v-model="task"></textarea>
      </div>

      <div>
        <label for="dataDeEntrega">Data de entrega</label>
        <input type="date" name="dataDeEntrega" v-model="dataDeEntrega" />
      </div>

      <div>
        <label for="categoria">Categoria</label>
        <select name="categoria" v-model="categoria">
          <option value="Trabalho">Trabalho</option>
          <option value="Estudos">Estudos</option>
          <option value="Lazer">Lazer</option>
          <option value="Pessoal">Desenvolvimento pessoal</option>
          <option value="Outros">Outros</option>
        </select>
      </div>

      <div>
        <label>Prioridade</label>
        <div class="radio">
          <div>
            <label for="prioridade1">Baixa</label>
            <input
              type="radio"
              id="prioridade1"
              name="prioridade"
              v-model="prioridade"
              value="Baixa"
              class="baixa"
            />
          </div>

          <div>
            <label for="prioridade2">Média</label>
            <input
              type="radio"
              id="prioridade2"
              name="prioridade"
              v-model="prioridade"
              value="Media"
              class="media"
            />
          </div>

          <div>
            <label for="prioridade3">Alta</label>
            <input
              type="radio"
              id="prioridade3"
              name="prioridade"
              v-model="prioridade"
              value="Alta"
              class="alta"
            />
          </div>

          <div>
            <label for="prioridade4">Urgente</label>
            <input
              type="radio"
              id="prioridade4"
              name="prioridade"
              v-model="prioridade"
              value="Urgente"
              class="urgente"
            />
          </div>
        </div>
      </div>

      <button>Gravar dados</button>
    </form>
  </div>
</template>
<script lang="js">
import axios from 'axios';

export default {
  data() {
    return {
      task: null,
      categoria: null,
      dataDeEntrega: null,
      prioridade: null,
    }
  },
  methods: {
    async submit() {
      await axios.post("http://localhost:8080/tarefa",{
        task: this.task,
        categoria: this.categoria,
        prioridade: this.prioridade,
        dataDeEntrega: this.dataDeEntrega,
        realizada: false
      }).finally(()=> this.$router.push('/'))
    }
  }
};
</script>
<style lang="scss" scoped>
.center {
  text-align: center;
  font-size: x-large;
  font-weight: bold;
}

.formContainer {
  display: flex;
  justify-content: center;
  padding: 50px;

  form {
    border: 1px solid #e0e0e0;
    box-shadow: 2px 2px 2px 2px #ccc;
    padding: 30px;
    border-radius: 10px;
    font-size: large;
    label {
      margin-bottom: 10px;
    }

    div {
      display: flex;
      flex-direction: column;
      margin-bottom: 25px;
    }

    input:not([type="radio"]),
    textarea {
      border: 0;
      border-radius: 5px;
      width: 600px;
      height: 25px;
      padding: 10px;
      box-shadow: 0 0 4px rgba(0, 0, 0, 0.3);
      transition: 0.3s box-shadow;
    }

    select {
      border: 0;
      border-radius: 5px;
      width: 620px;
      height: 45px;
      padding: 10px;
      box-shadow: 0 0 4px rgba(0, 0, 0, 0.3);
      transition: 0.3s box-shadow;
    }

    textarea {
      height: 100px;
    }

    input:not([type="radio"]):hover {
      box-shadow: 0 0 4px rgba(0, 0, 0, 0.5);
    }

    button {
      width: 100%;
      border-radius: 10px;
      border: 0;
      height: 50px;
      background-color: #4780cc;
      color: white;
      font-size: large;
    }

    button:hover {
      background-color: #6ea5ed;
    }
  }

  .radio {
    display: flex;
    height: 45px;
    padding: 0px 40px;

    justify-content: space-around;
    flex-direction: row;
    gap: 15px;

    div {
      display: flex;
      flex-direction: row;
      justify-content: center;
      align-content: center;
      gap: 10px;

      input[type="radio"] {
        border: 0;
        width: 20px;
        height: 20px;
      }

      .baixa {
        accent-color: green;
      }

      .media {
        accent-color: blue;
      }

      .alta {
        accent-color: red;
      }

      .urgente {
        accent-color: purple;
      }
    }
  }
}
</style>
