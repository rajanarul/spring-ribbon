package com.spring.tryout.controller;


import java.util.concurrent.atomic.AtomicLong;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by  on 5/6/17.
 */


@RestController
public class AdderController
{


    @RequestMapping("/add")
    public Long multiply(@RequestParam(value="opr1") Long opr1,
                         @RequestParam(value="opr2") Long opr2) {
        return  opr1 + opr2;
    }
}

