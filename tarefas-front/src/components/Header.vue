<template>
  <header>
    <a @click="this.$router.push('/')">
      <div class="info">
        <CheckCircle />
        <span>Task Manager</span>
      </div>
    </a>

    <button @click="this.$router.push('/form')">
      <div class="info">
        <span> Cadastrar tarefa </span>
        <Plus />
      </div>
    </button>
  </header>
</template>

<script>
import CheckCircle from "../assets/check-circle.svg";
import Plus from "../assets/plus.svg";

export default {
  components: {
    CheckCircle,
    Plus,
  },
};
</script>
<style lang="scss" scoped>
header {
  height: 50px;
  padding: 10px 70px;
  display: flex;
  justify-content: space-between;
  background-color: #e0e0e0;
  box-shadow: 4px 3px 3px 2px #ccc;
  color: #4780cc;
  font-weight: bold;
  font-size: large;

  svg {
    width: 60px;
    height: 60px;
  }

  image {
    width: 30px;
    height: 30px;
  }

  button {
    border-radius: 10px;
    border: 0px;
    padding: 10px;
    font-size: large;
    color: white;
    background-color: #4780cc;
    transition: 0.2;

    svg {
      padding-left: 25px;
      height: 25px;
      width: 25px;
    }
  }

  button:hover {
    background-color: #6ea5ed;
  }
}

.info {
  display: flex;
  align-items: center;

  span {
    padding: 5px;
  }
}
</style>
