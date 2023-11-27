# Server
<img src="https://github.com/SOPT-33th-Joint-Seminar-WEB-1/Server/assets/62981652/518c2788-87e9-4038-b4cb-5866c90f6089" width="705" height="448">

## 🧞‍♂️ Team

|    **✨[박지영](https://github.com/ziiyouth)**    |   **✨[안현주](https://github.com/hellozo0)**   |
|:--------------------------------------------:|:------------------------------------------:|
| <img src ="https://github.com/SOPT-33th-Joint-Seminar-WEB-1/Server/assets/62981652/7d882575-1deb-4182-9235-e1d3033bc4a9" width="300" height="300"/> | <img src ="https://github.com/SOPT-33th-Joint-Seminar-WEB-1/Server/assets/62981652/3aeb8640-18cd-420f-9287-4afe2a9bb9bd" width="300" height="300"/> |
|             Server Developer                 |               Server Developer                   |
| DB 설계 <br/>DETAIL API, SHOPPING API 개발<br/> | 프로젝트 세팅<br />MAIN API, BEST API 개발 |


<br>



## 🔨 Project Architecture

<img width="705" alt="Architecture" src="https://github.com/SOPT-33th-Joint-Seminar-WEB-1/Server/assets/62981652/bc065675-0e69-4005-a29f-91311d42d502">



<br>

## 🔨 Project Structure
```
├─📁 main
│  ├─📁 java
│  │  └─📁 com
│  │      └─📁 example
│  │          └─📁 DOSOPTaladin
│  │              ├─📁 config
│  │              ├─📁 controller
│  │              ├─📁 domain
│  │              ├─📁 dto
│  │              │  └─📁 request
│  │              │  └─📁 response   
│  │              ├─📁 exception
│  │              ├─📁 repository
│  │              └─📁 service
│  └─📁 resources
│      ├─static
│      └─templates
└─📁 test
```

<br>

## 🛠️ ERD
<img width="705" alt="ERD" src="https://github.com/SOPT-33th-Joint-Seminar-WEB-1/Server/assets/62981652/4fc842ab-79a3-4fd4-adbd-c48f5d12d991](https://github.com/SOPT-33th-Joint-Seminar-WEB-1/Server/assets/62981652/07d88db7-7f8a-4fc3-8b45-c7a148a1b62a">


<br><br>



## 🌳 Branch

🌱 git branch 전략

`main branch` : 배포 단위 branch

`dev branch` : 주요 개발 branch, main merge 전 거치는 branch

`feat branch`: 각자 개발 branch

`fix branch`: 버그 수정 branch

- 할 일 issue 등록 후 issue 번호와 isuue 이름으로 branch 생성 후 작업
  - ex) feat/#`issue num`-`isuue name`
- 해당 branch 작업 완료 후 PR 보내기
  - 항상 local에서 충돌 해결 후 → remote에 올리기
  - reviewer에 서로 tag후 code-review
  - review반영 후, 본인이 merge.

<br>

## 🌱 Commit Convention
### Type

`[FEAT]` : 새로운 기능이 추가됐어요.

`[UPDATE]`: 기능이 업데이트 됐어요.

`[FIX]`: 버그가 수정됐어요.

`[REFACTOR]`: 버그 수정이나 기능 추가가 없는 코드 변경 ( 코드 구조 변경 등의 리팩토링 )

`[TEST]`: 테스트 추가 또는 이전 테스트 수정

`[DOCS]`: README, wiki 문서를 수정했어요.

`[STYLE]`: 코드 변경 없이 스타일 변경했어요.

`[CHORE]`: 기타 사항이에요. (주석 추가 등등)

<br>


## 💫 Code Convention
[NAVER CAMPUS HACKDAY's Java Code Conventions](https://naver.github.io/hackday-conventions-java/)


