package vo;

public class TopicVo {
	String id;
	String author;
	String title;
	String header;
	public String getReply_author() {
		return reply_author;
	}
	public void setReply_author(String reply_author) {
		this.reply_author = reply_author;
	}
	public String getReply_content() {
		return reply_content;
	}
	public void setReply_content(String reply_content) {
		this.reply_content = reply_content;
	}
	public String getReply_date() {
		return reply_date;
	}
	public void setReply_date(String reply_date) {
		this.reply_date = reply_date;
	}
	String reply_author;
	String reply_content;
	String reply_date;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getCreatetime() {
		return createtime;
	}
	public void setCreatetime(String createtime) {
		this.createtime = createtime;
	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	
	
	public String getHeader() {
		return header;
	}
	public void setHeader(String header) {
		this.header = header;
	}
	String createtime;
	String order;
}
