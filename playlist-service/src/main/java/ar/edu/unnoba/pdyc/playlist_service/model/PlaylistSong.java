package ar.edu.unnoba.pdyc.playlist_service.model;

import jakarta.persistence.*;

@Entity
@Table(name = "playlists_songs")
public class PlaylistSong {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false)
    private Long id;

    @Column(name = "playlist_id")
    private Long playlistId;

    @Column(name = "song_id")
    private Long songId;


    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPlaylistId() {
        return playlistId;
    }

    public void setPlaylistId(Long playlistId) {
        this.playlistId = playlistId;
    }

    public Long getSongId() {
        return songId;
    }

    public void setSongId(Long songId) {
        this.songId = songId;
    }
}
