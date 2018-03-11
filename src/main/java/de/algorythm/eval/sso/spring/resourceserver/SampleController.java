package de.algorythm.eval.sso.spring.resourceserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.security.Principal;

@Controller
@SpringBootApplication
@EnableAutoConfiguration
@EnableConfigurationProperties()
@ComponentScan
public class SampleController {

    /*@RequestMapping("/")
    @ResponseBody
    String home() {
		return "Hello World!";
	}*/

    @GetMapping("/user")
    @ResponseBody
    public Principal user(Principal principal) {
        return principal;
    }

    @PreAuthorize("#oauth2.hasScope('read')")
    @GetMapping("/premium/{id}")
    @ResponseBody
    public String premiumContent(Principal principal, @PathVariable String id) {
        return "some premium content" + (principal == null ? "" : " for " + principal.getName());
    }

    public static void main(String[] args) {
        SpringApplication.run(SampleController.class, args);
    }
}
