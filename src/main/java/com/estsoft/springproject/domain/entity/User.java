package com.estsoft.springproject.domain.entity;

import jakarta.persistence.*;
import lombok.AccessLevel;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Table(name = "users")
@Getter
@Entity
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id", updatable = false)
    private Long id;

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nickname", nullable = false)
    private String nickname;

    @JsonManagedReference
    @OneToMany(mappedBy = "user" , cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Board> boards = new ArrayList<>();

    @JsonManagedReference
    @OneToMany(mappedBy = "user", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Comment> comments = new ArrayList<>();

    @Builder
    public User(String email, String password, String nickname, String auth) {
        this.email = email;
        this.password = password;
        this.nickname = nickname;
    }
    public void update(String email,String nickname,String password){
        this.email=email;
        this.nickname=nickname;
        this.password=password;
    }

//    @Override
//    public Collection<? extends GrantedAuthority> getAuthorities() {
//        return List.of(new SimpleGrantedAuthority("user"));
//    }
//
//    @Override
//    public String getUsername() {
//        return email;
//    }
//
//    @Override
//    public String getPassword() {
//        return password;
//    }
//
//    // 계정 만료 여부 반환 (true: 만료 안됨)
//    @Override
//    public boolean isAccountNonExpired() {
//        return true;
//    }
//
//    // 계정 잠금 여부 반환 (true: 잠금 안됨)
//    @Override
//    public boolean isAccountNonLocked() {
//        return true;
//    }
//
//    // 패스워드의 만료 여부 반환 (true: 만료 안됨)
//    @Override
//    public boolean isCredentialsNonExpired() {
//        return true;
//    }
//
//    // 계정 사용 여부 반환 (true: 사용 가능)
//    @Override
//    public boolean isEnabled() {
//        return true;
//    }
}