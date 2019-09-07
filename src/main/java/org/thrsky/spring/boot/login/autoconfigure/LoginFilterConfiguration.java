package org.thrsky.spring.boot.login.autoconfigure;

import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnWebApplication;
import org.springframework.context.annotation.Configuration;

/**
 * @author thrsky
 * @date 2019/8/2 11:00
 **/
@Configuration
@ConditionalOnWebApplication
@Slf4j
public class LoginFilterConfiguration {

}