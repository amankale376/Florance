package fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="old_enq")
@Table(name="old_enq")

public class Old_enq {
	@Id
	@Column(name="id")
int id;
	@Column(name="name")
String name;
	@Column(name="email")
String email;
	@Column(name="subject")
String subject;
	@Column(name="message")
String message;
	public Old_enq(int id, String name, String email, String subject, String message) {
	
		this.id = id;
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	@Override
	public String toString() {
		return "New_enq [id=" + id + ", name=" + name + ", email=" + email + ", subject=" + subject + ", message="
				+ message + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getSubject() {
		return subject;
	}
	public void setSubject(String subject) {
		this.subject = subject;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	public Old_enq() {
	
	}
	public Old_enq(String name, String email, String subject, String message) {
	
		this.name = name;
		this.email = email;
		this.subject = subject;
		this.message = message;
	}
	
	
}
