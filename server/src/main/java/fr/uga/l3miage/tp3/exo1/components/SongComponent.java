package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.SongEntity;
import fr.uga.l3miage.tp3.exo1.repositories.SongRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.time.Duration;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class SongComponent {
    private final SongRepository songRepository;

    public SongEntity getSongEntity(String title){
        return songRepository.findById(title).orElseThrow();
    }

    public SongEntity createSong(SongEntity songEntity){
        return songRepository.save(songEntity);
    }

    public SongEntity updateSongDuration(String title,Duration newDuration){
        SongEntity songEntity = songRepository.findById(title).orElseThrow();
        songEntity.setDuration(newDuration);
        return songRepository.save(songEntity);
    }

    public void deleteSong(String title){
        songRepository.deleteById(title);
    }

    public Set<SongEntity> getAllSongOnDuration(Duration min, Duration max){
        return  songRepository.findSongEntitiesByDurationBetween(min,max);
    }
}
