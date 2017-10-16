package com.zyx.web.action;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.apache.struts2.ServletActionContext;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Controller;

import com.opensymphony.xwork2.ActionContext;
import com.opensymphony.xwork2.ActionSupport;
import com.opensymphony.xwork2.ModelDriven;
import com.opensymphony.xwork2.util.ValueStack;
import com.zyx.domain.Black;
import com.zyx.domain.Book;
import com.zyx.domain.Booktype;
import com.zyx.domain.PageBean;
import com.zyx.domain.Search;
import com.zyx.service.BlackService;
import com.zyx.service.BooklistService;

@Controller
@Scope("prototype")
public class BlackAction extends ActionSupport  implements ModelDriven<Black>{
	private static final long serialVersionUID = 113695314694166436L;
	@Autowired
    @Qualifier("blackService")
    private BlackService blackService;

	private Black black=new Black();
    public Black getModel() {
		// TODO Auto-generated method stub
		return black;
	}
    public String delete(){
    	black=blackService.findById(black.getId());
		   blackService.delete(black);
		   return "delete";
	   }
    public String add() {
       boolean i= blackService.save(black);
      
       if(i){
    	   ActionContext.getContext().put("error","添加成功！");
    	  
        return "success";
        }
    	else{
    		
			 
    		ActionContext.getContext().put("error","该学号已存在！");
    		return "false";
    	}
    }
    public String initUpdate(){
        black  = blackService.findById(black.getId());
        
        return "initUpdate";
    }
    public String update(){
		   
	      boolean i=blackService.findblack(black.getId(), black.getStu_id());
	      if(i){
	    	  blackService.update(black);
	    	 
	    	  ActionContext.getContext().put("error","修改成功！");
	    	  return "update";
	      }
	      else{
	    	
	    	  ActionContext.getContext().put("error","该学号已存在！");
	    	  return "updatefalse";
	    	 
	      }
	    }

    private Integer pageCode = 1;

    public void setPageCode(Integer pageCode) {
           if (pageCode == null) {
               pageCode = 1;
           }
           this.pageCode = pageCode;
       }

       private Integer pageSize = 2;

       public void setPageSize(Integer pageSize) {
           this.pageSize = pageSize;
       }

       /**
        * 分页查询的方法
        *
        * @return
        */
       public String findByPage() {
   	
           DetachedCriteria criteria = DetachedCriteria.forClass(Black.class);
           if(black.getStu_id()!=null&&!black.getStu_id().trim().isEmpty()){
   			
   		
           	criteria.add(Restrictions.eq("stu_id",black.getStu_id()));
           }
           PageBean<Black> pageBean = blackService.findByPage(pageCode, pageSize, criteria);
          
           ValueStack vs = ActionContext.getContext().getValueStack();
           
           vs.set("page", pageBean);
           return "page";
       }
}
