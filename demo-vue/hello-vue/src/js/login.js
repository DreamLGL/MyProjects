const loginForm = {
    template: `
    <div>
        <h1>登录页</h1><br>
        用户名: <input type="text" v-model="username"><br>
        密&emsp;码: <input type="password" v-model="password"><br>
        <input type="submit" value="登录">
    </div>
    `,
    data() {
        return {
            username: "",
            password: ""
        };
    }
}