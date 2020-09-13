package zh;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;

/**
 * @author Beloved
 * @date 2020/9/13 17:50
 */
@SpringBootApplication
@EnableEurekaClient
@EnableFeignClients(basePackages = {"com.zh"}) // 扫描Feign的service的包
public class FeignDeptConsumer_8080 {

    public static void main(String[] args) {
        SpringApplication.run(FeignDeptConsumer_8080.class,args);
    }

}
