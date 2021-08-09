<template>
    <div class="login-page">
        <div class="card">
            <div class="header-container">
                <i class="fa fa-user"/>
            </div>
            <div v-if="errorMessage"
                 class="alert alert-danger"
                 role="alert">
                {{errorMessage}}
            </div>

            <form name="form" @submit.prevent="handleLogin"
                  novalidate
                  :class="submitted ? 'was-validated' : ''">
                <div class="form-group">
                    <label for="username">Username: </label>
                    <input type="text"
                           v-model="formData.username"
                           class="form-control"
                           name="username"
                           id="username"
                           placeholder="Username"
                           required />
                    <div class="invalid-feedback">
                        A valid username is required.
                    </div>
                </div>

                <div class="form-group">
                    <label for="username">Password: </label>
                    <input type="password"
                           v-model="formData.password"
                           class="form-control"
                           name="password"
                           id="password"
                           placeholder="Password"
                           required />
                    <div class="invalid-feedback">
                        Password is required.
                    </div>
                </div>

                <button
                        class="btn btn-primary btn-block"
                        @click="submitted = true"
                        :disabled="loading">
                    Login
                </button>
            </form>

            <a href="/register" class="card-link">Create New Account!</a>
        </div>
    </div>
</template>

<script>
    import UserService from '../services/user.service';
    import User from '../models/user';
    import vuex from 'vuex';

    export default {
        name: 'login',
        data() {
            return {
                formData: new User('', ''),
                loading: false,
                submitted: false,
                errorMessage: '',
            };
        },
        computed: {
            ...vuex.mapGetters(['user']),
        },
        mounted() {
            if (this.user && this.user.username) {
                this.$router.push('/profile');
            }
        },
        methods: {
            ...vuex.mapActions(['updateUser']),
            handleLogin() {
                if (!this.formData.username || !this.formData.password) {
                    return;
                }
                this.loading = true;
                UserService.login(this.formData).then(
                    response => {
                        //Store pure password for further operations.
                        response.data.password = this.formData.password;
                        this.updateUser(response.data);
                        this.$router.push('/profile');
                    },
                    error => {
                        console.log(error);
                        this.errorMessage = 'Unexpected error occurred : ' + ((error && error.errorMessage) || (error));
                        this.loading = false;
                    },
                );
            },
        },
    };
</script>

<style scoped>
    .card {
        max-width: 350px!important;
        padding: 40px;
        background-color: #f7f7f7;
        margin: 50px auto 25px;
    }
    .header-container {
        text-align: center;
        margin-bottom: 20px;
    }

    .header-container i {
        font-size: 80px;
    }

    .card-link {
        text-align: center;
        margin-top: 10px;
    }
</style>
