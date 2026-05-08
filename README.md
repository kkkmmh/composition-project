# composition-project

## branch 컨벤션

   master → hotfix
      ↓
   develop (default)
    ↓        ↓
 feature    fix

> 브렌치 네이밍 : 작업유형/기능유형(케밥케이스)
  ex) feat/login-page
      feat/composition-page
      fix/login-page
      hotfix/login-page

  ※ 추후 지라 등 업데이트 되는 상황에 따라 양식 변경 가능

> 고려할 점
  1. release 사용 여부
  2. 브렌치 보호 전략
  3. BE, KOTLIN, SWIFT 별 git을 따로 만들지
    

## merge 컨벤션

## commit message 컨벤션

================================
  타입: 제목
  내용
================================

1. 타입
   - 기능
     > feat : 기능추가
     > fix : 오류수정
     > design : 디자인수정
     
   - 개선
     > style : 코드포맷팅
     > refact : 코드리팩토링
     > comment : 주석등 문구 수정
     
   - 기타
     > docs : 문서수정
     > chore : 빌드 작업 등
     > rename : 파일, 폴더 이름 수정
     > remove : 파일, 폴더 삭제
     
2. 제목
   - 한글로 작성
   - 개조식 구문 (서술형 작성 X)
   - 마침표 및 특수기호 사용 X
   - 최대한 간결하고 가독성 좋게 내용 설명

3. 내용
   - How (어떻게 수정했는지) 보다 What(무엇을 수정했는지) Why(왜 수정했는지)로 작성
   - 고려중인 작성방식
     1. 목록화
        ex ) - 내용1
             - 내용2
             - 내용3
     2. 문장화
        ex ) @@@한 이슈로 인한 @@@ 작업 진행하였으며 $$$기능 추가를 위한 백엔드 개발 추후 개선 예정
