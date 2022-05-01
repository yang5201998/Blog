package com.blog.system;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import com.blog.common.security.annotation.EnableCustomConfig;
import com.blog.common.security.annotation.EnableRyFeignClients;
import com.blog.common.swagger.annotation.EnableCustomSwagger2;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.openfeign.EnableFeignClients;

/**
 * 系统模块
 *
 * @author blog
 */
@EnableCustomConfig
@EnableCustomSwagger2
@EnableRyFeignClients
@EnableFeignClients
@EnableDiscoveryClient
@SpringBootApplication
@MapperScan("com.blog.**.mapper")
public class BlogSystemApplication
{
    public static void main(String[] args)
    {
        SpringApplication.run(BlogSystemApplication.class, args);
        System.out.println("(♥◠‿◠)ﾉﾞ  系统模块启动成功   ლ(´ڡ`ლ)ﾞ  \n" +
                " .-------.       ____     __        \n" +
                " |  _ _   \\      \\   \\   /  /    \n" +
                " | ( ' )  |       \\  _. /  '       \n" +
                " |(_ o _) /        _( )_ .'         \n" +
                " | (_,_).' __  ___(_ o _)'          \n" +
                " |  |\\ \\  |  ||   |(_,_)'         \n" +
                " |  | \\ `'   /|   `-'  /           \n" +
                " |  |  \\    /  \\      /           \n" +
                " ''-'   `'-'    `-..-'              ");
    }
}
