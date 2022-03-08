<template>
<div>
  <Calculator @calculation-done="addCalculation"></Calculator>
  <CalculatorLog :calculations="calculations"></CalculatorLog>
</div>
  
</template>
<script>
import Calculator from '../components/Calculator.vue';
import CalculatorLog from '../components/CalculatorLog.vue';
export default {
  components: {
    Calculator,
    CalculatorLog
  },
  data() {
    return {
      calculations: []
    }
  },
  methods: {
    addCalculation(calculation) {
      this.calculations.push(calculation);
    },
  },
}
</script>