const app = Vue.createApp({});
app.component('app', {
  template: `
    <div>
        <h1>Welcome {{ user }}!</h1>
        <h3>This week:</h3>
        <h4 v-if="items.length === 0">No events</h4>
        
        <div>
            <p>Create a new event:</p>
        <input v-model="titleField" placeholder="Title" ref="titleInput">
        <input v-model="timeField" placeholder="Time" ref="timeInput">
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
      titleField: '',
      timeField: '',
    };
  },
  created() {
    this.fetchUser();
  },
  methods: {
    fetchUser() {
      axios.get('/current-user')
        .then((response) => {
          this.user = response.data;
        })
        .catch((error) => {
          alert('User could not be fetched');
          console.error(error.response.data);
        });
    },
  },
  loadEvents() {
    axios.get('/calender')
      .then((response) => (this.items = response.data));
  },
  save() {
    axios.post('/calender', {
      title: this.titleField,
      time: this.timeField,
    })
      .then((response) => {
        this.titleField = '';
        this.timeField = '';
        this.$refs.titleInput.focus();
        this.loadEvents();
      }, (error) => {
        console.log('Could not save event!');
      });
  },
  mounted() {
    this.loadEvents();
  },
});
app.mount('#app');
