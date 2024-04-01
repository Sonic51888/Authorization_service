package ru.netology.authorizationservice.repository;
import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.model.User;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;
@Repository
public class UserRepository {
    private Set<User> usersList = new HashSet<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        testAddUser();
        Optional<User> currentUser = usersList.stream()
                .filter(x -> x.getUserName().equals(user) && x.getPassword().equals(password))
                .collect(Collectors.toCollection(ArrayList::new))
                .stream().findFirst();
        return currentUser.orElse(new User("userEmpty", "passwordEmpty", null)).getAuthoritiesList();
    }

    public void testAddUser() {
        usersList.add(new User("userTest", "passwordTest", Stream.of(Authorities.READ, Authorities.WRITE).toList()));
    }
}