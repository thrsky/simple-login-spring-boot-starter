package org.thrsky.spring.boot.login.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.thrsky.spring.boot.login.utils.AssertUtils;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 20:12 2019-08-01
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class UserModel {

    private Long userId;

    private String userName;

    private String userPasswd;

    public static UserModel build(String userName, String userPasswd) {
        return UserModel.builder()
                .userName(userName)
                .userPasswd(userPasswd)
                .build();
    }

    public void check() {
        AssertUtils.notBlank(this.userName, "用户名不能为空");
        AssertUtils.notBlank(this.userPasswd, "密码不能为空");
    }
}
