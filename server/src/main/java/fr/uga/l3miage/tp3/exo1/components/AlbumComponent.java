package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.models.AlbumEntity;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.AlbumRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.sql.Date;
import java.util.Set;

@Component
@RequiredArgsConstructor
public class AlbumComponent {
    private final AlbumRepository albumRepository;

    public AlbumEntity getAlbumEntity(String title){
        return albumRepository.findById(title).orElseThrow();
    }

    public AlbumEntity createAlbum(AlbumEntity album){
        return albumRepository.save(album);
    }

    public AlbumEntity updateReleaseDate(String title, Date newReleaseDate){
        AlbumEntity albumEntity =   albumRepository.findById(title).orElseThrow();
        albumEntity.setReleaseDate(newReleaseDate);
        return albumRepository.save(albumEntity);
    }

    public void deleteAlbum(String title){
        albumRepository.deleteById(title);
    }

    public Set<AlbumEntity> getAlbumsByArtist(ArtistEntity artist){
        return albumRepository.findAllByArtistEntity_Name(artist.getName());
    }
}
