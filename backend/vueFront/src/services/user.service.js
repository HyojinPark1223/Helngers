import axios from 'axios';

const API_URL = 'http://localhost:8080/api/user/';

class UserService {

    login(user) {
        //btoa: Basic64 encryption
        const header = {
            authorization: 'Basic ' + btoa(user.username + ':' + user.password)
        };

        return axios.get(API_URL + 'login', {headers: header});
    }

    logOut() {
        return axios.post(API_URL + 'logout', {});
    }

    register(user) {
        return axios.post(API_URL, user);
    }

    changeRole(username, role) {
        return axios.put(API_URL + username + '/change/' + role, {});
    }

}

export default new UserService();
