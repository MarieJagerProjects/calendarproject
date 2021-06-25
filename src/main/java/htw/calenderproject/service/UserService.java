package htw.calenderproject.service;

import htw.calenderproject.persistence.event.EventEntity;
import htw.calenderproject.persistence.user.UserEntity;
import htw.calenderproject.persistence.user.UserRepository;
import htw.calenderproject.web.RegistrationRequest;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.sql.SQLException;
import java.util.List;
import java.util.Optional;

@Service
public class UserService implements UserDetailsService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;

    public UserService(UserRepository userRepository, BCryptPasswordEncoder bCryptPasswordEncoder) {
        this.userRepository = userRepository;
        this.bCryptPasswordEncoder = bCryptPasswordEncoder;
    }

    public void createUser(RegistrationRequest registrationRequest) {
        UserEntity userEntity = new UserEntity(
                registrationRequest.getUsername(),
                registrationRequest.getEmail(),
                bCryptPasswordEncoder.encode(registrationRequest.getPassword())
        );
        userRepository.save(userEntity);
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return userRepository
                .findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("User with name '" + username + "' not found."));
    }

    public Optional<List<EventEntity>> getAllEvents(String username) throws UsernameNotFoundException{
        Optional<List<EventEntity>> EventList = userRepository.getEventList(username);
        return EventList;
    }
}