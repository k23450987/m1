package project.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.domain.Dept;
import project.domain.TreeJson;
import project.service.DeptService;

@Controller
public class DeptController {

	@Resource
	private DeptService deptService;

	/**
	 * 显示部门列表
	 */
	@RequestMapping("/deptList.action")
	public String find(Model model) {
		// 查询到所有部门详细信息
		List<Dept> lists = deptService.finDepts();
		// 传值到页面
		model.addAttribute("depts", lists);
		return "/manage/deptManage/list.jsp";

	}

	/**
	 * 跳转到部门添加页面
	 */
	@RequestMapping("/deptToAdd.action")
	public String toInsert(Model model) {
		// 只查找部门id和部门名称，用来填充父部门列表
		List<Dept> depts = deptService.findFaDepts();
		// 传值到页面
		model.addAttribute("depts", depts);
		return "/manage/deptManage/add.jsp";
	}

	/**
	 * 进行部门添加操作
	 */
	@RequestMapping("/deptAdd.action")
	public String insert(Dept dept, String dept_name, Model model,
			RedirectAttributes redirectAttributes) {
		// System.out.println(dept_name);
		// 判断部门名称是否存在
		if (deptService.finDeptByName(dept_name).size() != 0) {
			// 名称已存在,添加错误信息
			model.addAttribute("message", "添加失败，该部门已存在");
			// 返回添加页面
			return "/manage/deptManage/add.jsp";
		}
		// 不存在,添加
		deptService.insert(dept);
		//List<Dept> newDepts = deptService.finDeptByName(dept.getDept_name());
		//for (Dept dept2 : newDepts) {
		//	// 判断添加时该部门是否为顶级部门,通过查询fdept_id是否为0
		//
		//	if (dept2.getFdept_id() == 0) {
		//		// System.out.println(dept2);
		//		// 是!将fdept_id设置为dept_id
		//		dept2.setFdept_id(dept2.getDept_id());
		//		deptService.updateFather(dept2);
		//	}
		//}
		redirectAttributes.addFlashAttribute("message", "添加成功");
		return "redirect:/deptList.action";
	}

	/**
	 * ajax验证
	 */
	@ResponseBody
	@RequestMapping("/deptVerify.action")
	public String verifyDept(String dept_name) {
		if (!dept_name.equals("")) {
			System.out.println(dept_name);
			List<Dept> depts = deptService.finDeptByName(dept_name);

			if (depts.size() != 0) {
				return "fail";
			}
			return "success";
		}
		return "fail";
	}

	/**
	 * 进行部门删除操作
	 */
	@RequestMapping("/deptDel.action")
	public String delete(Integer dept_id, RedirectAttributes redirectAttributes) {
		// 根据页面传的id删除部门
		deptService.delete(dept_id);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "redirect:/deptList.action";
	}

	/**
	 * 跳转到部门修改页面
	 */
	@RequestMapping("/deptToUpdate.action")
	public String toUpdate(Integer dept_id, Model model) {
		// 根据页面的id查询单个部门
		Dept dept = deptService.selectOne(dept_id);
		// 将部门传到页面
		model.addAttribute("dept", dept);
		// 查询所有部门id，名称
		List<Dept> depts = deptService.findFaDepts();
		// 传到页面的下拉菜单
		model.addAttribute("depts", depts);
		return "/manage/deptManage/update.jsp";
	}

	/**
	 * 进行部门信息的修改
	 */
	@SuppressWarnings("unused")
	@RequestMapping("/deptUpdate.action")
	public String update(Dept dept, String dept_name, Model model,
			RedirectAttributes redirectAttributes) {
		deptService.update(dept);
		List<Dept> newDepts = deptService.finDeptByName(dept.getDept_name());
		/*for (Dept dept2 : newDepts) {
			// 判断添加时该部门是否为顶级部门,通过查询fdept_id是否为0
			if (dept2.getFdept_id() == 0) {
				// System.out.println(dept2);
				// 是!将fdept_id设置为dept_id
				dept2.setFdept_id(dept2.getDept_id());
				deptService.updateFather(dept2);
			}
		}*/
		redirectAttributes.addFlashAttribute("message", "修改成功");
		return "redirect:/deptList.action";
	}

	/**
	 * !!!获取树结构
	 */
	@ResponseBody
	@RequestMapping(value = "/deptTree.action", produces = "application/json;charset=UTF-8")
	public List<TreeJson> test() {
		List<TreeJson> list = deptService.getOrgInfo();
		return list;
	}

	/**
	 * 显示部门列表json
	 */
	@ResponseBody
	@RequestMapping("/deptListJson.action")
	public List<Dept> findDeptJson() {
		// 查询到所有部门详细信息
		// 传值到页面
		return deptService.finDepts();
	}

}
