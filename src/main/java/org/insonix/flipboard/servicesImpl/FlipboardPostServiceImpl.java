package org.insonix.flipboard.servicesImpl;

import java.util.List;

import org.insonix.flipboard.dto.FlipboardPostDto;
import org.insonix.flipboard.models.FlipboardPost;
import org.insonix.flipboard.models.FlipboardPostCategory;
import org.insonix.flipboard.models.User;
import org.insonix.flipboard.repositories.FlipboardPostCategoryRepository;
import org.insonix.flipboard.repositories.FlipboardPostRepository;
import org.insonix.flipboard.services.FlipboardPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service("flipboardPostService")
public class FlipboardPostServiceImpl extends BaseServiceImpl<FlipboardPost, Long> implements FlipboardPostService {

	@Autowired
	private FlipboardPostRepository flipboardPostRepository;

	@Autowired
	private FlipboardPostCategoryRepository flipboardPostCategoryRepository;

	@Override
	public FlipboardPostDto savePost(FlipboardPostDto flipboardPostDto) {
		FlipboardPost flipboardPost = getFlipboardPostObj(flipboardPostDto);
		if (null != flipboardPost) {
			flipboardPost = flipboardPostRepository.save(flipboardPost);
			flipboardPostDto = getFlipboardPostDtoObj(flipboardPost);
		}
		return flipboardPostDto;
	}

	private FlipboardPost getFlipboardPostObj(FlipboardPostDto flipboardPostDto) {
		FlipboardPost flipboardPost = null;
		if (null != flipboardPostDto) {
			flipboardPost = new FlipboardPost();
			if (flipboardPostDto.getFlipboardPostId() != null)
				flipboardPost.setFlipboardPostId(flipboardPostDto.getFlipboardPostId());
			flipboardPost.setUser(new User(flipboardPostDto.getUserId()));
			FlipboardPostCategory flipboardPostCategory = flipboardPostCategoryRepository
					.findOne(flipboardPostDto.getFlipboardPostCategoryId());
			flipboardPost.setFlipboardPostCategory(flipboardPostCategory);
			flipboardPost.setQuestion(flipboardPostDto.getQuestion());
			flipboardPost.setDescription(flipboardPostDto.getDescription());
		}
		return flipboardPost;
	}

	private FlipboardPostDto getFlipboardPostDtoObj(FlipboardPost flipboardPost) {
		FlipboardPostDto flipboardPostDto = null;
		if (null != flipboardPost) {
			flipboardPostDto = new FlipboardPostDto();
			flipboardPostDto.setFlipboardPostId(flipboardPost.getFlipboardPostId());
			flipboardPostDto.setQuestion(flipboardPost.getQuestion());
			flipboardPostDto.setDescription(flipboardPost.getDescription());
			flipboardPostDto.setUserId(flipboardPost.getUser().getId());
		}
		return flipboardPostDto;
	}

	@Override
	public List<FlipboardPost> flipboardPostList() {
		List<FlipboardPost> postList = flipboardPostRepository.findAll();
		return postList;
	}

	@Override
	public List<FlipboardPost> userPostList(Long userId) {
		List<FlipboardPost> userPostsList = flipboardPostRepository.findByUserId(userId);
		return userPostsList;
	}

}
