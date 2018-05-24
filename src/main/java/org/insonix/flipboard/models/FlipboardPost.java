package org.insonix.flipboard.models;

import java.io.Serializable;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "FLIPBOARD_POST")
public class FlipboardPost implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6777105516847471027L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "POST_ID")
	private Long flipboardPostId;

	@Column(name = "QUESTION", nullable = false, unique = true)
	private String question;

	@Column(name = "DESCRIPTION")
	private String description;

	@JoinColumn(name = "POST_CATEGORY_ID", nullable = false)
	@OneToOne(targetEntity = FlipboardPostCategory.class, cascade = CascadeType.ALL)
	private FlipboardPostCategory flipboardPostCategory;

	@JoinColumn(name = "USER_ID", nullable = false)
	@ManyToOne(targetEntity = User.class)
	private User user;

	public Long getFlipboardPostId() {
		return flipboardPostId;
	}

	public void setFlipboardPostId(Long flipboardPostId) {
		this.flipboardPostId = flipboardPostId;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public FlipboardPostCategory getFlipboardPostCategory() {
		return flipboardPostCategory;
	}

	public void setFlipboardPostCategory(FlipboardPostCategory flipboardPostCategory) {
		this.flipboardPostCategory = flipboardPostCategory;
	}

	public User getUser() {
		return user;
	}

	public void setUser(User user) {
		this.user = user;
	}

}
