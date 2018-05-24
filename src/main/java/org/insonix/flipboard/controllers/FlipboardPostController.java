package org.insonix.flipboard.controllers;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

import java.util.List;

import org.insonix.flipboard.dto.FlipboardPostDto;
import org.insonix.flipboard.models.FlipboardPost;
import org.insonix.flipboard.services.FlipboardPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/flipboardPost")
public class FlipboardPostController {

	@Autowired
	private FlipboardPostService flipboardPostService;

	@RequestMapping(value = "/savePost", method = RequestMethod.POST, consumes = APPLICATION_JSON_VALUE, produces = APPLICATION_JSON_VALUE)
	public FlipboardPostDto savePost(@RequestBody FlipboardPostDto flipboardPostdto) {
		return flipboardPostService.savePost(flipboardPostdto);
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public List<FlipboardPost> retrievePosts() {
		return flipboardPostService.flipboardPostList();
	}
	
	@RequestMapping(value = "/userPosts/{userId}", method = RequestMethod.GET, produces = APPLICATION_JSON_VALUE)
	public List<FlipboardPost> retrieveUserPosts(@PathVariable("userId") Long userId) {
		return flipboardPostService.userPostList(userId);

}
}