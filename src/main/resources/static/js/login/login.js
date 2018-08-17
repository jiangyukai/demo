$(document).ready(function(){
    $("#btnLogin").click(function(){
        var username = $("#username").val();
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
});

function startLogin(username,password){
    layer.msg("用户名："+username+"&nbsp&nbsp&nbsp&nbsp&nbsp"+"密码："+password);
}
function registerNow(){
    layer.msg("注册！");
}