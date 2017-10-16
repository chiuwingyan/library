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
import com.zyx.domain.Back;
import com.zyx.domain.Book;
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;
import com.zyx.domain.Search;
import com.zyx.service.BackService;
import com.zyx.service.BorrowService;

@Controller
@Scope("prototype")
public class BackAction extends ActionSupport implements ModelDriven<Back>{
	private static final long serialVersionUID = 113695314694166436L;
	@Autowired
    @Qualifier("backService")
    private BackService backService;
	private Back back=new Back();
	public Back getModel() {
		// TODO Auto-generated method stub
		return back;
	}
	
	public String iniadd(){
		List<Book> list=backService.findallisbn();
		ActionContext.getContext().put("list",list);
		return "iniadd";
	}
	public String add(){
		List<Book> list=backService.findallisbn();
		ActionContext.getContext().put("list",list);
		if(backService.add(back)){
		
			return "backok";}
		else{
			ActionContext.getContext().put("error","该书不在在借列表当中！");
			return "backfalse";
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
		
	        DetachedCriteria criteria = DetachedCriteria.forClass(Back.class);
	        if(search!=null&&!search.trim().isEmpty()){
				
			
	        	criteria.add(Restrictions.eq(search,key));
	        }
	        PageBean<Back> pageBean = backService.findByPage(pageCode, pageSize, criteria);
	        Search search1=new Search(search,key);
	        ValueStack vs = ActionContext.getContext().getValueStack();
	        ActionContext.getContext().put("search",search1);
	        vs.set("page", pageBean);
	        return "page";
	    }

}
