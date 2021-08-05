package com.ssafy.hellingers.controller;

import com.ssafy.hellingers.model.Account;
import com.ssafy.hellingers.model.Challenge;
import com.ssafy.hellingers.service.AccountService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("accounts")
public class AccountController {

    @Autowired
    AccountService accountService;

    @GetMapping("/list")
    public ResponseEntity<List<Account>> printAll(){
        List<Account> list = accountService.selectAll();

        System.out.println("유저 컨트롤러 호출");

        if(list != null && !list.isEmpty()){
            return new ResponseEntity<List<Account>>(list, HttpStatus.OK);
        }else {
            System.out.println("컨텐츠가 없습니다!");
            return new ResponseEntity(HttpStatus.NO_CONTENT);
        }
    }
}