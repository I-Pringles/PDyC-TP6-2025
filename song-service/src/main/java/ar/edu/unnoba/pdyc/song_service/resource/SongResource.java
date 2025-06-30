package ar.edu.unnoba.pdyc.song_service.resource;

import ar.edu.unnoba.pdyc.song_service.DTOs.SongDTO;
import ar.edu.unnoba.pdyc.song_service.DTOs.SongRequestDTO;
import ar.edu.unnoba.pdyc.song_service.model.Song;
import ar.edu.unnoba.pdyc.song_service.service.SongServiceImp;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/songs")
public class SongResource {
    private final SongServiceImp songService;

    @Autowired
    public SongResource(SongServiceImp service){
        this.songService = service;
    }

    @PostMapping
    public ResponseEntity<Void> create(@RequestBody SongRequestDTO dto){
        songService.createSong(dto);
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    @GetMapping("/{id}")
    public ResponseEntity<SongDTO> getById(@PathVariable Long id){
        SongDTO dto = new SongDTO();
        try {
            dto = songService.findById(id);
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.BAD_REQUEST).build();
        }
        return ResponseEntity.ok(dto);
    }

    @GetMapping
    public ResponseEntity<List<SongDTO>> getAll(){
        return ResponseEntity.ok(songService.getSongs());
    }
}
