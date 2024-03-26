package ru.real.backend.domain.model.user;

import lombok.*;
import org.springframework.security.core.userdetails.UserDetails;
import ru.real.backend.core.model.BaseEntity;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.ZonedDateTime;
import java.util.List;

/**
 * Пользователь
 */
@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity(name = "SEC_USER")
public class User extends BaseEntity implements UserDetails {
    /**
     * Логин
     */
    @Column(name = "USERNAME")
    private String username;

    /**
     * Пароль
     */
    @Column(name = "PASSWORD")
    private String password;

    /**
     * Почта
     */
    @Column(name = "EMAIL")
    private String email;

    /**
     * Фамилия
     */
    @Column(name = "SURNAME")
    private String surname;

    /**
     * Имя
     */
    @Column(name = "NAME")
    private String name;

    /**
     * Отчество
     */
    @Column(name = "PATRONYMIC")
    private String patronymic;

    /**
     * Номер телефона
     */
    @Column(name = "PHONE")
    private String phone;

    /**
     * Дата и время создания пользователя
     */
    @Column(name = "DATE_OF_BIRTH")
    private LocalDate dateOfBirth;

    /**
     * Дата и время создания пользователя
     */
    @Column(name = "DATE_TIME_CREATED")
    private ZonedDateTime dateTimeCreated;

    @ToString.Exclude
    @ManyToMany(fetch = FetchType.EAGER)
    @JoinTable(name = "SEC_USER_AUTHORITY",
            joinColumns = @JoinColumn(name = "USER_ID", referencedColumnName = "ID", nullable = false),
            inverseJoinColumns = @JoinColumn(name = "AUTHORITY_ID", referencedColumnName = "ID", nullable = false))
    private List<Authority> authorities;

    /**
     * Проверяет срок действия учетной записи
     *
     * @return true - если срок действия учетной записи не истек, false - в ином случае
     */
    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    /**
     * Проверяет заблокирована ли учетная запись
     *
     * @return true - если учетная запись не заблокированной, false - в ином случае
     */
    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    /**
     * Проверяет срок действия учетных данных
     *
     * @return true - если срок действия учетных данных не истек, false - в ином случае
     */
    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    /**
     * Проверяет включена ли учётная запись
     *
     * @return true - если учётная запись включена, false - в ином случае
     */
    @Override
    public boolean isEnabled() {
        return true;
    }
}
