package fr.uga.l3miage.tp3.exo1.components;

import fr.uga.l3miage.tp3.exo1.enums.GenreMusical;
import fr.uga.l3miage.tp3.exo1.models.ArtistEntity;
import fr.uga.l3miage.tp3.exo1.repositories.ArtistRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

import java.util.Set;

@Component
@RequiredArgsConstructor
public class ArtistComponent {
    private final ArtistRepository artistRepository;

    public ArtistEntity getArtistEntity(String name){
        return artistRepository.findById(name).orElseThrow();
    }

    public ArtistEntity createArtist(ArtistEntity artistEntity){
        return artistRepository.save(artistEntity);
    }

    public ArtistEntity updateBiography(String name, String newBiography){
        ArtistEntity artistEntity = artistRepository.findById(name).orElseThrow();
        artistEntity.setBiography(newBiography);
        return artistRepository.save(artistEntity);
    }

    public void deletArtist(String name){artistRepository.deleteById(name);}

    public int getArtistsByGenre(GenreMusical genreMusical){
        return artistRepository.countArtistEntitiesByGenreMusical(genreMusical);
    }
}
