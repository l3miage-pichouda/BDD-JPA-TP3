package fr.uga.l3miage.tp3.exo1.models;

import lombok.*;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import java.time.Duration;
import java.util.Set;

@Entity
@Setter
@Getter
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PlaylistEntity {
    @Id
    private String name;

    private String description;

    private Duration totalDuration;

    @OneToMany(mappedBy = "playlist", cascade = CascadeType.ALL)
    private Set<SongEntity> songEntities;
}
