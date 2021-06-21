package htw.calenderproject.persistence.user;

import htw.calenderproject.persistence.event.EventEntity;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import javax.persistence.*;
import java.util.Collection;
import java.util.List;

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
        private String encryptedPassword;

        @OneToMany(mappedBy = "username")
        private List<EventEntity> events;

        protected UserEntity() {}

        public UserEntity(String username, String email, String encryptedPassword) {
            this.username = username;
            this.email = email;
            this.encryptedPassword = encryptedPassword;
        }

        @Override
        public Collection<? extends GrantedAuthority> getAuthorities() {
            return null;
        }

        @Override
        public String getPassword() {
            return encryptedPassword;
        }
        @Override
        public String getUsername() {
            return username;
        }

        @Override
        public boolean isAccountNonExpired() {
            return true;
        }

        @Override
        public boolean isAccountNonLocked() {
            return true;
        }

        @Override
        public boolean isCredentialsNonExpired() {
            return true;
        }

        @Override
        public boolean isEnabled() {
            return true;
        }

        public List getEventList() {
            return events;
        }

    }
