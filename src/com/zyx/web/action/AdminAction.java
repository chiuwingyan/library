package com.zyx.web.action;

import javax.annotation.Resource;

import org.apache.struts2.ServletActionContext;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.sun.javafx.collections.MappingChange.Map;
import com.zyx.domain.*;
import com.zyx.service.AdminService;
@Controller
@Scope("prototype")
public class AdminAction extends ActionSupport implements ModelDriven<Admin>{
	private static final long serialVersionUID = 113695314694166436L;
	private Admin admin=new Admin();
	public Admin getModel() {
		// TODO Auto-generated method stub
		return admin;
	}
	@Resource(name="adminService")
	private AdminService adminService;
	
	private String oldpsw;
	private String newpsw;
	private String rpsw;
	
	public void setOldpsw(String oldpsw) {
		this.oldpsw = oldpsw;
	}
	public void setNewpsw(String newpsw) {
		this.newpsw = newpsw;
	}
	public void setRpsw(String rpsw) {
		this.rpsw = rpsw;
	}

	public String login(){
		//WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
		//AdminService cs = (AdminService) context.getBean("adminService");
		boolean i=adminService.login(admin);
		if(i==true){
			ActionContext.getContext().getSession().put("admin",admin);
			return "success";
		}else{
			ActionContext.getContext().getValueStack().set("erro","yes");
			return "false";
		}
	}

	public String update(){
		Admin admin1=(Admin) ActionContext.getContext().getSession().get("admin");
		String oldpassword=admin1.getPassword();
		String username=admin1.getUsername();
		if(oldpsw.equals(oldpassword)){
			
			adminService.changepassowrd(username, newpsw);
			ActionContext.getContext().put("error","修改成功！");
			ActionContext.getContext().put("oldpsw",oldpassword);
			ActionContext.getContext().put("newpsw",newpsw);
			ActionContext.getContext().put("rpsw",rpsw);
			Admin admin=new Admin(username,newpsw);
			ActionContext.getContext().getSession().put("admin",admin);
			return "update";
		}else{
			ActionContext.getContext().put("error","原密码输入错误！");
			ActionContext.getContext().put("oldpsw",oldpsw);
			ActionContext.getContext().put("newpsw",newpsw);
			ActionContext.getContext().put("rpsw",rpsw);
			return "updatefalse";
		}
	}
	
	
}
