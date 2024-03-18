package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.PlaylistEntity;
import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.PlaylistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class PlaylistComponent {
    private final PlaylistRepository playlistRepository;

    public PlaylistEntity getPlaylistEntity(String name){
        return playlistRepository.findById(name).orElseThrow();
    }

    public PlaylistEntity createPlaylist(PlaylistEntity playlistEntity){
        return playlistRepository.save(playlistEntity);
    }

    public PlaylistEntity updateDescription(String name, String newDescription){
        PlaylistEntity playlistEntity= playlistRepository.findById(name).orElseThrow();
        playlistEntity.setDescription(newDescription);
        return playlistRepository.save(playlistEntity);
    }

    public void deletePlaylist(String name){
        playlistRepository.deleteById(name);
    }

    public Set<PlaylistEntity> playlistContainingSong(SongEntity song){
        return playlistRepository.getDistinctBySongEntitiesContains(song);
    }
}
