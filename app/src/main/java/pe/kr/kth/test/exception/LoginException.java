package pe.kr.kth.test.exception;

import pe.kr.kth.test.enums.LoginStatus;

//로그인만 관리하는 예외처리 클래스
public class LoginException extends Exception {
    public LoginException(LoginStatus status) {
//        String message = "";
//        switch (status) {
//            case LoginStatus.ID_ERROR.toString():
//                message = "로그인 에러";
//                break;
//        }
        super(status.toString());
    }
}
