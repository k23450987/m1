package demo.dao.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.support.SqlSessionDaoSupport;
import org.springframework.stereotype.Repository;

import demo.dao.PerDao;
import demo.domain.Pager;
import demo.domain.Person;

@Repository
public class PerDaoImpl extends SqlSessionDaoSupport implements PerDao {
	
	@Resource
	public void setSqlSessionFactory(SqlSessionFactory sqlSessionFactory) {
		super.setSqlSessionFactory(sqlSessionFactory);
	}

	@Override
	public Pager<Person> pageFind(Map<String, Object> params) {
		int count = this.getSqlSession().selectOne("demo.domain.Person.counts", params);
		List<Person> datas = this.getSqlSession().selectList("demo.domain.Person.pagefind", params);
		Pager<Person> pager = new Pager<Person>();
		if (count > 0) {
			pager.setCount(count);
			pager.setDatas(datas);
		}
		return pager;
	}

}
