package com.davidorellana.mongodbapirestspringboot.user.repository;

import com.davidorellana.mongodbapirestspringboot.user.model.data.UserDocument;
import com.davidorellana.mongodbapirestspringboot.user.model.dto.UserDocumentDto;

import java.util.List;

public interface UserDocumentRepository {

    List<UserDocument> findAllUsersDocuments();
    UserDocument findUserDocumentById(String id);
    UserDocument createUserDocument(UserDocumentDto userDocumentDto);
    UserDocument updateUserDocumentById(String id, UserDocumentDto userDocumentDto);
    Boolean deleteUserDocumentById(String id);
    void deleteAllUsersDocument();
    List<UserDocument> findUserDocumentByName(String name);
    List<UserDocument> findUserDocumentByLastName(String lastName);
}
