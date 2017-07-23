package org.dfhu.sparkingrocks.model;

import com.mongodb.MongoClient;
import org.dfhu.sparkingrocks.config.DatabaseInfoConfig;
import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.Morphia;

import java.util.Collection;

public class DataProvider {

  /**
   * Creates a Datastore, ensures indexes
   * @param packageMaps - list of package names that contain views (e.g. com.example.morphs, com.example.library.morphs)
   * @param config - must have databaseHostname and databaseName
   * @return - newly created Datastore
   */
  public static Datastore create(Collection<String> packageMaps, DatabaseInfoConfig config) {
    Morphia morphia = new Morphia();
    // tell Morphia where to find your classes
    for (String packageMap: packageMaps) {
      try {
        morphia.mapPackage(packageMap);
      } catch (Throwable t) {
        throw new RuntimeException("Could not find packages: " + packageMap + " " + t.getMessage());
      }
    }

    String databaseHostname = config.getDatabaseHostname();
    String databaseName = config.getDatabaseName();

    // create the Datastore connecting to the default port on the local host
    Datastore datastore = morphia.createDatastore(
      new MongoClient(databaseHostname), databaseName);
    datastore.ensureIndexes();

    return datastore;
  }
}
