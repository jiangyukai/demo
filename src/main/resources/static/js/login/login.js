$(document).ready(function(){
    $("#btnLogin").click(function(){
        var username = $("#email").val();
        var password = $("#password").val();
        if(username == null || username == ""){
            layer.msg("用户名不能为空！");
            return;
        }
        if(password == null || password == ""){
            layer.msg("密码不能为空！");
            return;
        }
        startLogin(username,password);
    });

    $("#btnRegister").click(function(){
        var username = $("#username").val();
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        if(username == null || username == ""){
            layer.msg("用户名不能为空！");
            return;
        }
        if(password != repassword){
            layer.msg("两次输入密码不一致！");
            return;
        }
        if(password == null || password == "" || repassword == null || repassword == ""){
            layer.msg("密码不能为空！");
            return;
        }
        registerNow(username,password);
    });


});

function startLogin(username,password){
    $.ajax({
        type: "post",
        url: "/login/startLogin",    //向后端请求数据的url
        data: {
            "username":username,
            "password":password,
        },
        success: function (data) {
            if(data.success){
                layer.alert(data.msg);
            }
        }
    });
}
function registerNow(username,password){
    layer.msg("注册开始！用户名"+username+"密码"+password);
}