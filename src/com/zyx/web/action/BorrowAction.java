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
import com.zyx.domain.Borrow;
import com.zyx.domain.PageBean;
import com.zyx.domain.Search;
import com.zyx.service.BooklistService;
import com.zyx.service.BorrowService;

@Controller
@Scope("prototype")
public class BorrowAction extends ActionSupport  implements ModelDriven<Borrow>{
	 
	private static final long serialVersionUID = 113695314694166436L;
	@Autowired
    @Qualifier("borrowService")
    private BorrowService borrowService;
	
	private Borrow borrow=new Borrow();
    public Borrow getModel() {
		// TODO Auto-generated method stub
		return borrow;
	}
	
	
	public String iniadd(){
		List<Book> list=borrowService.findallisbn();
		ActionContext.getContext().put("list",list);
		return "iniadd";
	}
	
	public String add(){
		int i=borrowService.add(borrow);
		List<Book> list=borrowService.findallisbn();
		
		if(i==0){
			ActionContext.getContext().put("error","该书库存不足！");
			ActionContext.getContext().put("list",list);
			return "isbnfalse";
		}else if(i==1){
			ActionContext.getContext().put("error","该书已在在借列表中");
			ActionContext.getContext().put("list",list);
			return "barfalse";
		}else{
			
			return "add";
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
		
	        DetachedCriteria criteria = DetachedCriteria.forClass(Borrow.class);
	        if(search!=null&&!search.trim().isEmpty()){
				
			
	        	criteria.add(Restrictions.eq(search,key));
	        }
	        PageBean<Borrow> pageBean = borrowService.findByPage(pageCode, pageSize, criteria);
	        Search search1=new Search(search,key);
	        ValueStack vs = ActionContext.getContext().getValueStack();
	        ActionContext.getContext().put("search",search1);
	        vs.set("page", pageBean);
	        return "page";
	    }

}
