package kr.co.wikibook.gallery.common.interceptor;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import kr.co.wikibook.gallery.account.helper.AccountHelper;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;
@Component
public class ApiInterceptor implements HandlerInterceptor {
    private final AccountHelper accountHelper;

    public ApiInterceptor(AccountHelper accountHelper) {
        this.accountHelper = accountHelper;
    }

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        //로그인 회원 아이디가 없으면
        if(accountHelper.getMemberId(request)==null){
            response.setStatus(401);
            return false;
        }
        return true;
    }
}
