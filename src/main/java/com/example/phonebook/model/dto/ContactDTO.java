package com.example.phonebook.model.dto;

import com.example.phonebook.model.entity.enums.TypeEnum;

public class ContactDTO {
    private Long id;
    private String phoneNumber;
    private TypeEnum type;
    private EntryDTO entryDTO;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNumber() {
        return phoneNumber;
    }

    public void setNumber(String number) {
        this.phoneNumber = number;
    }

    public TypeEnum getType() {
        return type;
    }

    public void setType(TypeEnum type) {
        this.type = type;
    }

    public EntryDTO getEntryDTO() {
        return entryDTO;
    }

    public void setEntryDTO(EntryDTO entryDTO) {
        this.entryDTO = entryDTO;
    }


}
