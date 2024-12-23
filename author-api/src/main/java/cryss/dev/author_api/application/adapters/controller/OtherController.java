//package cryss.dev.author_api.application.adapters.controller;
//
//import cryss.dev.author_api.domain.Author;
//import cryss.dev.author_api.domain.ports.services.CreateNewAuthor;
//import jakarta.validation.Valid;
//import lombok.RequiredArgsConstructor;
//import lombok.extern.log4j.Log4j2;
//import org.springframework.http.ResponseEntity;
//import org.springframework.validation.annotation.Validated;
//import org.springframework.web.bind.annotation.RequestBody;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestMethod;
//import org.springframework.web.bind.annotation.RestController;
//
//@RestController
//@RequestMapping("/other")
//@RequiredArgsConstructor
//@Log4j2
//@Validated
//public class OtherController {
//
//        private final CreateNewAuthor createNewAuthor;
//
//    @RequestMapping(
//            method = RequestMethod.POST,
//            value = "/other",
//            produces = { "application/json" },
//            consumes = { "application/json" }
//    )
//        public ResponseEntity<Author> create(@Valid @RequestBody Author newAuthor) {
//            log.info ("message={}, method={}, request={}","Creating a new Author", "create", newAuthor );
//            return ResponseEntity.ok (newAuthor);
//        }
//    }
//
//
