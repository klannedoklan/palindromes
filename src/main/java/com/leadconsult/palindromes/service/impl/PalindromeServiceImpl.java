package com.leadconsult.palindromes.service.impl;

import com.leadconsult.palindromes.model.Palindrome;
import com.leadconsult.palindromes.repository.PalindromeRepository;
import com.leadconsult.palindromes.service.api.PalindromeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class PalindromeServiceImpl implements PalindromeService {

    @Autowired
    private PalindromeRepository repository;

    @Override
    public Set<String> processInput(String input){
        Set<String> result = new HashSet<>();
        for (int i = 0; i < input.length(); i++) {
            // expanding even length palindromes:
            expandPalindromes(result,input,i,i+1);
            // expanding odd length palindromes:
            expandPalindromes(result,input,i,i);
        }
        return result;
    }


    @Override
    public List<Palindrome> getAll() {
        return repository.findAll();
    }

    @Override
    public List<Palindrome> saveAll(Iterable<Palindrome> entities) {
        return repository.saveAll(entities);
    }

    private void expandPalindromes(Set<String> result, String s, int i, int j) {
        while (i >= 0 && j < s.length() && s.charAt(i) == s.charAt(j)) {
            result.add(s.substring(i,j+1));
            i--; j++;
        }
    }
}
