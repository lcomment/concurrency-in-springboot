# 스프링부트에서의 동시성 처리

## 1. synchronized

- 해당 메서드에 한 개의 thread만 접근 가능하게 해줌
- 서버가 2개 이상일 때는 Race Condition이 발생할 수 있음

## 2. DB의 Lock 사용하기
