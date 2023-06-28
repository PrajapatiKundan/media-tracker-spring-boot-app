package com.kp.mediatracker.service;

import com.kp.mediatracker.exception.MediaItemNotFoundRuntimeException;
import com.kp.mediatracker.model.MediaItem;
import com.kp.mediatracker.repository.MediaItemRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MediaItemService {
    private final MediaItemRepository mediaItemRepository;

    public MediaItemService(MediaItemRepository mediaItemRepository) {
        this.mediaItemRepository = mediaItemRepository;
    }

    public List<MediaItem> findAllMediaItems() {
        return mediaItemRepository.findAll();
    }

    public MediaItem saveMediaItem(MediaItem mediaItem) {
        return mediaItemRepository.save(mediaItem);
    }
    // TODO: Figure out if the updating MediaItem to the database change the id or not if not than
    //       we can use saveMediaItem() to add new item and to update existing item.

    public void deleteMediaItem(Long id) {
        mediaItemRepository.deleteById(id);
    }

    public MediaItem findMediaItem(Long id) {
        return mediaItemRepository.findById(id).orElseThrow(() -> new MediaItemNotFoundRuntimeException("Media item is not found!"));
    }
}
