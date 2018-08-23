$(document).ready(function(){

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

function registerNow(username,password){
    layer.msg("注册开始！用户名"+username+"密码"+password);
    $.ajax({
        type: "post",
        url: "/hello/data",    //向后端请求数据的url
        data: {},
        success: function (data) {
            $('button').removeClass("btn-primary").addClass("btn-success").attr('disabled', true);

            viewmodel.datalist = data;

            viewmodel.text = "数据请求成功，已渲染";
        }
    });
}

function gotoLogin(){
    window.location.href="/login/userLogin";

}