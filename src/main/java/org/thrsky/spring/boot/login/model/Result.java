package org.thrsky.spring.boot.login.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 10:38 2019-08-03
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result<T> {

    T data;

    public static <T> Result<T> build(T data) {
        return new Result<>(data);
    }
}
