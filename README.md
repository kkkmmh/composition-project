# composition-project

---

## branch 컨벤션

```
master → hotfix
   ↓
develop (default)
   ↓           ↓
feature        fix
```

> 브랜치 네이밍 : 작업유형/기능명(케밥케이스)
>
> ```
> feat/login-page
> feat/composition-page
> fix/login-page
> hotfix/login-page
> ```
>
> ※ 추후 지라 등 업데이트 시 양식 변경 가능

**고려할 점**

- release 사용 여부
- 브랜치 보호 전략
- BE, KOTLIN, SWIFT 별 git을 따로 만들지

---

## merge 컨벤션

---

## commit message 컨벤션

```
타입: 제목

내용
```

### 1. 타입

| 분류 | 타입 | 설명 |
|------|------|------|
| 기능 | `feat` | 기능 추가 |
| | `fix` | 오류 수정 |
| | `design` | 디자인 수정 |
| 개선 | `style` | 코드 포맷팅 |
| | `refact` | 코드 리팩토링 |
| | `comment` | 주석 등 문구 수정 |
| 기타 | `docs` | 문서 수정 |
| | `chore` | 빌드 작업 등 |
| | `rename` | 파일·폴더 이름 수정 |
| | `remove` | 파일·폴더 삭제 |

### 2. 제목

- 한글로 작성
- 개조식 구문 (서술형 작성 X)
- 마침표 및 특수기호 사용 X
- 최대한 간결하고 가독성 좋게

### 3. 내용

- How 보다 **What + Why** 중심으로 작성
- 고려 중인 작성 방식
  1. 목록화
     ```
     - 내용1
     - 내용2
     - 내용3
     ```
  2. 문장화
     ```
     @@@한 이슈로 인한 @@@ 작업 진행하였으며 $$$기능 추가를 위한 백엔드 개발 추후 개선 예정
     ```
