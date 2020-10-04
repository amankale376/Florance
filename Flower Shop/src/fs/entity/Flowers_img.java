package fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity(name="flowers_img")
@Table(name="flowers_img")
public class Flowers_img {
@Id
@Column(name="id")
int id;
@Column(name="name")
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
public Flowers_img(int id, String name) {
	this.id = id;
	this.name = name;
}
@Override
public String toString() {
	return "Flowers_img [id=" + id + ", name=" + name + "]";
}
public Flowers_img(String name) {
	
	this.name = name;
}
public Flowers_img() {

}

}
