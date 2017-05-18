package com.spring.tryout;

import com.spring.tryout.configuration.CalculatorConfiguration;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import java.util.HashMap;
import java.util.Map;

@SpringBootApplication
@RestController
@RibbonClient(name="Calculator", configuration = CalculatorConfiguration.class)
public class Application {

	private static final Logger log = LoggerFactory.getLogger(Application.class);

	@Autowired
	RestTemplate restTemplate;

	public static void main(String args[]) {
		SpringApplication.run(Application.class);
	}

	@Bean
    @LoadBalanced
	public RestTemplate restTemplate(RestTemplateBuilder builder) {
		return builder.build();
	}

    @RequestMapping("/math")
    public Long math(@RequestParam(value="opr1") Long opr1,
                         @RequestParam(value="opr2") Long opr2) {

	    Map<String,Object> params = new HashMap<String,Object>();

	    params.put("opr1",opr1);
	    params.put("opr2",opr2);

        Long res = restTemplate.getForObject(
                "http://math-service/multiply?opr1="+opr1+"&opr2="+opr2,Long.class);

        return  res;
    }


    /*

    @Bean
	public CommandLineRunner run(RestTemplate restTemplate) throws Exception {
		return args -> {
			Long res = restTemplate.getForObject(
					"http://localhost:8090/multiply?opr1=5&opr2=25",Long.class);
  			log.info("The result=" + res);
		};
	}*/



    public class MathResult
    {
        private Long result;
        private String Operation;












    }

}