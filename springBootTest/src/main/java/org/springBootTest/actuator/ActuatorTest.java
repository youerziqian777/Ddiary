package org.springBootTest.actuator;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description 监视器，简单示例
 * 访问http://localhost:8080/actuator/actuatorTest
 * @Date 2023/2/23 15:33
 **/
@RestController
@Endpoint(id="actuatorTest")
public class ActuatorTest {

    @ReadOperation
    public String actuatorTest(){
        return "This is a custom endpoint";
    }
}
