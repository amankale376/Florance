package fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="contact")
public class Contact {
@Id
@Column(name="cid")
int id;
@Column(name="cparagraph")
String paragraph;
@Column(name="clocation")
String location;
@Column(name="cemail")
String email;
@Column(name="ccall")
String call;
public int getId() {
	return id;
}
public void setId(int id) {
	this.id = id;
}
public String getParagraph() {
	return paragraph;
}
public void setParagraph(String paragraph) {
	this.paragraph = paragraph;
}
public String getLocation() {
	return location;
}
public void setLocation(String location) {
	this.location = location;
}
public String getEmail() {
	return email;
}
public void setEmail(String email) {
	this.email = email;
}
public String getCall() {
	return call;
}
public void setCall(String call) {
	this.call = call;
}
@Override
public String toString() {
	return "Contact [id=" + id + ", paragraph=" + paragraph + ", location=" + location + ", email=" + email + ", call="
			+ call + "]";
}
public Contact(String call, String email, String location, String paragraph, int id ) {
	
	this.id = id;
	this.paragraph = paragraph;
	this.location = location;
	this.email = email;
	this.call = call;
}
public Contact(String paragraph, String location, String email, String call) {
	
	this.paragraph = paragraph;
	this.location = location;
	this.email = email;
	this.call = call;
}
public Contact() {

}

}
