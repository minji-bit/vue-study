package kr.co.wikibook.gallery.account.controller;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.wikibook.gallery.account.dto.AccountJoinRequest;
import kr.co.wikibook.gallery.account.dto.AccountLoginRequest;
import kr.co.wikibook.gallery.account.helper.AccountHelper;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/v1")
public class AccountController {
    private final AccountHelper accountHelper;

    @PostMapping("/api/account/join")
    public ResponseEntity<?> join(@RequestBody AccountJoinRequest accountJoinRequest) {
        if(!StringUtils.hasLength(accountJoinRequest.getName())||!StringUtils.hasLength(accountJoinRequest.getLoginId())||!StringUtils.hasLength(accountJoinRequest.getLoginPw())){
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        accountHelper.join(accountJoinRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/api/account/login")
    public ResponseEntity<?> login(HttpServletRequest req, HttpServletResponse res, @RequestBody AccountLoginRequest accountLoginRequest) {
       if(!StringUtils.hasLength(accountLoginRequest.getLoginId())||!StringUtils.hasLength(accountLoginRequest.getLoginPw())) {
           return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
       }

       String output = accountHelper.login(accountLoginRequest,req,res);

       if(output==null){
           return new ResponseEntity<>(HttpStatus.NOT_FOUND);
       }
       return new ResponseEntity<>(output,HttpStatus.OK);
    }

    @GetMapping("/api/account/check")
    public ResponseEntity<?> check(HttpServletRequest req) {
        return  new ResponseEntity<>(accountHelper.isLoggedIn(req),HttpStatus.OK);
    }

    @PostMapping("/api/account/logout")
    public ResponseEntity<?> logout(HttpServletRequest req, HttpServletResponse res) {
        accountHelper.logout(req,res);
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
