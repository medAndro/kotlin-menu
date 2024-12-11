# [우테코 프리코스 최종 미션] 점심 메뉴 추천

## 🚀 미션 설명
- 한 주의 점심 메뉴를 추천해 주는 서비스 구현.

## 🛠️ 구현할 기능 목록
- ,로 구분하여 코치의 이름 입력받기
	- 각 코치는 최소 2글자, 최대 4글자인지 검사하기
	- 최소 2명, 최대 5명인지 검사하기
- 코치별로 먹지 못하는 음식 입력받기
	- 빈값이면 0개, 최대 2개까지 입력 했는지 검사하기
- 점심 메뉴 추천하기
	- 카테고리를 무작위로 추출하여 정하되, 이번주에 동일 카테고리가 2번을 초과하여 등장했다면 다시 섞어서 추출한다.
		- ```val category: String = categories.get(Randoms.pickNumberInRange(1, 5))```
	- 선택된 카테고리의 음식을 코치별로 무작위로 추출하여 메뉴를 추천한다.
		- ```val menu: String = Randoms.shuffle(menus)[0]```
		- 먹지 못하는 음식이거나 중복된 음식이면 새로 섞어서 다시 추천한다.
- 메뉴 추천 결과 출력하기
	

## 📕 라이브러리
- [camp.nextstep.edu.missionutils](https://github.com/woowacourse-projects/mission-utils/tree/main/src/main/java/camp/nextstep/edu/missionutils)에서 제공하는 API를 사용한다.
-  [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils) 에서 제공하는 `Randoms`에서 생성해 준 값을 이용한다.


## 🎯 프로그래밍 요구 사항

- Kotlin 1.6.20에서 실행 가능해야 한다. **Kotlin 1.6.20에서 정상적으로 동작하지 않을 경우 0점 처리한다.**
- **Java 코드가 아닌 Kotlin 코드로만 구현해야 한다.**
- 프로그램 실행의 시작점은 `Application`의 `main()`이다.
- `build.gradle(.kts)`을 변경할 수 없고, 외부 라이브러리를 사용하지 않는다.
- [Kotlin 코드 컨벤션](https://github.com/woowacourse/woowacourse-docs/tree/main/styleguide/kotlin) 가이드를 준수하며 프로그래밍한다.
- 프로그램 종료 시 `System.exit()`를 호출하지 않는다.
- 프로그램 구현이 완료되면 `ApplicationTest`의 모든 테스트가 성공해야 한다. **테스트가 실패할 경우 0점 처리한다.**
- 프로그래밍 요구 사항에서 달리 명시하지 않는 한 파일, 패키지 이름을 수정하거나 이동하지 않는다.
- indent(인덴트, 들여쓰기) depth를 3이 넘지 않도록 구현한다. 2까지만 허용한다.
  - 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  - 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
- 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  - 함수(또는 메서드)가 한 가지 일만 잘하도록 구현한다.
- else를 지양한다.
  - 힌트: if 조건절에서 값을 return 하는 방식으로 구현하면 else를 사용하지 않아도 된다.
  - 때로는 if/else, when문을 사용하는 것이 더 깔끔해 보일 수 있다. 어느 경우에 쓰는 것이 적절할지 스스로 고민해 본다.

### 카테고리와 메뉴 요구 사항

- 메뉴 추천 서비스에서 추천할 수 있는 카테고리와 각 카테고리의 메뉴는 아래와 같다.

```
일식: 규동, 우동, 미소시루, 스시, 가츠동, 오니기리, 하이라이스, 라멘, 오코노미야끼
한식: 김밥, 김치찌개, 쌈밥, 된장찌개, 비빔밥, 칼국수, 불고기, 떡볶이, 제육볶음
중식: 깐풍기, 볶음면, 동파육, 짜장면, 짬뽕, 마파두부, 탕수육, 토마토 달걀볶음, 고추잡채
아시안: 팟타이, 카오 팟, 나시고렝, 파인애플 볶음밥, 쌀국수, 똠얌꿍, 반미, 월남쌈, 분짜
양식: 라자냐, 그라탱, 뇨끼, 끼슈, 프렌치 토스트, 바게트, 스파게티, 피자, 파니니
```

#### 카테고리

- 추천할 카테고리는 [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils) 에서 제공하는 `Randoms.pickNumberInRange()`에서 생성해 준 값을 이용하여 정해야 한다.

```kotlin
// 예시 코드. 사용하는 자료 구조에 따라 난수를 적절하게 가공해도 된다.
val category: String = categories.get(Randoms.pickNumberInRange(1, 5))
```

- 임의로 카테고리의 순서 또는 데이터를 변경하면 안 된다.
  - `Randoms.pickNumberInRange()`의 결과가 **1이면 일식, 2면 한식, 3이면 중식, 4면 아시안, 5면 양식**을 추천해야 한다.
- 추천할 수 없는 카테고리인 경우 다시 `Randoms.pickNumberInRange()`를 통해 임의의 값을 생성해서 추천할 카테고리를 정해야 한다.

#### 메뉴

- 추천할 메뉴는 정해진 카테고리에 있는 메뉴를 [`camp.nextstep.edu.missionutils`](https://github.com/woowacourse-projects/mission-utils)에서 제공하는 `Randoms.shuffle()`을 통해 임의의 순서로 섞은 후, 첫 번째 값을 사용해야 한다.
  - 카테고리에 포함되는 메뉴 목록을 `List<String>` 형태로 준비한다.

```kotlin
val menu: String = Randoms.shuffle(menus)[0]
```

- 임의로 메뉴의 순서 또는 데이터를 변경하면 안 된다.
  - `Randoms.shuffle()` 메서드의 인자로 전달되는 메뉴 데이터는, 최초에 제공한 목록을 그대로 전달해야 한다.
    - 코치에게 추천할 메뉴를 정할 때 이미 추천한 메뉴, 먹지 못하는 메뉴도 포함된 리스트를 전달해야 한다.
- 추천할 수 없는 메뉴인 경우 다시 섞은 후 첫 번째 값을 사용해야 한다.

---

## ✏️ 과제 진행 요구 사항

- 미션은 [kotlin-menu](https://github.com/woowacourse-precourse/kotlin-menu) 저장소를 Fork & Clone해 시작한다.
- **기능을 구현하기 전 `docs/README.md`에 구현할 기능 목록을 정리**해 추가한다.
- **Git의 커밋 단위는 앞 단계에서 `docs/README.md`에 정리한 기능 목록 단위**로 추가한다.
  - [커밋 메시지 컨벤션](https://gist.github.com/stephenparish/9941e89d80e2bc58a153) 가이드를 참고해 커밋 메시지를 작성한다.
- 과제 진행 및 제출 방법은 [프리코스 과제 제출](https://github.com/woowacourse/woowacourse-docs/tree/master/precourse) 문서를 참고한다.
  - 소감문은 간소하게 입력해도 된다. 예를 들어, "."만 입력해도 된다.
