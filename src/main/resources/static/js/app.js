const app = Vue.createApp({});
app.component('app', {
  template: `
    <div>
        <p>Create a new event:</p>
        <input v-model="titleField" placeholder="Enter a title" ref="titleInput">
        <input v-model="dateField" placeholder="dd/MM/yyyy" ref="dateInput">
        <input v-model="timeField" placeholder="hh:mm" ref="timeInput">
        <button type="button" @click="save()">Save</button>
    </div>
  `,
  data() {
    return {
      items: {},
      dateField: '',
      titleField: '',
      timeField: '',
    };
  },
  methods: {
  loadCalender() {
      axios.get('/calender')
        .then((response) => (this.items = response.data));
    },
  save() {
    axios.post('/calender', {
      title: this.titleField,
      date: this.dateField,
      time: this.timeField,
    })
        .then((response) => {
          this.titleField = '';
          this.dateField = '';
          this.timeField = '';
          this.$refs.titleInput.focus();
          this.loadCalender();
        }, (error) => {
          console.log('Could not save event!');
        });
    },
  },
  mounted() {
    this.loadCalender();
  },
});
app.mount('#app');

/* Quellen
https://reactgo.com/vue-get-current-date/
https://vcalendar.io/installation.html#cdn
https://betterprogramming.pub/easily-create-a-form-and-a-dynamic-table-in-vue-js-a5ad3475b71f
 */