package net.engineeringdigest.journalApp.repositories;

import net.engineeringdigest.journalApp.Entity.JournalClass;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface journal_repositories extends MongoRepository<JournalClass, ObjectId >{



}
