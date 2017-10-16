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
import com.zyx.domain.Admin;
import com.zyx.domain.Book;
import com.zyx.domain.Booktype;
import com.zyx.domain.PageBean;
import com.zyx.domain.Search;
import com.zyx.service.BooklistService;



@Controller
@Scope("prototype")
public class BooklistAction extends ActionSupport  implements ModelDriven<Book>{
	
	 private static final long serialVersionUID = 113695314694166436L;
	 //属性驱动
    //当前页,默认值1
	 // 提供service的成员属性，提供set方法
	    @Autowired
	    @Qualifier("booklistService")
	    private BooklistService booklistService;

		private Book book=new Book();
	    public Book getModel() {
			// TODO Auto-generated method stub
			return book;
		}
	   
		public String add() {
	        System.out.println("WEB层：保存客户...");
	        /*// WEB的工厂
			WebApplicationContext context = WebApplicationContextUtils.getWebApplicationContext(ServletActionContext.getServletContext());
			CustomerService cs = (CustomerService) context.getBean("customerService");
			// 调用方法
			cs.save(customer);*/
	        
	    	
	       boolean i= booklistService.save(book);
	       List<Booktype> list=booklistService.btlist();
	       if(i){
	    	   ActionContext.getContext().put("error","添加成功！");
	    	   ActionContext.getContext().put("btlist", list);
	    	   ActionContext.getContext().put("book",book);
	        return "success";
	        }
	    	else{
	    		
				 ActionContext.getContext().put("btlist", list);
	    		ActionContext.getContext().put("book",book);
	    		ActionContext.getContext().put("error","该ISBN已存在！");
	    		return "false";
	    	}
	    }
	    public String btlist(){
	    	
			List<Booktype> list=booklistService.btlist();
			 ActionContext.getContext().put("btlist", list);
			return "bookadd";
	    	
	    }
	   public String delete(){
		   book=booklistService.findById(book.getId());
		   booklistService.delete(book);
		   return "delete";
	   }
	  
	   public String initUpdate(){
	        book  = booklistService.findById(book.getId());
	        List<Booktype> list=booklistService.btlist();
	        ActionContext.getContext().put("btlist", list);
	        return "initUpdate";
	    }
	   
	   public String update(){
		   List<Booktype> list=booklistService.btlist();
	      boolean i=booklistService.findbook(book.getId(), book.getIsbn());
	      if(i){
	    	  booklistService.update(book);
	    	  ActionContext.getContext().put("btlist", list);
	    	  ActionContext.getContext().put("error","修改成功！");
	    	  return "update";
	      }
	      else{
	    	  ActionContext.getContext().put("btlist", list);
	    	  ActionContext.getContext().put("error","该ISBN已存在！");
	    	  return "updatefalse";
	    	 
	      }
	    }

	    HttpServletRequest request = ServletActionContext.getRequest();
        String search = request.getParameter("search");
        String key = request.getParameter("key");


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
	
        DetachedCriteria criteria = DetachedCriteria.forClass(Book.class);
        if(search!=null&&!search.trim().isEmpty()){
			
		
        	criteria.add(Restrictions.eq(search,key));
        }
        PageBean<Book> pageBean = booklistService.findByPage(pageCode, pageSize, criteria);
        Search search1=new Search(search,key);
        ValueStack vs = ActionContext.getContext().getValueStack();
        ActionContext.getContext().put("search",search1);
        vs.set("page", pageBean);
        return "page";
    }

	
}
