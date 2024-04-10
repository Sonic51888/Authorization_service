package ru.netology.authorizationservice.repository;

import org.springframework.stereotype.Repository;
import ru.netology.authorizationservice.model.Authorities;
import ru.netology.authorizationservice.model.User;

import java.util.*;
import java.util.stream.Collectors;

@Repository
public class UserRepository {
    private final Set<User> usersList = new HashSet<>();

    public List<Authorities> getUserAuthorities(String user, String password) {
        testAddUser();
        Optional<User> currentUser = usersList.stream()
                .filter(x -> x.getUser().equals(user) && x.getPassword().equals(password))
                .collect(Collectors.toCollection(ArrayList::new))
                .stream().findFirst();
        return currentUser.orElse(new User("userEmpty", "passwordEmpty")).getAuthoritiesList();
    }

    public void testAddUser() {
        User testUser = new User("userTest", "passwordTest");
        testUser.setAuthoritiesList(List.of(Authorities.READ, Authorities.DELETE));
        usersList.add(testUser);
    }
}