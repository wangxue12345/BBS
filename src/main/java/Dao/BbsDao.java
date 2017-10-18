package Dao;

import java.util.HashMap;
import java.util.List;
import org.Util.Author;
import org.Util.AuthorMessage;
import org.Util.Reply;
import org.Util.Topic;

import vo.TopicVo;

public interface BbsDao {
	 public List<Topic> TopicFormDao() ;
	 public List<Reply>  DetailDao(Integer id)  ;
	 public AuthorMessage AuthorDao(String author);
	 public Author loginDao(Author author);
	 public int registerDao(Author author);
	public List<TopicVo> SearchDao(TopicVo topic);
	public int deleteTopicDao(String[] ids);
	public int updateFormDao(AuthorMessage author);
	public int updateHeader(String header,String name);
}
