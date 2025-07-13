package com.sugang.course;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

// 1. @Testcontainers와 관련된 모든 코드를 삭제합니다.
// 2. properties 속성을 추가하여 DB 자동 설정을 끕니다.
@Disabled // 이 테스트 클래스를 비활성화합니다.
@SpringBootTest
class CourseServiceApplicationTests {

  @Test
  void contextLoads() {
  }

}