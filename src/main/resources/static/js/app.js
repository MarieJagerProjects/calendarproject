const app = Vue.createApp({});
app.component('app', {
  template: `
    <div>
        <h1 v-for="user">Welcome {{user}}!</h1>
        <h3>This week:</h3>
        <h4 v-if="items.length === 0">No events</h4>
        
        <div>
            <p>Create a new event:</p>
        <input v-model="titleField" placeholder="Enter a title" ref="titleInput">
        <input v-model="dateField" placeholder="d/MM/yyyy" ref="dateInput">
        <input v-model="timeField" placeholder="Pick a time" ref="timeInput">
        <button type="button" @click="save()">Save</button>
        </div>
        <table>
            <thead>
                <tr>
                    <th>Time</th>
                    <th>Monday</th>
                    <th>Tuesday</th>
                    <th>Wednesday</th>
                    <th>Thursday</th>
                    <th>Friday</th>
                    <th>Saturday</th>
                    <th>Sunday</th>
                </tr>
            </thead>
            <tbody>
                <tr v-for="events in items">
                    <td>{{event.title}}</td>
                    <td>{{event.time}}</td>
                </tr>
                <tr>
                    <td> {{ titleField }}</td>
                    <td> {{ timeField }}</td>
                </tr>
            </tbody>
        </table>

    </div>
  `,
  data() {
    return {
        user: '',
      items: [],
      dateField: '',
      titleField: '',
      timeField: '',
    };
  },
  methods: {
    loadEvents() {
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
          this.loadEvents();
        }, (error) => {
          console.log('Could not save event!');
        });
    },
  },
  mounted() {
    this.loadEvents();
  },
});
app.mount('#app');
