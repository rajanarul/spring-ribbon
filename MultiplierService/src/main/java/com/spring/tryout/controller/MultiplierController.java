package com.spring.tryout.controller;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  on 5/6/17.
 */


@RestController
public class MultiplierController
{


    @RequestMapping("/multiply")
    public Long multiply(@RequestParam(value="opr1") Long opr1,
                         @RequestParam(value="opr2") Long opr2) {
        Long res = opr1 * opr2;

        System.out.println("Processing Request - Result=" + res );
        return  res;
    }
}

