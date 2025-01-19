package com.wpl.tomarkdownserver;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.Environment;
import org.springframework.util.StringUtils;

import java.net.InetAddress;
import java.net.UnknownHostException;

@SpringBootApplication
@MapperScan(basePackages = {"com.wpl.tomarkdownserver.**.mapper"})
public class ToMkServerApplication {

    public static void main(String[] args) throws UnknownHostException {

        ConfigurableApplicationContext application = SpringApplication.run(ToMkServerApplication.class, args);
        Environment env = application.getEnvironment();
        String ip = InetAddress.getLocalHost().getHostAddress();
        String port = env.getProperty("server.port");
        String active = env.getProperty("spring.profiles.active");
        String path = env.getProperty("server.servlet.context-path");
        path = StringUtils.hasText(path) ? path : "";

        if ("h2".equals(active)) {
            System.out.println("\n----------------------------------------------------------\n\t" +
                    "application is running! Access URLs:\n\t" +
                    "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                    "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                    "h2: \thttp://" + ip + ":" + port + path + "/h2-console\n\t" +
                    "抓取页面: \thttp://" + ip + ":" + port + path +"/\n\t" +
                    "----------------------------------------------------------");
        }else {
            System.out.println("\n----------------------------------------------------------\n\t" +
                    "application is running! Access URLs:\n\t" +
                    "Local: \t\thttp://localhost:" + port + path + "/\n\t" +
                    "External: \thttp://" + ip + ":" + port + path + "/\n\t" +
                    "抓取页面: \thttp://" + ip + ":" + port + path +"/\n\t" +
                    "----------------------------------------------------------");
        }
    }

}
