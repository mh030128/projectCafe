package org.jin.projectCafe.domain.user;

import jakarta.persistence.*;
import lombok.*;
import org.jin.projectCafe.common.BaseEntity;
import org.jin.projectCafe.constant.UserRole;

@Table(name = "USERS")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
@Entity
public class User extends BaseEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long userId;

    @Column(nullable = false, length = 100)
    private String userPw;

    @Column(nullable = false, length = 10)
    private String userName;

    @Column(nullable = false, length = 100, unique = true)
    private String userEmail;

    @Column(nullable = false, length = 10)
    private String userAddrPost;

    @Column(nullable = false)
    private String userAddr;

    @Column(nullable = false)
    private String userAddrDetail;

    @Column(nullable = false, length = 20)
    private String userPhone;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false, length = 10)
    private UserRole role;
}



