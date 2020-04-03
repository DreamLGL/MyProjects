const registerForm = {
    template: `
    <div>
        <h1>注册页</h1><br>
        用&ensp;户&ensp;名: <input type="text" v-model="username"><br>
        密&emsp;&emsp;码: <input type="password" v-model="password"><br>
        确认密码: <input type="password"><br>
        <input type="submit" value="注册">
    </div>
    `,
    data() {
        return {
            username: "",
            password: ""
        };
    }
}