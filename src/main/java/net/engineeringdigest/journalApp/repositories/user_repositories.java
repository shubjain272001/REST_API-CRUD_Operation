package net.engineeringdigest.journalApp.repositories;

import net.engineeringdigest.journalApp.Entity.User;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface user_repositories extends MongoRepository<User, ObjectId> {

  User findByUsername(String username) ;
 void  deleteByUsername(String username);


}
