<template>
    <div class="jumbotron">
        <h1 class="display-4">안녕하세요. {{user.name}}!</h1>
        <p class="lead">
            Spring Boot, MySQL and Vue JS로 만든 간단 페이집니다.
        </p>
        <hr class="my-4"/>
        <p>당신 신분은 <strong>{{user.role}}</strong>
            버튼 누르면 바뀝니다 아마도
        </p>
        <button class="btn btn-primary" @click="changeRole"> Change Role </button>
    </div>
</template>

<script>
    import UserService from '../services/user.service';
    import Role from '../models/role';
    import vuex from 'vuex';

    export default {
        name: 'profile',
        computed: {
            ...vuex.mapGetters(['user']),
        },
        methods: {
            ...vuex.mapActions(['updateUser']),
            changeRole() {
                const newRole = this.user.role === Role.ADMIN ? Role.USER : Role.ADMIN;
                UserService.changeRole(this.user.username, newRole)
                    .then((response) => {
                        const u = this.user;
                        u.role = response.data.role;
                        this.updateUser(u);
                    });
            },
        },
    };
</script>

<style scoped>

</style>
