package com.example.study_lab.day6;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.IOException;

// 데이터를 저장ㅎ나는 척하는 서비스. 2 종류 에러 일부러 터뜨림.
@Service
public class TxService {

    // 1 : 런타임 예외 발생 (Unchecked Exception)
    @Transactional
    public void errorRuntime(){
        System.out.println("== [로직 1] 데이터 저장 중... (RuntimeException 발생 예정)");
        // ex : zero divide, NullPointer..
        throw new RuntimeException(" 런타임 이셉션 발생");
    }

    // 2 : 체크 예외 발생 (Checked Exception) - throw IOException이 필수인 예외 ( File I/O..)
    @Transactional
    public void errorChecked() throws IOException{
        System.out.println("== [로직 2] 데이터 저장 중... (IOException 발생 예정)");
        throw new IOException(" 체크 이셉션 발생");
    }

}
