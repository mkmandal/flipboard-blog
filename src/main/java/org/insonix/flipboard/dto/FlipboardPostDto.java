package org.insonix.flipboard.dto;

import java.io.Serializable;

public class FlipboardPostDto implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6777105516847471027L;

	private Long flipboardPostId;

	private String question;

	private String description;
	
	private Long flipboardPostCategoryId;

	private Long userId;

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

	public Long getUserId() {
		return userId;
	}

	public void setUserId(Long userId) {
		this.userId = userId;
	}

	public Long getFlipboardPostCategoryId() {
		return flipboardPostCategoryId;
	}

	public void setFlipboardPostCategoryId(Long flipboardPostCategoryId) {
		this.flipboardPostCategoryId = flipboardPostCategoryId;
	}
	
	

}
