package org.insonix.flipboard.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name="FLIPBOARD_POST_ANSWER")
public class FlipboardPostAnswer implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = -8159568943867471168L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name= "POST_ANSWER_ID")
	private Long id;
	
	@Column(name="ANSWER", nullable=false)
	private String answer;
	
	
	public Long getPostId() {
		return getId();
	}

	public void setPostId(Long postId) {
		this.id = postId;
	}

	@JoinColumn(name="USER_ID", nullable= false)
	@ManyToOne(targetEntity= User.class)
	private User user;
	
	@JoinColumn(name="POST_ID")
	@ManyToOne(targetEntity=FlipboardPost.class)
	private FlipboardPost flipboardPost;
	
	

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getAnswer() {
		return answer;
	}

	public void setAnswer(String answer) {
		this.answer = answer;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}
	
	
	
	

}
