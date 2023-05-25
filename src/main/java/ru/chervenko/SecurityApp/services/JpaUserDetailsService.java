package ru.chervenko.SecurityApp.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import ru.chervenko.SecurityApp.models.SecurityUser;
import ru.chervenko.SecurityApp.repositories.PersonRepository;

@Service
public class JpaUserDetailsService implements UserDetailsService {

    private final PersonRepository personRepository;

    public JpaUserDetailsService(PersonRepository personRepository) {
        this.personRepository = personRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return personRepository
                .findPersonByName(username)
                .map(SecurityUser::new) //map((Person) -> new SecurityUser(Person))
                .orElseThrow(() -> new UsernameNotFoundException("Username " + username + " not found"));
    }

}
