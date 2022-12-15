package com.davidorellana.mongodbapirestspringboot.user.repository;

import com.davidorellana.mongodbapirestspringboot.user.model.data.UserDocument;
import com.davidorellana.mongodbapirestspringboot.user.model.dto.UserDocumentDto;
import com.davidorellana.mongodbapirestspringboot.user.repository.mongorepository.UserDocumentMongoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class UserDocumentRepositoryImpl implements UserDocumentRepository {

    private final UserDocumentMongoRepository userDocumentMongoRepository;

    @Autowired
    public UserDocumentRepositoryImpl(UserDocumentMongoRepository userDocumentMongoRepository) {
        this.userDocumentMongoRepository = userDocumentMongoRepository;
    }

    @Override
    public List<UserDocument> findAllUsersDocuments() {
        return userDocumentMongoRepository.findAll();
    }

    @Override
    public UserDocument findUserDocumentById(String id) {
        Optional<UserDocument> userDocumentFound = userDocumentMongoRepository.findById(id);
        if (userDocumentFound.isPresent()) {
            return userDocumentFound.get();
        }
        return null;
    }

    @Override
    public UserDocument createUserDocument(UserDocumentDto userDocumentDto) {
        UserDocument userDocument = new UserDocument(userDocumentDto);
        return userDocumentMongoRepository.insert(userDocument);
    }

    @Override
    public UserDocument updateUserDocumentById(String id, UserDocumentDto userDocumentDto) {
        UserDocument userDocumentFound = findUserDocumentById(id);
        if (userDocumentFound != null) {
            userDocumentFound.updateUserDocument(userDocumentDto);
            return userDocumentMongoRepository.save(userDocumentFound);
        }
        return null;
    }

    @Override
    public Boolean deleteUserDocumentById(String id) {
        UserDocument userDocumentFound = findUserDocumentById(id);
        if (userDocumentMongoRepository.existsById(id)) {
            userDocumentMongoRepository.delete(userDocumentFound);
            return true;
        }
        return false;
    }

    @Override
    public void deleteAllUsersDocument() {
        List<UserDocument> userDocumentFound = findAllUsersDocuments();
        userDocumentMongoRepository.deleteAll(userDocumentFound);
    }

    @Override
    public List<UserDocument> findUserDocumentByName(String name) {
        List<UserDocument> userDocumentByNameFound = userDocumentMongoRepository.findUserDocumentByName(name);
        if (userDocumentByNameFound.isEmpty()) {
            return null;
        }
        return userDocumentByNameFound;
    }

    @Override
    public List<UserDocument> findUserDocumentByLastName(String lastName) {
        List<UserDocument> userDocumentByLastNameFound = userDocumentMongoRepository.findUserDocumentByLastName(lastName);
        if (userDocumentByLastNameFound.isEmpty()) {
            return null;
        }
        return userDocumentByLastNameFound;
    }
}
