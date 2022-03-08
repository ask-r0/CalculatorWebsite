import { createStore } from "vuex";

export default createStore({
  state: {
    feedbackMessages: [],
    flashMessage: ''
  },
  mutations: {
    ADD_FEEDBACK_MESSAGE(state, feedbackMessage) {
      state.feedbackMessages.push(feedbackMessage)
    },
    SET_FLASH_MESSAGE(state, flashMessage) {
      state.flashMessage = flashMessage;
    }
  },
  actions: {
    getFeedbackMessages() {
      return this.state.feedbackMessages;
    },
    addFeedbackMessage({commit}, feedbackMessage) {
      commit('ADD_FEEDBACK_MESSAGE', feedbackMessage);
    },
    setFlashMessage({commit}, flashInfo) {
      commit('SET_FLASH_MESSAGE', flashInfo.message);
      setTimeout(() => {
        commit('SET_FLASH_MESSAGE', '');
      }, flashInfo.timeout);
    }
  },
  modules: {},
});
