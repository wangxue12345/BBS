package org.Service;

import java.sql.SQLException;
import java.util.List;

import org.Util.Author;
import org.Util.AuthorMessage;
import org.Util.Reply;
import org.Util.Topic;

import vo.TopicVo;

public interface BbsService {
	public List<Topic> TopicFormService();
		
	public List<Reply> ReplyFormService(int id);
	public Author loginService(Author author);
	public AuthorMessage authorMessageService(String author);
	public int registerService(Author author);	
	public List<TopicVo> SearchService(TopicVo topic);
	public int deleteTopicService(String[] ids);
	public int updateHeader(String header,String name);
	public int updateForm(AuthorMessage author);
}
