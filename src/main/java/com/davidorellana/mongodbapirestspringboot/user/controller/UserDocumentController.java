package com.davidorellana.mongodbapirestspringboot.user.controller;

import com.davidorellana.mongodbapirestspringboot.user.model.data.UserDocument;
import com.davidorellana.mongodbapirestspringboot.user.model.dto.UserDocumentDto;
import com.davidorellana.mongodbapirestspringboot.user.service.UserDocumentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*", allowedHeaders = "*")
@RestController
@RequestMapping("/v1/usersDocuments")
public class UserDocumentController {

    private final UserDocumentService userDocumentService;

    @Autowired
    public UserDocumentController(UserDocumentService userDocumentService) {
        this.userDocumentService = userDocumentService;
    }

    @GetMapping
    public ResponseEntity<List<UserDocument>> findAllUsersDocuments() {
        List<UserDocument> userDocumentsList = userDocumentService.findAllUsersDocuments();
        if (userDocumentsList.isEmpty()) {
            return new ResponseEntity("The user document collection is empty.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(userDocumentsList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserDocument> findUserDocumentById(@PathVariable String id) {
        UserDocument userDocumentFound = userDocumentService.findUserDocumentById(id);
        if (userDocumentFound != null) {
            return new ResponseEntity<>(userDocumentFound, HttpStatus.OK);
        }
        return new ResponseEntity("The id " + id + " it is not found in the user document collection.", HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<UserDocument> createUserDocument(@RequestBody UserDocumentDto userDocumentDto) {
        UserDocument userDocumentFound = userDocumentService.createUserDocument(userDocumentDto);
        if (userDocumentFound != null) {
            return new ResponseEntity<>(userDocumentFound, HttpStatus.CREATED);
        }
        return new ResponseEntity("The creation of the user document could not be done, due to duplicate email in the list.", HttpStatus.CONFLICT);
    }

    @PutMapping("/{id}")
    public ResponseEntity<UserDocument> updateUserDocumentById(@PathVariable String id, @RequestBody UserDocumentDto userDocumentDto) {
        UserDocument userDocumentFound = userDocumentService.updateUserDocumentById(id, userDocumentDto);
        if (userDocumentFound != null) {
            return new ResponseEntity<>(userDocumentFound, HttpStatus.OK);
        }
        return new ResponseEntity("The user document update could not be performed.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Boolean> deleteUserDocumentById(@PathVariable String id) {
        if (userDocumentService.deleteUserDocumentById(id)) {
            return new ResponseEntity("Deleted user document.", HttpStatus.OK);
        }
        return new ResponseEntity("The id " + id + " is not found in the user documents to be deleted.", HttpStatus.NOT_FOUND);
    }

    @DeleteMapping
    public ResponseEntity deleteAllUsersDocument() {
        List<UserDocument> allUsersDocuments = userDocumentService.findAllUsersDocuments();
        userDocumentService.deleteAllUsersDocument();
        if (allUsersDocuments.isEmpty()) {
            return new ResponseEntity("There is no list of user documents to delete.", HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity("Correct deletion of all user documents.", HttpStatus.OK);
    }

    @GetMapping("/findByName/{name}")
    public ResponseEntity<List<UserDocument>> findUserDocumentByName(@PathVariable String name) {
        List<UserDocument> userDocumentByNameFound = userDocumentService.findUserDocumentByName(name);
        if (userDocumentByNameFound != null) {
            return new ResponseEntity<>(userDocumentByNameFound, HttpStatus.OK);
        }
        return new ResponseEntity("The search " + name + " is not found in the user documents.", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/findByLastName/{lastName}")
    public ResponseEntity<List<UserDocument>> findUserDocumentByLastName(@PathVariable String lastName) {
        List<UserDocument> userDocumentByLastNameFound = userDocumentService.findUserDocumentByLastName(lastName);
        if (userDocumentByLastNameFound != null) {
            return new ResponseEntity<>(userDocumentByLastNameFound, HttpStatus.OK);
        }
        return new ResponseEntity("The search " + lastName + " is not found in the user documents.", HttpStatus.NOT_FOUND);
    }
}
