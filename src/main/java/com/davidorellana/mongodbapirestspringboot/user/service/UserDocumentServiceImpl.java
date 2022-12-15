package com.davidorellana.mongodbapirestspringboot.user.service;

import com.davidorellana.mongodbapirestspringboot.user.model.data.UserDocument;
import com.davidorellana.mongodbapirestspringboot.user.model.dto.UserDocumentDto;
import com.davidorellana.mongodbapirestspringboot.user.repository.UserDocumentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserDocumentServiceImpl implements UserDocumentService {

    private final UserDocumentRepository userDocumentRepository;

    @Autowired
    public UserDocumentServiceImpl(UserDocumentRepository userDocumentRepository) {
        this.userDocumentRepository = userDocumentRepository;
    }

    @Override
    public List<UserDocument> findAllUsersDocuments() {
        return userDocumentRepository.findAllUsersDocuments();
    }

    @Override
    public UserDocument findUserDocumentById(String id) {
        return userDocumentRepository.findUserDocumentById(id);
    }

    @Override
    public UserDocument createUserDocument(UserDocumentDto userDocumentDto) {
        return userDocumentRepository.createUserDocument(userDocumentDto);
    }

    @Override
    public UserDocument updateUserDocumentById(String id, UserDocumentDto userDocumentDto) {
        return userDocumentRepository.updateUserDocumentById(id, userDocumentDto);
    }

    @Override
    public Boolean deleteUserDocumentById(String id) {
        return userDocumentRepository.deleteUserDocumentById(id);
    }

    @Override
    public void deleteAllUsersDocument() {
        userDocumentRepository.deleteAllUsersDocument();
    }

    @Override
    public List<UserDocument> findUserDocumentByName(String name) {
        return userDocumentRepository.findUserDocumentByName(name);
    }

    @Override
    public List<UserDocument> findUserDocumentByLastName(String lastName) {
        return userDocumentRepository.findUserDocumentByLastName(lastName);
    }
}
