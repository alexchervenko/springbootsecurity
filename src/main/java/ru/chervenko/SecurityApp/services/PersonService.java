package ru.chervenko.SecurityApp.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import ru.chervenko.SecurityApp.models.Person;
import ru.chervenko.SecurityApp.repositories.PersonRepository;

@Service
public class PersonService {
    public final PersonRepository personRepository;
    public final PasswordEncoder passwordEncoder;

    @Autowired
    public PersonService(PersonRepository personRepository, PasswordEncoder passwordEncoder) {
        this.personRepository = personRepository;
        this.passwordEncoder = passwordEncoder;
    }

    public void createUser(Person person) {
        personRepository.save(new Person(person.getName(),
                passwordEncoder.encode(person.getPassword()), "ROLE_USER"));
    }
}
