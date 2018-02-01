package org.maker.controller;

import com.alibaba.fastjson.JSONObject;
import org.maker.pojo.EnjEdit;
import org.maker.pojo.Messagers;
import org.maker.pojo.Users;
import org.maker.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class RoleController {

    @Autowired
    private RoleService roleService;

    @RequestMapping("/Role/getRole")
    public String getRole(HttpSession session){
        Users user=(Users) session.getAttribute("loginUserMsg");
        if(user.getUserroleid()!=2){
            return "wyb/userrole/alerterror";
        }else{
            return "wyb/userrole/rolelist";
        }
    }

    @RequestMapping("/Role/queryUser")
    @ResponseBody
    public JSONObject queryUser(@RequestParam(value="page")int page, @RequestParam(value="rows") int rows,Users user){
        JSONObject  list=roleService.queryUser(user,page,rows);
        return list;
    }

    @RequestMapping("/Role/getRoleUser")
    public String getRoleUser(Users user,HttpServletRequest req){
        user=roleService.queryRoles(user);
        List list=roleService.queryRole();
        req.setAttribute("list",list);
        req.setAttribute("user",user);
        return "wyb/userrole/roles";
    }

    @RequestMapping("/Role/updateRole")
    @ResponseBody
    public Object updateRole(Users user){
        System.out.print(user.getUserid());
        int i=roleService.updateRole(user);
        return i;
    }
    @RequestMapping("/messager/getMyMessager")
    public String getMyMessager(){
        return "wyb/userrole/MyMessager";
    }

    @RequestMapping("/messager/queryMessagerByMy")
    @ResponseBody
    public JSONObject queryMessagerByMy(@RequestParam(value="page")int page, @RequestParam(value="rows") int rows, Messagers messagers,HttpSession session){
        Users user=(Users) session.getAttribute("loginUserMsg");
        messagers.setMessagerecipientuser(user.getUsername());
        JSONObject  list=roleService.queryMessagerByMy(messagers,page,rows);
        return list;
    }

    @RequestMapping("/messager/queryUser")
    public String queryUsers(HttpSession session,HttpServletRequest request){
        Users u=new Users();
        Users user=(Users) session.getAttribute("loginUserMsg");
        if(user.getUserroleid()==1){
            u.setUserids("3");
        }else if(user.getUserroleid()==2){
            u.setUserids("1,3");
        }
        List list=roleService.queryUsers(u);
        request.setAttribute("list",list);
        return "wyb/userrole/user";
    }

    @RequestMapping("/messager/updateUser")
    @ResponseBody
    public Object updateUser(Users user,HttpSession session){
        Users u=(Users) session.getAttribute("loginUserMsg");
        user.setTemporaryid(u.getUserroleid());
        int i=roleService.updateUser(user);
        return i;
    }
}
