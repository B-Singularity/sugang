package com.sugang.course.domain.vo;


import jakarta.persistence.Embeddable;
import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Embeddable
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
public class Quota {

  private int capacity;
  private int registeredCount;

  public Quota(int capacity, int registeredCount) {
    if (capacity < 0) {
      throw new IllegalArgumentException("총 정원은 음수일 수 없습니다.");
    }
    if (registeredCount < 0) {
      throw new IllegalArgumentException("신청 인원은 음수일 수 없습니다.");
    }
    if (registeredCount > capacity) {
      throw new IllegalArgumentException("신청 인원이 총 정원을 초과할 수 없습니다.");
    }

    this.capacity = capacity;
    this.registeredCount = registeredCount;
  }
  public boolean isFullToRegister() {
    return registeredCount >= capacity;
  }

  public boolean isAvailableToRegister() {
    return !isFullToRegister();
  }

  public Quota increaseRegisteredCount() {
    if (isFullToRegister()) {
      throw new IllegalArgumentException("정원이 마감되어 신청 인원을 늘릴 수 없습니다.");
    }
    return new Quota(this.capacity, this.registeredCount + 1);
  }

  public Quota decreaseRegisteredCount() {
    if (this.registeredCount <= 0) {
      throw new IllegalStateException("신청 인원이 0명이라 취소할 수 없습니다.");
    }
    return new Quota(this.capacity, this.registeredCount - 1);
  }
}

