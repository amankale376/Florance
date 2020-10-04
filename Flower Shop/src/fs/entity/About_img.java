package fs.entity;

import javax.persistence.*;
import javax.persistence.Table;

@Entity
@Table(name="about_img")
public class About_img {
@Id
@Column(name="id")
	int id;
@Column(name="img_name")
String name;
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
public About_img(String name) {
	
	this.name = name;
}
public About_img(int id, String name) {

	this.id = id;
	this.name = name;
}
public About_img() {

}

}
