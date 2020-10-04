package fs.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="about")
public class About {
	@Id
	@Column(name="about_id")
	int id;
	@Column(name="about_title1")
	String title1;
	@Column(name="about_paragraph1")
	String paragraph1;
	@Column(name="about_title2")
	String title2;
	@Column(name="about_paragraph2")
	String paragraph2;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle1() {
		return title1;
	}
	public void setTitle1(String title1) {
		this.title1 = title1;
	}
	public String getParagraph1() {
		return paragraph1;
	}
	public void setParagraph1(String paragraph1) {
		this.paragraph1 = paragraph1;
	}
	public String getTitle2() {
		return title2;
	}
	public void setTitle2(String title2) {
		this.title2 = title2;
	}
	public String getParagraph2() {
		return paragraph2;
	}
	public void setParagraph2(String paragraph2) {
		this.paragraph2 = paragraph2;
	}
	@Override
	public String toString() {
		return "About [id=" + id + ", title1=" + title1 + ", paragraph1=" + paragraph1 + ", title2=" + title2
				+ ", paragraph2=" + paragraph2 + "]";
	}
	public About(int id, String title1, String paragraph1, String title2, String paragraph2) {

		this.id = id;
		this.title1 = title1;
		this.paragraph1 = paragraph1;
		this.title2 = title2;
		this.paragraph2 = paragraph2;
	}
	public About(String title1, String paragraph1, String title2, String paragraph2) {
	
		this.title1 = title1;
		this.paragraph1 = paragraph1;
		this.title2 = title2;
		this.paragraph2 = paragraph2;
	}
	public About() {
		
	}
	
	
	
}
