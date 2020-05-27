package com.leadconsult.palindromes.repository;

import com.leadconsult.palindromes.model.Palindrome;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PalindromeRepository extends JpaRepository<Palindrome,Long> {

}
