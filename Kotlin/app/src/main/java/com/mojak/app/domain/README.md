# domain

앱의 핵심 비즈니스 규칙을 담당하는 영역입니다.

## 역할
- Entity
- Repository 인터페이스
- UseCase

## 하위 구조
- entity: 순수 데이터 모델
- repository: 추상화된 저장소 인터페이스
- usecase: 핵심 비즈니스 로직

## 예시
- Score.kt
- ScoreRepository.kt
- SaveScoreUseCase.kt

## 주의
- Android UI, Retrofit 등 외부 구현 기술에 최대한 의존하지 않도록 설계합니다.