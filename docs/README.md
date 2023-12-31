# ☃️크리스마스 프로모션

---

## 🚀 기능 요구 사항

#### 12월 이벤트 계획

- 크리스마스 디데이 할인
    - 이벤트 기간: 2023.12.1 ~ 2023.12.25
    - 1,000원으로 시작하여 크리스마스가 다가올수록 날마다 할인 금액이 100원씩 증가
    - 총주문 금액에서 해당 금액만큼 할인  
      (e.g. 시작일인 12월 1일에 1,000원, 2일에 1,100원, ..., 25일엔 3,400원 할인)
- 평일 할인(일요일~목요일): 평일에는 디저트 메뉴를 메뉴 1개당 2,023원 할인
- 주말 할인(금요일, 토요일): 주말에는 메인 메뉴를 메뉴 1개당 2,023원 할인
- 특별 할인: 이벤트 달력에 별이 있으면 총주문 금액에서 1,000원 할인
- 증정 이벤트: 할인 전 총주문 금액이 12만 원 이상일 때, 샴페인 1개 증정
- 이벤트 기간: '크리스마스 디데이 할인'을 제외한 다른 이벤트는 2023.12.1 ~ 2023.12.31 동안 적용

#### 혜택 금액에 따른 12월 이벤트 배지 부여

- 총혜택 금액에 따라 다른 이벤트 배지를 부여
    - 5천 원 이상: 별
    - 1만 원 이상: 트리
    - 2만 원 이상: 산타

#### 고객에게 안내할 이벤트 주의 사항

- 총주문 금액 10,000원 이상부터 이벤트가 적용
- 음료만 주문 시, 주문할 수 없음
- 메뉴는 한 번에 최대 20개까지만 주문할 수 있음  
  (e.g. 시저샐러드-1, 티본스테이크-1, 크리스마스파스타-1, 제로콜라-3, 아이스크림-1의 총개수는 7개)

#### '12월 이벤트 플래너' 개발 요청 사항

- 고객들이 식당에 방문할 날짜와 메뉴를 미리 선택하면 이벤트 플래너가 주문 메뉴, 할인 전 총주문 금액, 증정 메뉴, 혜택 내역, 총혜택 금액, 할인 후 예상 결제 금액, 12월 이벤트 배지 내용 출력
- 12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
    - 방문할 날짜는 1 이상 31 이하의 숫자로만 입력
    - 1 이상 31 이하의 숫자가 아닌 경우, "[ERROR] 유효하지 않은 날짜입니다. 다시 입력해 주세요."라는 에러 메시지 출력
    - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성
- 주문하실 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
    - 고객이 메뉴판에 없는 메뉴를 입력하는 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력
    - 메뉴의 개수는 1 이상의 숫자만 입력되도록 해주세요. 이외의 입력값은 "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력
    - 메뉴 형식이 예시와 다른 경우, "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력
    - 중복 메뉴를 입력한 경우(e.g. 시저샐러드-1,시저샐러드-1), "[ERROR] 유효하지 않은 주문입니다. 다시 입력해 주세요."라는 에러 메시지 출력
    - 모든 에러 메시지는 "[ERROR]"로 시작하도록 작성
- 주문 메뉴의 출력 순서는 자유롭게
- 총혜택 금액에 따라 이벤트 배지의 이름출력
- 총혜택 금액 = 할인 금액의 합계 + 증정 메뉴의 가격
- 할인 후 예상 결제 금액 = 할인 전 총주문 금액 - 할인 금액
- 증정 메뉴
    - 증정 이벤트에 해당하지 않는 경우, 증정 메뉴 "없음"으로 출력
- 혜택 내역
    - 고객에게 적용된 이벤트 내역만 출력
    - 적용된 이벤트가 하나도 없다면 혜택 내역 "없음"으로 출력
    - 혜택 내역에 여러 개의 이벤트가 적용된 경우, 출력 순서는 자유롭게
- 이벤트 배지
    - 이벤트 배지가 부여되지 않는 경우, "없음"으로 출력

#### 기대하는 '12월 이벤트 플래너'의 예시 모습

```
안녕하세요! 우테코 식당 12월 이벤트 플래너입니다.
12월 중 식당 예상 방문 날짜는 언제인가요? (숫자만 입력해 주세요!)
3
주문하실 메뉴를 메뉴와 개수를 알려 주세요. (e.g. 해산물파스타-2,레드와인-1,초코케이크-1)
티본스테이크-1,바비큐립-1,초코케이크-2,제로콜라-1
12월 3일에 우테코 식당에서 받을 이벤트 혜택 미리 보기!
 
<주문 메뉴>
티본스테이크 1개
바비큐립 1개
초코케이크 2개
제로콜라 1개
 
<할인 전 총주문 금액>
142,000원
 
<증정 메뉴>
샴페인 1개
 
<혜택 내역>
크리스마스 디데이 할인: -1,200원
평일 할인: -4,046원
특별 할인: -1,000원
증정 이벤트: -25,000원
 
<총혜택 금액>
-31,246원
 
<할인 후 예상 결제 금액>
135,754원
 
<12월 이벤트 배지>
산타
```
---

## 📝 기능 구현 목록

### controller

- ️✔️ 이벤트 플래너 안내메시지를 출력한다.

- ✔️ 사용자에게 방문날짜를 입력받는다.

- ✔️ 사용자게 메뉴와 메뉴개수를 입력받는다.

- ✔️ 사용자가 주문한 메뉴를 출력한다.

- ✔️ 사용자가 주문한 메뉴의 총 주문금액을 출력한다.

- ✔️ 주문날짜와 주문정보를 기반으로 이벤트 혜택을 출력한다.


### domain

#### 주문
- ✔️ 메뉴 정보를 저장한다.
  - 메뉴 이름, 메뉴 카테고리, 가격정보를 저장한다.
  - 메뉴 이름으로 메뉴 정보를 반환한다.
  - 찾고자 하는 메뉴 이름이 없으면 예외를 발생시킨다.


- ✔️ 단일 메뉴 개수를 저장하고 관리힌다.
  - 메뉴 개수가 유효한지 검증한다.
    - 메뉴 개수가 1~20 사이인지 검증한다.
  - 메뉴 개수를 반환한다.


- ✔️ 단일 메뉴 주문 정보를 저장하고 관리한다.
  - 메뉴와 메뉴 개수를 저장한다.
  - 메뉴 주문형식이 올바른지 검증한다.
  - 주문 정보를 반환한다.


- ✔️ 주문 날짜를 저장하고 관리한다.
  - 입력된 주문날짜가 숫자인지 검증한다.
  - 입력된 주문날짜가 유효한 날짜인지 검증한다.
  - 주문 날짜를 반환한다.


- ✔️ 총 주문 정보를 저장하고 관리한다.
  - 주문날짜와 주문들을 저장한다.
  - 주문들이 유효한지 검증한다.
    - 모든 주문이 음료인지 검증한다.
    - 중복된 주문이 있는지 검증한다.
    - 총 주문 개수가 20개를 넘기는지 검증한다.
  - 총 주문금액을 계산하고 저장한다.
  - 주문정보를 반환한다.

#### 이벤트
- ✔️ 크리스마스 이벤트 정보를 저장한다.
  - 이벤트 시작, 종료 날짜와 이름을 저장한다.


- ✔️ 이벤트 할인 타입을 저장한다.
  - 이벤트들의 할인타입을 저장한다.
  - 해당하는 이벤트의 할인타입을 반환한다.


- ✔️ 날짜를 기반으로 할인하는 이벤트를 저장하고 관리한다.
  - 유효한 날짜인지 검증하고, 해당 날짜에 이벤트가 있으면 반환한다.
  - 총 주문 정보를 기반으로 해당하는 이벤트들을 반환한다.


- ✔️ 주문 금액을 기반으로 할인하는 이벤트를 저장하고 관리한다.
  - 유효한 날짜인지 검증하고, 주문 금액이 이벤트 금액에 충족하는 이벤트가 있으면 반환한다.
  - 총 주문 정보를 기반으로 해당하는 이벤트들을 반환한다.


- ✔️ 증정품을 주는 이벤트를 저장하고 관리한다.
  - 증정품을 주는 이벤트와 증정품 정보를 저장한다.
  - 이벤트가 증정품을 주는 이벤트이면, 증정품 정보들을 반환한다.


- ✔️ 이벤트 베지정보를 저장하고 관리한다.
  - 베지 이름과 해당 베지 혜택 금액의 기준을 저장한다.
  - 혜택 금액으로 해당하는 베지를 반환한다.

#### 할인 계산
- ✔️ 이벤트 할인 정보를 저장하고 할인금액을 계산한다.
  - 이벤트와 해당하는 할인 정보를 저장한다.
  - 이벤트 정보를 기반으로 해당 이벤트 계산기를 반환한다.
  - 총 주문 정보를 기반으로 이벤트 할인 금액을 계산한다.

#### 이벤트 플래너
- ✔️ 이벤트 혜택을 찾고, 혜택 정보를 반환한다.
  - 총 주문 금액이 이벤트 적용 최소 금액을 만족하는지 검증한다.
  - 총 주문 정보를 기반으로 해당하는 이벤트들을 검색한다.
  - 증정품, 혜택 정보, 혜택 금액, 결제 금액, 베지를 계산하고 반환한다.

### view
- ✔️ 입력
  - 방문 날짜 입력 문구를 출력하고 방문날짜를 입력받는다.
  - 총 주문 입력 문구를 출력하고 총 주문을 입력받는다.


- ✔️ 출력
  - 이벤트 플래너 시작 메시지를 출력한다.
  - 이벤트 혜택 정보 안내 메시지를 출력한다.
  - 주문 정보를 출력한다.
  - 총 주문 금액을 출력한다.
  - 이벤트 혜택을 출력한다.
    - 증정품을 출력한다.
    - 혜택 정보를 출력한다.
    - 혜택 금액을 출력한다.
    - 결제금액을 출력한다.
    - 이벤트 베지를 출력한다.
  - 에러 메시지를 출력한다.

### util
- ✔️ 파서
  - 문자열을 리스트타입으로 반환한다.
  - 문자열을 Int형으로 반환한한다.
    - 문자열이 숫자인지 검증한다.

### 예외처리
- 잘못된 입력일 경우 `IllegalArgumentException`로 예외를 발생시키고 "[ERROR]"로 시작하는 에러 메시지 출력 후 그 부분에서 다시 입력받는다.