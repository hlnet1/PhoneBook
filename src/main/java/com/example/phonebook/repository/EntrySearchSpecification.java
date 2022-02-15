package com.example.phonebook.repository;

import com.example.phonebook.model.entity.Contact;
import com.example.phonebook.model.entity.Entry;
import com.example.phonebook.model.entity.enums.TypeEnum;
import org.springframework.data.jpa.domain.Specification;

import javax.persistence.criteria.*;

public class EntrySearchSpecification implements Specification<Entry> {


    private final String firstName;
    private final String lastName;
    private final TypeEnum contactType;



    public EntrySearchSpecification(String firstName, String lastName, TypeEnum contactType) {
        this.firstName = firstName;

        this.lastName = lastName;
        this.contactType = contactType;
    }

    @Override
    public Predicate toPredicate(
            Root<Entry> root,
            CriteriaQuery<?> query,
            CriteriaBuilder cb) {
        Predicate p=cb.conjunction();
      if(firstName!=null){
          p.getExpressions().add(cb.and(cb.equal(root.get("firstName"),firstName)));
      }
      else if (lastName!=null){
          p.getExpressions().add(cb.and(cb.equal(root.get("lastName"),lastName)));


      }
        if(contactType!=null){
            Subquery<Contact> contactSubquery=query.subquery(Contact.class);
            Root<Contact> subqueryRoot=contactSubquery.from(Contact.class);

            contactSubquery.where(cb.and
                    (cb.equal(root,subqueryRoot.get("entry")),
                            cb.equal(subqueryRoot.get("type"),contactType)));
            p.getExpressions().add(cb.exists(contactSubquery));

        }
        return p;
    }

}
