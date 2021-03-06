package com.leadconsult.palindromes.controller;

import com.leadconsult.palindromes.model.Palindrome;
import com.leadconsult.palindromes.service.api.PalindromeService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.SwaggerDefinition;
import io.swagger.annotations.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;

@Api(value = "PalindromeController" , tags = {"Palindrome Controller"})
@SwaggerDefinition(tags = {
        @Tag(name = "Palindrome Controller", description = "Finds all palindromes in a given string")
})

@RestController
@RequestMapping("/palindromes")
public class PalindromeController {

    @Autowired
    private PalindromeService service;

    @ApiOperation("List of all palindromes")
    @GetMapping("/getAll")
    public ResponseEntity<Collection<Palindrome>> getPalindromes(){
        List<Palindrome> palindromes = service.getAll();
        ResponseEntity<Collection<Palindrome>> responseEntity;
        if(palindromes.isEmpty()){
            responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            responseEntity = ResponseEntity.ok(palindromes);
        }
        return responseEntity;
    }

    @ApiOperation("Searches for all palindromes with size > 1 in a given string and saves them")
    @PostMapping("/processPalindromes")
    public ResponseEntity<Collection<Palindrome>> processPalindromes(@RequestBody String input){
        Set<String> uniquePalindromes = service.processInput(input);
        ResponseEntity<Collection<Palindrome>> responseEntity;
        if (uniquePalindromes.isEmpty()){
            responseEntity = ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        } else {
            Set<Palindrome> palindromes = uniquePalindromes.stream()
                    .filter(s -> s.length() > 1)
                    .map(Palindrome::new).collect(Collectors.toSet());
            service.saveAll(palindromes);
            responseEntity = ResponseEntity.ok(palindromes);
        }
        return responseEntity;
    }
}
