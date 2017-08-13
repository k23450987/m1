package project.controller;

import java.util.List;
import javax.annotation.Resource;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import project.domain.Job;
import project.service.DeptService;
import project.service.JobService;

@Controller
public class JobController {

	@Resource
	private JobService jobService;
	@Resource
	private DeptService deptService;

	/**
	 * 这个action用于查询当前所有岗位的详细信息
	 */
	@RequestMapping("/jobList.action")
	public String findJobs(Model model) {
		List<Job> jobs = jobService.selectAll();
		// 将查询到的所有岗位信息传到页面
		model.addAttribute("jobs", jobs);
		return "/manage/jobManage/list";
	}

	/**
	 * 根据提交的岗位id删除岗位
	 */
	@RequestMapping("/jobDelete.action")
	public String deleteJob(Integer job_id, RedirectAttributes redirectAttributes) {
		// 调用删除方法
		jobService.delete(job_id);
		// 重定向到岗位列表
		redirectAttributes.addFlashAttribute("message", "删除成功");
		return "redirect:/jobList.action";
	}

	/**
	 * 前往添加页面
	 */
	@RequestMapping("/jobToAdd.action")
	public String toInsert(Model model) {
		// 将部门名称，部门id传到update.jsp页面
		model.addAttribute("depts", deptService.selectFather());
		// 跳转到添加页面
		return "/manage/jobManage/add";
	}

	/**
	 * 进行添加操作
	 */
	@RequestMapping("/jobAdd.action")
	public String insertJob(Job job, RedirectAttributes redirectAttributes) {
		// 调用添加方法
		jobService.insert(job);
		// 重定向查询页面
		redirectAttributes.addFlashAttribute("message", "添加成功");
		return "redirect:/jobList.action";
	}

	/**
	 * 前往岗位修改页面
	 */
	@RequestMapping("/jobToUpdate.action")
	public String toUpdateJob(Model model, Integer job_id) {
		// 将要修改的岗位实体传到update.jsp页面
		model.addAttribute("job", jobService.select(job_id));
		// 将部门名称，部门id传到update.jsp页面
		model.addAttribute("depts", deptService.selectFather());
		return "/manage/jobManage/update";
	}

	/**
	 * 更新网页传回来的岗位信息
	 */
	@ResponseBody
	@RequestMapping("/jobUpdate.action")
	public String updateJob(Job job, RedirectAttributes redirectAttributes) {
		// System.out.println(job);
		jobService.update(job);
		// 重定向查询页面
		redirectAttributes.addFlashAttribute("message", "修改成功");
		return "true";
	}

	/**
	 * 返回json部门列表
	 */
	@ResponseBody
	@RequestMapping("/JobListJson.action")
	public List<Job> findJson(Integer dept_id) {
		// 查询到所有部门详细信息
		// 传值到页面
		return jobService.selectJobs(dept_id);

	}

	/**
	 * ajax根据提交的岗位id删除岗位
	 */
	@ResponseBody
	@RequestMapping("/jobDeleteAjax.action")
	public String deleteJobAjax(Integer job_id) {
		// 调用删除方法
		jobService.delete(job_id);
		// 重定向到岗位列表
		return "true";
	}

	/**
	 * 这个action用于查询当前所有岗位的详细信息
	 */
	@ResponseBody
	@RequestMapping("/jobsListJson.action")
	public List<Job> findJobsJson() {
		// 将查询到的所有岗位信息传到页面
		return jobService.selectAll();
	}
}
