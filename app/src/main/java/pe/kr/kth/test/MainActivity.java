package pe.kr.kth.test;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import pe.kr.kth.test.enums.LoginStatus;
import pe.kr.kth.test.exception.LoginException;

public class MainActivity extends AppCompatActivity {

    int count = 0;
    String expectedId = "test";
    String expectedPwd = "1234";

    EditText etId, etPwd;

    LoginStatus status;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // setContentView는 화면을 그릴때 뷰를 지정하는 것
        setContentView(R.layout.activity_main);

        etId = findViewById(R.id.etId);
        etPwd = findViewById(R.id.etPwd);
        //이벤트를 만들려고 하면
        //1. 버튼을 넣는다.
        Button btn = findViewById(R.id.btnLogin);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               String id = etId.getText().toString();
               String pwd = etPwd.getText().toString();

               try {
                   if (id.equals(expectedId) && pwd.equals(expectedPwd)) {
                       Toast.makeText(MainActivity.this, "로그인 성공", Toast.LENGTH_SHORT).show();
                       status = LoginStatus.SUCCESS;
                   } else {
                       if(!id.equals(expectedId)) {
                           status = LoginStatus.ID_ERROR;
                           throw new LoginException(LoginStatus.ID_ERROR);
                       }
                       if(!pwd.equals(expectedPwd)) {
                           status = LoginStatus.PWD_ERROR;
                           throw new LoginException(LoginStatus.PWD_ERROR);
                       }
                   }
               } catch (Exception e) {
                   Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_SHORT).show();
               } finally {
                   Log.d("TEST", "current status => " + status);
               }
            }
        });


    }

}
