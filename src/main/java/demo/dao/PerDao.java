package demo.dao;

import java.util.Map;

import demo.domain.Person;
import demo.domain.Pager;

public interface PerDao {

	/**
	 * 分页查询Person
	 * @param params 查询参数，必须要有offset和pageSize
	 * @return 分页结果对象
	 */
	public Pager<Person> pageFind(Map<String, Object> params);

}