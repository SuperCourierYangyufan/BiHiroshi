package domain;

public class Message {
	private Integer message_id;
	private String message_text;
	private String message_uuid;
	private String message_time;
	private User user;
	public Integer getMessage_id() {
		return message_id;
	}
	public void setMessage_id(Integer message_id) {
		this.message_id = message_id;
	}
	public String getMessage_text() {
		return message_text;
	}
	public void setMessage_text(String message_text) {
		this.message_text = message_text;
	}
	public String getMessage_uuid() {
		return message_uuid;
	}
	public void setMessage_uuid(String message_uuid) {
		this.message_uuid = message_uuid;
	}
	public String getMessage_time() {
		return message_time;
	}
	public void setMessage_time(String message_time) {
		this.message_time = message_time;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	
	
}
