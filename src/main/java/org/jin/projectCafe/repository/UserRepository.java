package org.jin.projectCafe.repository;

import org.jin.projectCafe.domain.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User, Long> {

    // 이메일 중복 확인 (자동 쿼리 생성)
    boolean existsByUserEmail(String userEmail);

    // 이메일로 회원찾기
    User findByUserEmail(String userEmail);
}
