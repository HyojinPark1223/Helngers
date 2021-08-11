//package com.ssafy.hellingers.security;
//
//import com.ssafy.hellingers.model.User;
//import com.ssafy.hellingers.repository.UserRepository;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.core.GrantedAuthority;
//import org.springframework.security.core.authority.SimpleGrantedAuthority;
//import org.springframework.security.core.userdetails.UserDetails;
//import org.springframework.security.core.userdetails.UserDetailsService;
//import org.springframework.security.core.userdetails.UsernameNotFoundException;
//import org.springframework.stereotype.Service;
//
//import java.util.HashSet;
//import java.util.Set;
//
//
//@Service
//public class UserDetailServiceImpl implements UserDetailsService
//{
//    @Autowired
//    private UserRepository userRepository;
//
//    //권한 부여 요청은 필터에 의해 처리되고 현재 사용자는 나머지 컨트롤러 전에 여기에서 확인됩니다.
//    @Override
//    public UserDetails loadUserByUsername(String nickname) throws UsernameNotFoundException
//    {
//        User user = userRepository.findByNickname(nickname).orElseThrow(() -> new UsernameNotFoundException(nickname));
//
//        //인증받은 역할
//        Set<GrantedAuthority> grantedAuthorities = new HashSet<>();
//        grantedAuthorities.add(new SimpleGrantedAuthority(user.getRole().name()));
//
//        return new org.springframework.security.core.userdetails.User(nickname, user.getPassword(), grantedAuthorities);
//    }
//}
