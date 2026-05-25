# presentation

사용자가 직접 보는 화면과 화면 상태를 담당하는 영역입니다.

## 역할
- Compose Screen
- ViewModel
- UI State / Event

## 구조 방식
- feature-based 구조를 사용합니다.

## 하위 기능
- auth
- scorelist
- scoresetup
- composition
- settings

## 주의
- View는 UI 표현에 집중하고,
- 상태와 로직 처리는 ViewModel을 통해 수행합니다.