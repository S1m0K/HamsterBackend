package at.ac.htlinn.model.entities;

import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RunConfig {
    TerrainObject terrainObject;
    private Set<Program> programs = new HashSet<>();
}
