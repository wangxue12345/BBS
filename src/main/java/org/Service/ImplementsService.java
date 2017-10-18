package org.Service;

import java.sql.JDBCType;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import javax.sql.DataSource;

import org.Util.Author;
import org.Util.AuthorMessage;
import org.Util.Reply;
import org.Util.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import Dao.BbsDao;
import Dao.ImplementsDao;
import vo.TopicVo;
@Service
public class ImplementsService implements BbsService {
	@Autowired 
	BbsDao dao;
	@Override
	public List<Topic> TopicFormService(){
		List<Topic> list=dao.TopicFormDao();
		return list;
	}
	
	@Override
	public List<Reply> ReplyFormService(int id) {
		List<Reply> list=dao.DetailDao(id);
		return list;
	}

	@Override
	public Author loginService(Author author) {
		Author login=dao.loginDao(author);
		return login;
	}

	@Override
	public AuthorMessage authorMessageService(String author) {
		AuthorMessage message=dao.AuthorDao(author);
		return message ;
	}

	@Override
	public int registerService(Author author) {
		int register=dao.registerDao(author);
		return register;
	}

	@Override
	public List<TopicVo> SearchService(TopicVo topic) {
		List<TopicVo> list=dao.SearchDao(topic);
		return list;
	}

	@Override
	public int deleteTopicService(String[] ids) {
		int delete=dao.deleteTopicDao(ids);
		return delete;
	}

	@Override
	public int updateHeader(String header,String name) {
		int update=dao.updateHeader(header,name);
		return update;
	}

	@Override
	public int updateForm(AuthorMessage author) {
		int update=dao.updateFormDao(author);
		return 0;
	}

	/*@Override
	public int registerService(String name, String pass) {
		int register=dao.registerDao(name, pass);
		return register;
	}
*/




	
	 

}
