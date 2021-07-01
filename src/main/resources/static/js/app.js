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
    <p></p>
    <table class = table>
        <thead>
            <tr>
            <th>Title</th>
            <th>Date</th>
            <th>Time</th>
            </tr>
            <!-- 
             <th scope="col"></th>
             <th scope="col">Monday</th>
             <th scope="col">Tuesday</th>
             <th scope="col">Wednesday</th>
             <th scope="col">Thursday</th>
             <th scope="col">Friday</th>
             <th scope="col">Saturday</th>
             <th scope="col">Sunday</th>
              </tr> -->
        </thead>
         <tbody>
          <tr v-if="items.length === 0">
            <td colspan="2">No events, yet.</td>
          </tr>
            <tr v-for="events in items">
                <td>{{events.title}}</td>
                <td>{{events.date}}</td>
                <td>{{events.time}}</td>
            </tr>
            <tr>
                <td> {{ titleField }}</td>
                <td> {{ dateField }}</td>
                <td> {{ timeField }}</td>
            </tr>
         </tbody>
    </table>
</div>  
  `,
  data() {
    return {
        items: [],
        titleField: '',
        dateField: '',
        timeField: '',

    };
  },
  methods: {
  loadCalender() {
      axios.get('/events')
        .then(response => (this.items = response.data))
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
  mounted: function() {
    this.loadCalender();
  }
});
app.mount('#app');


/* Quellen
https://reactgo.com/vue-get-current-date/
https://vcalendar.io/installation.html#cdn
https://betterprogramming.pub/easily-create-a-form-and-a-dynamic-table-in-vue-js-a5ad3475b71f
https://v3.vuejs.org/guide/list.html#v-for-with-a-component
 */