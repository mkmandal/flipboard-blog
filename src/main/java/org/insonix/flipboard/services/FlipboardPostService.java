package org.insonix.flipboard.services;



import java.util.List;

import org.insonix.flipboard.dto.FlipboardPostDto;
import org.insonix.flipboard.models.FlipboardPost;

public interface FlipboardPostService extends BaseService<FlipboardPost, Long> {

	public FlipboardPostDto savePost(FlipboardPostDto flipboardPostDto);

	public List<FlipboardPost> flipboardPostList();
	
	public List<FlipboardPost> userPostList(Long userId);
}
