package com.davidorellana.mongodbapirestspringboot.user.repository.mongorepository;

import com.davidorellana.mongodbapirestspringboot.user.model.data.UserDocument;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;

import java.util.List;

public interface UserDocumentMongoRepository extends MongoRepository<UserDocument, String> {

    @Query(value = "{'name' : ?0}", exists = true)
    List<UserDocument> findUserDocumentByName(String name);

    @Query(value = "{'lastName' : ?0}", exists = true)
    List<UserDocument> findUserDocumentByLastName(String lastName);
}
