package com.sugang.student.application.port.out;

public interface PasswordEncoderPort {
    // encode() 평문 비밀번호를 해시값으로 변환
    String encode(String rawPassword);
    // matches() 평문과 해시된 비밀번호를 비교(로그인 시 사용할 메서드)
    boolean matches(String rawPassword, String hashedPassword);
}
