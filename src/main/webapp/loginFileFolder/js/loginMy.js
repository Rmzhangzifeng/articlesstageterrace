
//获取input的所有id
var user = document.getElementById("user");
var pwd = document.getElementById("pwd");


//获取span的所有id
var user_pass = document.getElementById("user_pass");
var pwd_pass = document.getElementById("pwd_pass");
var loginCheckFlagmsg = document.getElementById("loginCheckFlagmsg");
function checkUser(){
    //如果昵称未输入，则提示输入昵称
    if(!user.value){
        user_pass.style.fontSize = "13px";
        user_pass.style.width="31%";
        user_pass.style.height="2em";
        user_pass.style.textAlign="center";
        user_pass.style.lineHeight="2em";
        user_pass.style.marginTop='0.05%'
        user_pass.innerHTML = '你还没有填写用户名哦。';
        user_pass.style.display="block";
    }
    else if(user.value){
        user_pass.style.display="none";
    }
}

//输入密码提示
function checkUser1(){
    //如果未输入密码，则提示请输入密码
    if(!pwd.value){
        pwd_pass.style.fontSize = "13px";
        pwd_pass.style.width="31%";
        pwd_pass.style.height="2em";
        pwd_pass.style.textAlign="center";
        pwd_pass.style.lineHeight="2em";
        pwd_pass.innerHTML = '你还没有填写密码哦。';
        pwd_pass.style.display="block";
    }
    else{
        pwd_pass.innerHTML ='';
        pwd_pass.style.backgroundColor= "#fff";
        pwd_pass.style.border="none";
        pwd_pass.style.display="none";

    }

}


function  submitB(){

    if(!user.value){
        user_pass.style.fontSize = "13px";
        user_pass.style.width="31%";
        user_pass.style.height="2em";
        user_pass.style.textAlign="center";
        user_pass.style.lineHeight="2em";
        user_pass.innerHTML = '请填写您的用户名。';
        user.focus();
        return false;
    }
    if(!pwd.value){
        pwd_pass.style.fontSize = "13px";
        pwd_pass.style.width="31%";
        pwd_pass.style.height="2em";
        pwd_pass.style.textAlign="center";
        pwd_pass.style.lineHeight="2em";
        pwd_pass.innerHTML = '请填写您的用户密码。';
        pwd.focus();
        return false;
    }

    else{
        return true;
    }

}

function loginUserCheck(){
    var loginFlag = submitB();
    if(loginFlag == true){
        $.ajax({
            url:"/loginCheck",
            type:"post",
            data:$("#login-form").serialize(),
            dataType:"text",
            async:false,
            success:function (resultLoginCheck){
                if(resultLoginCheck == "loginNo"){
                    loginCheckFlagmsg.style.fontSize = "13px";
                    loginCheckFlagmsg.style.width="50%";
                    loginCheckFlagmsg.style.height="2em";
                    loginCheckFlagmsg.style.textAlign="center";
                    loginCheckFlagmsg.style.lineHeight="2em";
                    loginCheckFlagmsg.innerHTML = '<font color="red">账号或者密码不正确，请检查后重新输入！</font>';
                }else if(resultLoginCheck == "loginYes"){
                    location.href="/loginYes/firstShow";
                }
            },
            error:function (){
                alert("程序出点小问题，请联系管理员，谢谢！");
            }
        });
    }
}

