package project.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.domain.Dept;
import project.domain.Job;
import project.domain.Person;
import project.service.DeptService;
import project.service.JobService;
import project.service.PersonService;

@Controller
public class PersonController {

	@Resource
	private PersonService personService;
	@Resource
	private DeptService deptService;
	@Resource
	private JobService jobService;

	/**
	 * 查询所有员工信息
	 */
	@RequestMapping("/personList.action")
	public String findAllPersons(Model model) {
		// 将查询到的所有员工信息添加到页面
		model.addAttribute("persons", personService.selectAllPersons());
		return "/manage/personManage/list.jsp";
	}

	/**
	 * 根据姓名模糊查询员工
	 */
	@RequestMapping("/personSearch.action")
	public String selectPersonByName(Model model, String p_name) {
		// 将查询到的所有员工信息添加到页面
		model.addAttribute("persons",
				personService.selectPersonByName("%" + p_name + "%"));
		return "/manage/personManage/list.jsp";
	}

	/**
	 * 根据id删除员工
	 */
	@RequestMapping("/personDelete.action")
	public String deletePerson(Integer person_id,
			RedirectAttributes redirectAttributes) {
		// 通过id删除
		personService.deletePerson(person_id);
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "redirect:/personList.action";
	}

	/**
	 * 跳转到添加页面
	 */
	@RequestMapping("/personToAdd.action")
	public String toInsertPerson(Model model) {
		return "/manage/personManage/add.jsp";
	}

	/**
	 * 添加员工
	 */
	@RequestMapping("/personAdd.action")
	public String insertPerson(Person person,
			RedirectAttributes redirectAttributes) {
		// 添加员工信息
		personService.insertPerson(person);
		// 添加成功提示
		redirectAttributes.addFlashAttribute("message", "添加成功");
		// 重定向到所有员工信息
		return "redirect:/personList.action";
	}

	/**
	 * 跳转到员工资料修改页面
	 */
	@RequestMapping("/personToUpdate.action")
	public String toUpdatePerson(Integer person_id, Model model) {
		model.addAttribute("p", personService.selectOnePerson(person_id));
		return "/manage/personManage/update.jsp";
	}

	@ResponseBody
	@RequestMapping("/personUpdate.action")
	public String updatePerson(Person person) {
		System.out.println(person);
		personService.updatePersonInfo(person);
		return "redirect:/personList.action";
	}

	/* 人员岗位管理 */

	/**
	 * 进入岗位管理
	 */
	@RequestMapping("/personToManage.action")
	public String toPersonManage(Integer person_id, Model model) {
		model.addAttribute("p", personService.selectOnePerson(person_id));
		model.addAttribute("depts", deptService.findFaDepts());
		return "/manage/personManage/managedept.jsp";
	}

	/**
	 * 用于提交人员信息
	 */
	@RequestMapping("/personManage.action")
	public String personManage(Person person, Model model,
			RedirectAttributes redirectAttributes) {
		personService.updatePersonJobInfo(person);
		if (person.getJob_id() == null) {

			model.addAttribute("jobs",
					jobService.selectJobs(person.getDept_id()));
			model.addAttribute("p",
					personService.selectOnePerson(person.getPerson_id()));
			return "/manage/personManage/managejob.jsp";
		} else {
			redirectAttributes.addFlashAttribute("message", "操作成功");
			return "redirect:/personList.action";
		}
	}

	/**
	 * 根据岗位id查询所有员工信息
	 */
	@ResponseBody
	@RequestMapping("/personListJson.action")
	public List<Person> findAllPersonsJson(Integer job_id) {
		// 将查询到的所有员工信息添加到页面
		List<Person> list = personService.selectPersonById(job_id);
		return list;

	}

	/**
	 * 进入岗位管理,返回json
	 */
	@ResponseBody
	@RequestMapping("/personToManageJson.action")
	public List<Dept> toPersonManageJson() {
		List<Dept> list = deptService.findFaDepts();
		return list;
	}

	/**
	 * ajax用于岗位与部门联动，返回json
	 */
	@ResponseBody
	@RequestMapping("/jobListJson.action")
	public List<Job> jobList(Integer dept_id) {
		return jobService.selectJobs(dept_id);

	}

	/**
	 * 查询所有员工信息json
	 */
	@ResponseBody
	@RequestMapping("/personsList.action")
	public List<Person> findPersonsJson(Model model) {
		// 将查询到的所有员工信息添加到页面
		List<Person> list = personService.selectAllPersons();
		return list;

	}

}
