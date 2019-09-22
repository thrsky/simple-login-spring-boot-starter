package org.thrsky.spring.boot.login.spi;

import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * @author thrsky
 * @version 1.0.0
 * @date Created in 12:40 2019-09-22
 */
@Data
@AllArgsConstructor
public class Holder<T> {

    T object;
}
