package ar.edu.unnoba.pdyc.playlist_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "playlists")
public class Playlist {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;
    private String name;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
