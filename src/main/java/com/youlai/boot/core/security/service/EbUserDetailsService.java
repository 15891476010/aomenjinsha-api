package com.youlai.boot.core.security.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.youlai.boot.core.security.model.EbUserDetails;
import com.youlai.boot.index.model.entity.EbUser;
import com.youlai.boot.index.mapper.EbUserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class EbUserDetailsService implements UserDetailsService {
    private final EbUserMapper ebUserMapper;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        EbUser user = ebUserMapper.selectOne(new LambdaQueryWrapper<EbUser>().eq(EbUser::getUsername, username));
        if (user == null) {
            throw new UsernameNotFoundException("前端用户不存在");
        }
        return new EbUserDetails(
                user.getId(),
                user.getUsername(),
                user.getPassword(),
                user.getNickName(),
                user.getAvatar(),
                user.getRealName(),
                user.getPhone(),
                user.getStatus(),
                user.getBalance()
        );
    }
} 