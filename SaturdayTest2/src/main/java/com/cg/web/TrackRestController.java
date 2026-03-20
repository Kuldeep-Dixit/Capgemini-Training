package com.cg.web;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.cg.entity.Track;
import com.cg.repo.TrackRepo;

@RestController
@RequestMapping("/music/tracks")
public class TrackRestController {
    @Autowired
    private TrackRepo repo;

    @PostMapping
    public ResponseEntity<String> addTrack(@RequestBody Track track) {
        repo.save(track);
        return new ResponseEntity<>("Track Added", HttpStatus.CREATED);
    }

    @GetMapping
    public ResponseEntity<List<Track>> getAllTracks() {
        List<Track> tracks = repo.findAll();
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping("/search")
    public ResponseEntity<List<Track>> getByTitle(@RequestParam("title") String title) {
        List<Track> tracks = repo.findByTrackTitle(title);
        return new ResponseEntity<>(tracks, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getById(@PathVariable Integer id) {
        Optional<Track> track = repo.findById(id);

        if (track.isPresent()) {
            return new ResponseEntity<>(track.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Track not found", HttpStatus.NOT_FOUND);
        }
    }
}