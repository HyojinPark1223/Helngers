import axios from 'axios';

const API_URL = 'http://localhost:8080/';

class UserService {

    login(user) {
        console.log(user)
        // const header = {
        //     authorization: 'Basic ' + btoa(user.username + ':' + user.password)
        // };
        // let obj = {user.email, user.password}
        // console.log(obj)
        return axios.post(API_URL + 'login', user);
    }

    // logOut() {
    //     return axios.post(API_URL + 'logout', {});
    // }

    signUp(user) {
      console.log('레지')
      return axios.post(API_URL + 'signup', user);
    }

    changeRole(username, role) {
        return axios.put(API_URL + username + '/change/' + role, {});
    }

}

export default new UserService();
