package org.insonix.flipboard.models;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "FLIPBOARD_POST_CATEGORY")
public class FlipboardPostCategory implements Serializable {

	
	/**
	 * 
	 */
	private static final long serialVersionUID = 3937981673500896197L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="POST_CATEGORY_ID")
	private Long id;
	
	@Column(name = "POST_CATEGORY_TYPE", nullable= false)
	private String postCategoryType;
	
	
	

	public FlipboardPostCategory() {
	}

	public FlipboardPostCategory(Long id) {
		this.id = id;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPostCategoryType() {
		return postCategoryType;
	}

	public void setPostCategoryType(String postCategoryType) {
		this.postCategoryType = postCategoryType;
	}
	
	
	
	

}
