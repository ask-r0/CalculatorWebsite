<template>
  <div class="calculator">
    <div class="input-field">
      <input v-model="inputField" disabled="true"/>
    </div>
    <div class="keys">
      <div class="button" @click="updateInput('C')">C</div>
      <div class="button" @click="updateInput('ANS')">ANS</div>
      <div class="button" @click="updateInput('DEL')">DEL</div>
      <div class="button" @click="updateInput('+')">+</div>
      <div class="button" @click="updateInput('1')">1</div>
      <div class="button" @click="updateInput('2')">2</div>
      <div class="button" @click="updateInput('3')">3</div>
      <div class="button" @click="updateInput('-')">-</div>
      <div class="button" @click="updateInput('4')">4</div>
      <div class="button" @click="updateInput('5')">5</div>
      <div class="button" @click="updateInput('6')">6</div>
      <div class="button" @click="updateInput('*')">*</div>
      <div class="button" @click="updateInput('7')">7</div>
      <div class="button" @click="updateInput('8')">8</div>
      <div class="button" @click="updateInput('9')">9</div>
      <div class="button" @click="updateInput('/')">/</div>
      <div class="button" @click="updateInput(' ')"> </div>
      <div class="button" @click="updateInput('0')">0</div>
      <div class="button" @click="updateInput('.')">.</div>
      <div class="button" @click="updateInput('=')">=</div>
    </div>
  </div>
  
</template>

<script>
import axios from 'axios';
export default {
  data() {
    return {
      inputField: "",
    };
  },
  methods: {
    calculate(expr) {
      console.log(expr);
      return axios.post("http://localhost:8090/api/calculate", {expression: expr}).then((response) => {
        return response.data.value;
      });
    },
    async updateInput(clicked) {
      // Answer
      if (["ANS", "="].includes(clicked)) {
        let calculation = {
          expression: this.inputField,
          answer: await this.calculate(this.inputField),
        };

        this.$emit("calculation-done", calculation);
        this.inputField = "";
        return;
      }

      // Number
      if (["0", "1", "2", "3", "4", "5", "6", "7", "8", "9"].includes(clicked)) {
        this.inputField += clicked;
        return;
      }

      // Mathematical symbols
      if (["+", "-", "*", "/", "."].includes(clicked)) {
        this.inputField += clicked;
        return;
      }

      // Clear
      if (["C"].includes(clicked)) {
        this.inputField = "";
        return;
      }

      // Delete
      if (["DEL"].includes(clicked)) {
        this.inputField = this.inputField.substring(
          0,
          this.inputField.length - 1
        );
      }
    },
  },
}

</script>

<style scoped>
  * {
  margin: 0px;
}

.calculator {
  margin: 5vh 30vw;
}

.log {
  margin: 0px 20vw;
}

.keys {
  display: grid;
  grid-template-columns: 1fr 1fr 1fr 1fr;
}
.button {
  display: flex;
  justify-content: center;
  align-items: center;
  border: 1px solid black;
  font-size: 32px;
  padding: 20px 0px;
}

.button:hover {
  background-color: gray;
}

input {
  width: 100%;
  height: 64px;
  font-size: 32px;
}
.input-field {
  display: flex;
  justify-content: center;
}

body {
  height: 100vh;
  width: 100vw;
  display: grid;
  grid-template-rows: 1fr 5fr 6fr 1fr;
  font-family: "Franklin Gothic Medium", "Arial Narrow", Arial, sans-serif;
}

div {
  font-size: 32px;
}

</style>