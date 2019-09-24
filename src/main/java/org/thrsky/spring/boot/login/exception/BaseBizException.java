package org.thrsky.spring.boot.login.exception;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 18:36 2019-08-04
 */
@AllArgsConstructor
@Data
public class BaseBizException extends RuntimeException {

    private static final long serialVersionUID = -5790887416716837948L;

    private String errorMessage;

}
