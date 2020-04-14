<template>
  <div class="hello">
    <router-link to="newcontact"><h1>{{ msg }}</h1></router-link>
    <button class="btn btn-primary">Create Contact</button>
  </div>
</template>

<script>
export default {
  name: 'HelloWorld',
  data () {
    return {
      msg: 'Welcome'
    }
  }
}
</script>

<!-- Add "scoped" attribute to limit CSS to this component only -->
<style scoped>
h1, h2 {
  font-weight: normal;
}
a {
  color: #42b983;
}
</style>
