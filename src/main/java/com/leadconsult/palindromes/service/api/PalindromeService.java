package com.leadconsult.palindromes.service.api;

import com.leadconsult.palindromes.model.Palindrome;

import java.util.List;
import java.util.Set;

public interface PalindromeService {

    Set<String> processInput(String input);

    List<Palindrome> getAll();
    List<Palindrome> saveAll(Iterable<Palindrome> entities);
}
