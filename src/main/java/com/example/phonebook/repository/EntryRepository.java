package com.example.phonebook.repository;

import com.example.phonebook.model.dto.EntryDTO;
import com.example.phonebook.model.entity.Entry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface EntryRepository extends JpaRepository<Entry,Long>, JpaSpecificationExecutor<Entry> {

}
