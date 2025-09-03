package org.jin.projectCafe.service.user;

import org.jin.projectCafe.constant.UserRole;
import org.jin.projectCafe.domain.user.User;
import org.jin.projectCafe.repository.UserRepository;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
/*@RequiredArgsConstructor
@Transactional*/
public class UserService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = new BCryptPasswordEncoder();
    }

    // 1. 회원가입
    @Transactional
    public void registerUser(User user) {

        // 이메일 중복 체크
        if (userRepository.existsByUserEmail(user.getUserEmail())) {
            throw new IllegalStateException("이미 존재하는 이메일입니다.");
        }

        //validateDuplicationUser(user);

        // 비밀번호 암호화
        user.setUserPw(passwordEncoder.encode(user.getUserPw()));

        // 기본 권한 설정
        user.setRole(UserRole.USER);

        // DB 저장
        userRepository.save(user);
    }

    /*// 2. 이메일 중복 확인
    private void validateDuplicationUser(User user) {
        User findUser = userRepository.findByUserEmail(user.getUserEmail());
        if(findUser != null) {
            throw new IllegalStateException("이미 가입된 회원입니다.");
        }
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        return null;
    }*/
}

