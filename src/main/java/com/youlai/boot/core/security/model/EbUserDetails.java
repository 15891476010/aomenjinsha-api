package com.youlai.boot.core.security.model;

import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import java.util.Collection;
import java.util.Collections;

/**
 * 前端用户认证对象
 */
@Data
@NoArgsConstructor
public class EbUserDetails implements UserDetails {
    private Long userId;
    private String username;
    private String password;
    private String nickName;
    private String avatar;
    private String realName;
    private String phone;
    private Boolean enabled;
    private java.math.BigDecimal balance;
    private Collection<? extends GrantedAuthority> authorities = Collections.emptySet();

    public EbUserDetails(Long userId, String username, String password, String nickName, String avatar, String realName, String phone, Boolean enabled, java.math.BigDecimal balance) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.nickName = nickName;
        this.avatar = avatar;
        this.realName = realName;
        this.phone = phone;
        this.enabled = enabled;
        this.balance = balance;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
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
        return enabled == null ? true : enabled;
    }
} 