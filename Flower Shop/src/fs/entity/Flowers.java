package fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="flowers")
public class Flowers {
	@Id
	@Column(name="id")
int id;
	@Column(name="title")
String title;
	@Column(name="paragraph")
String paragraph;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getParagraph() {
		return paragraph;
	}
	public void setParagraph(String paragraph) {
		this.paragraph = paragraph;
	}
	public Flowers(int id, String title, String paragraph) {
		this.id = id;
		this.title = title;
		this.paragraph = paragraph;
	}
	@Override
	public String toString() {
		return "Flowers [id=" + id + ", title=" + title + ", paragraph=" + paragraph + "]";
	}
	public Flowers(String title, String paragraph) {
	
		this.title = title;
		this.paragraph = paragraph;
	}
	public Flowers() {
	
	}
	    
	
}
