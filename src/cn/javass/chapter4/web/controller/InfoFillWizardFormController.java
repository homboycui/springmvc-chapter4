package cn.javass.chapter4.web.controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.validation.BindException;
import org.springframework.validation.Errors;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.AbstractWizardFormController;

import cn.javass.chapter4.model.UserModel;

/*向导控制器类提供了多步骤（向导）表单的支持（如完善个人资料时分步骤填写基本信息、工作信息、学校信息等）*/
public class InfoFillWizardFormController extends AbstractWizardFormController {
	
	public InfoFillWizardFormController() {
		setCommandClass(UserModel.class);
		setCommandName("user");
	}
	
	@Override
	protected Map referenceData(HttpServletRequest request, int page) throws Exception {
		Map map = new HashMap();
		System.out.println("------------------referenceData page=" + page);
		if (page==0) {
			map.put("currentPage0",page);
		}
		if(page==1) { //如果是填写学校信息页 需要学校类型信息
			map.put("schoolTypeList", Arrays.asList("高中", "中专", "大学"));
		}
		if(page==2) {//如果是填写工作信息页 需要工作城市信息
			map.put("cityList", Arrays.asList("济南", "北京", "上海"));
		}
		map.put("currentPage",page);
		return map;
    }
	
	protected void validatePage(Object command, Errors errors, int page) {
		//提供每一页数据的验证处理方法
		System.out.println("-----------------------validatePage");
		if (page==0){
			System.out.println(page +" "+ command.toString());
		}
		if (page==1){
			System.out.println(page +" "+ command.toString());
		}
		if (page==2){
			System.out.println(page +" "+command.toString());
		}
	}
	
	@Override
	protected void postProcessPage(HttpServletRequest request, Object command, Errors errors, int page) throws Exception {
		//提供给每一页完成时的后处理方法
		System.out.println("-----------------------postProcessPage");
		if (page==0){
			System.out.println(page +" "+command.toString());
		}
		if (page==1){
			System.out.println(page +" "+command.toString());
		}
		if (page==2){
			System.out.println(page +" "+command.toString());
		}
	}
	
	@Override
	protected ModelAndView processFinish(HttpServletRequest req, HttpServletResponse resp, Object command, BindException errors) throws Exception {
		//成功后的处理方法
		System.out.println(command);
		return new ModelAndView("redirect:/success");
	}
	
	@Override
	protected ModelAndView processCancel(HttpServletRequest request, HttpServletResponse response, Object command, BindException errors) throws Exception {
		//取消后的处理方法
		System.out.println(command);
		return new ModelAndView("redirect:/cancel");
	}

}
