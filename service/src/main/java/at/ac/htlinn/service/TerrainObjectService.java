package at.ac.htlinn.service;

import at.ac.htlinn.model.entities.TerrainObject;

public interface TerrainObjectService {
    void compareAndUpdateDatabase(TerrainObject terrainObject);
}
