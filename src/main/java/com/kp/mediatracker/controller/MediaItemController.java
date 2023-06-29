package com.kp.mediatracker.controller;

import com.kp.mediatracker.model.MediaItem;
import com.kp.mediatracker.service.MediaItemService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@RestController
@RequestMapping("/mediaitems")
public class MediaItemController {
    private final MediaItemService mediaItemService;

    public MediaItemController(MediaItemService mediaItemService) {
        this.mediaItemService = mediaItemService;
    }

    @GetMapping
    public ResponseEntity<List<MediaItem>> getAllMediaItems() {
        List<MediaItem> mediaItems = mediaItemService.findAllMediaItems();
        return new ResponseEntity<>(mediaItems, HttpStatus.OK);
    }

    @GetMapping("/find/{id}")
    public ResponseEntity<MediaItem> getMediaItemById(@PathVariable("id") Long id) {
        MediaItem mediaItem = mediaItemService.findMediaItem(id);

        if(mediaItem == null)
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);

        return new ResponseEntity<>(mediaItem, HttpStatus.OK);
    }

    @PostMapping("/add")
    public ResponseEntity<MediaItem> addMediaItem(@RequestBody MediaItem mediaItem) {
        MediaItem newMediaItem = mediaItemService.saveMediaItem(mediaItem);
        return new ResponseEntity<>(mediaItem, HttpStatus.CREATED);
    }

    @PostMapping("/update")
    public ResponseEntity<MediaItem> updateMediaItem(@RequestBody MediaItem mediaItem) {
        MediaItem newMediaItem = mediaItemService.saveMediaItem(mediaItem);
        return new ResponseEntity<>(mediaItem, HttpStatus.OK);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteMediaItemById(@PathVariable("id") Long id) {
        mediaItemService.deleteMediaItem(id);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
