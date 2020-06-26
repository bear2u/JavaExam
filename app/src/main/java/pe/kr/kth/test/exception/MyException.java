package pe.kr.kth.test.exception;

import androidx.annotation.Nullable;

public class MyException extends Exception {
    public MyException(String message) {
        super(message);
    }

    @Nullable
    @Override
    public String getMessage() {
        return "마이 에러 : " + super.getMessage();
    }
}
