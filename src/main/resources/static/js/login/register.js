$(document).ready(function(){

    $("#btnRegister").click(function(){
        var username = $("#username").val();
        var password = $("#password").val();
        var repassword = $("#repassword").val();
        var email = $("#email").val();
        if(username == null || username == ""){
            layer.msg("用户名不能为空！");
            return;
        }
        if(email == null || email == ""){
            layer.msg("邮箱不能为空！");
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

function registerNow(username,password){
    $.ajax({
        type: "post",
        url: "/user/add",    //向后端请求数据的url
        data: {
            username:$("#username").val(),
            email:$("#email").val(),
            password:$("#password").val(),
        },
        success: function (data) {
            if(data==1){
                layer.alert("注册成功！")
            }else if(data==0){
                layer.alert("此邮箱已经注册，注册失败！")
            }
        }
    });
}

function gotoLogin(){
    window.location.href="/login/userLogin";

}