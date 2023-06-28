package com.kp.mediatracker.repository;

import com.kp.mediatracker.model.MediaItem;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MediaItemRepository extends JpaRepository<MediaItem, Long> {
}
