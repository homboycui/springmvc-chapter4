package cn.javass.chapter4.web.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractCommandController;

import cn.javass.chapter4.model.UserModel;

/**
 *@author cfl
 *@createTime 17-12-26
 *@description 该控制器能把自动封装请求参数到一个命令对象，而且提供了验证功能。
*/
public class MyAbstractCommandController extends AbstractCommandController {

	public MyAbstractCommandController() {
		//设置命令对象实现类
		setCommandClass(UserModel.class);
	}
	
	@Override
	protected ModelAndView handle(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors) throws Exception {
		//将命令对象转换为实际类型
		UserModel user = (UserModel) command;
		ModelAndView mv = new ModelAndView();
		mv.setViewName("abstractCommand");
		mv.addObject("user", user);
		return mv;
	}
}
