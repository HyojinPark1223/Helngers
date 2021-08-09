<template>
    <div>
        <nav class="navbar navbar-expand navbar-dark bg-dark">
            <a class="navbar-brand" href="https://vuejs.org/">
                <img src="./assets/logo.png" width="30" height="30" class="d-inline-block align-top"/>
                Vue
            </a>
            <div class="navbar-nav mr-auto">
                <li class="nav-item">
                    <a class="nav-link" href="/home">
                        <i class="fa fa-home"/>
                        Home
                    </a>
                </li>
            </div>

            <div class="navbar-nav ml-auto" v-if="!user">
                <li class="nav-item">
                    <a class="nav-link" href="/register">
                        <i class="fa fa-user-plus"/>
                        Sign Up
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" href="/login">
                        <i class="fa fa-sign-in"/>
                        Login
                    </a>
                </li>
            </div>

            <div class="navbar-nav ml-auto" v-if="user">
                <li class="nav-item">
                    <a class="nav-link" href="/profile">
                        <i class="fa fa-user"/>
                        {{user.name}}
                    </a>
                </li>
                <li class="nav-item">
                    <a class="nav-link" @click="logOut">
                        <i class="fa fa-sign-out"/>
                        LogOut
                    </a>
                </li>
            </div>
        </nav>

        <div class="container">
            <router-view />
        </div>
    </div>
</template>

<script>
    import UserService from './services/user.service';
    import vuex from 'vuex';

    export default {
        computed: {
            ...vuex.mapGetters(['user']),
        },
        methods: {
            ...vuex.mapActions(['updateUser']),
            logOut() {
                UserService.logOut().then(() => {
                    this.updateUser(null);
                    this.$router.push('/login');
                });
            },
        },
    }
</script>

