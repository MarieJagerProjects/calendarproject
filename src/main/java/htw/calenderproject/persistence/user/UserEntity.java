package htw.calenderproject.persistence.user;

import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;

public class UserEntity {
    @Entity
    @Table(name = "users")
    public class UserEntity implements UserDetails {

        @Id
        @GeneratedValue(strategy = GenerationType.IDENTITY)
        @Column(name = "id")
        private long id;

        @Column(name = "username", nullable = false, unique = true)
        private String username;

        @Column(name = "email")
        private String email;

        @Column(name = "encrypted_password", nullable = false, length = 60)
        private String password;

    }
