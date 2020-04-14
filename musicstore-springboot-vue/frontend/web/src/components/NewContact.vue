<!--Reference demo link https://blog.csdn.net/csdnear/article/details/79426915-->
<template>
  <div class="row">
    <div class="col-12">
      <div class="form-group">
        <label>Name: {{info.name}}</label>
        <input type="text" class="form-control" v-model="info.name" placeholder="Please input your name">
      </div>
      <div class="form-group">
        <label>Age: {{info.age}}</label>
        <input type="text" class="form-control" v-model="info.age" placeholder="Please input your age">
      </div>
      <div class="form-group">
        <label>Name: {{info.name}}</label>
        <select class="form-control" v-model="info.gender">
          <option value="" disabled>Please select your gender</option>
          <option v-for="item in options" :key="item" :value="item">{{item}}</option>
        </select>
      </div>
    </div>
    <div class="col-lg-12">
      <div class="form-group right">
      <button class="btn btn-primary right" v-on:click="create">Create</button>
      </div>
      <table class="table table-bordered">
        <thead>
          <tr>
            <th>Name</th>
            <th>Age</th>
            <th>Gender</th>
          </tr>
        </thead>
        <tbody>
          <tr v-for="user in tabledata" :key="user.name">
            <th>{{ user.name }}</th>
            <th>{{ user.age }}</th>
            <th>{{ user.gender }}</th>
          </tr>
        </tbody>
      </table>
    </div>
  </div>
</template>

<script>
import Storage from '../store/store'
export default {
  name: 'NewContact',
  data () {
    return {
      info: {
        name: '',
        age: null,
        gender: ''
      },
      options: [
        'Female', 'Male', 'Unknow'
      ],
      tabledata: Storage.fetch()
    }
  },
  methods: {
    create () {
      this.tabledata.push(this.info)
      this.info = {name: '', age: null, gender: ''}
    },
    // 这里删除不能定义为delete，不能被识别
    del (index) {
      this.tabledata.splice(index, 1)
    }
  },
  watch: {
    tabledata: {
      handler (items) {
        Storage.save(items)
      },
      deep: true
    }
  }
}
</script>
<style>
</style>
