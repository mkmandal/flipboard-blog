package org.insonix.flipboard.repositories;

import java.util.List;

import org.insonix.flipboard.models.FlipboardPost;
import org.springframework.stereotype.Repository;

@Repository
public interface FlipboardPostRepository extends  BaseRepository<FlipboardPost, Long> {
	
	List<FlipboardPost> findByUserId(Long userId);
  
}

