const app = Vue.createApp({});
app.component('app', {
  template: `
    <div>  
        <div>
            <p>Create a new event:</p>
        <input v-model="titleField" placeholder="Enter a title" ref="titleInput">
        <input v-model="dateField" placeholder="dd/MM/yyyy" ref="dateInput">
        <input v-model="timeField" placeholder="hh:mm" ref="timeInput">
        <button type="button" @click="save()">Save</button>
        </div>
        <h4>This week:</h4>    
        <table class = table>
            <thead>
                <tr>
            <th scope="col"></th>
            <th scope="col">Monday</th>
            <th scope="col">Tuesday</th>
            <th scope="col">Wednesday</th>
            <th scope="col">Thursday</th>
            <th scope="col">Friday</th>
            <th scope="col">Saturday</th>
            <th scope="col">Sunday</th>
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
