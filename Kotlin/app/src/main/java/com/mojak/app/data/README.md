# data

실제 데이터 출처를 다루는 영역입니다.

## 역할
- API 통신
- 로컬 저장
- Domain의 Repository 인터페이스 구현

## 하위 구조
- network: API, DTO
- local: 로컬 파일 저장, SharedPreferences, DB 등
- repository: Repository 구현체

## 예시
- ScoreRepositoryImpl.kt
- ScoreDto.kt

## 주의
- 비즈니스 규칙 자체는 domain에 두고,
  data는 데이터 입출력과 변환에 집중합니다.