package org.thrsky.spring.boot.login.model;

import lombok.*;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 10:38 2019-08-03
 */
@EqualsAndHashCode(callSuper = true)
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RestApiResult<T> extends Result<T> {

    private boolean success;

    private String errorCode;

    private String errorMsg;

    public static <T> RestApiResult<T> success(T data) {
        RestApiResult<T> restApiResult = new RestApiResult<>();
        restApiResult.setData(data);
        restApiResult.setSuccess(true);
        return restApiResult;
    }

    public static <T> RestApiResult<T> fail(String errorMsg) {
        RestApiResult<T> restApiResult = new RestApiResult<>();
        restApiResult.setErrorMsg(errorMsg);
        restApiResult.setSuccess(false);
        return restApiResult;
    }
}
