# 로또
## 기능 요구사항
* 로또 구입 금액을 입력하면 구입 금액에 해당하는 로또를 발급해야 한다.
* 로또 1장의 가격은 1000원이다.

## 기능 목록
* UI
  * InputView
    * [X] 구입 금액을 입력 받을 수 있다.
    * [X] 지난 주 당첨 번호를 입력 받는다.
    * [X] 보너스 번호를 입력 받는다
  * ResultView
    * [X] 구입금액에 해당하는 로또 수와, 생성된 로또 목록을 출력한다.
    * [X] 당첨 통계 결과를 출력한다.
    
* DOMAIN
    * [X] 구매 가능한 LottoTicket 수 구하기
        * 14000원 -> 14장 
        * 1000원 -> 1장
        * 1500원 -> IllegalArgumentException ("1000원 단위로 입력해주세요.")
        * 1000원 미만 -> IllegalArgumentException ("구입 가능한 로또가 없어요")
    * [X] LottoTicket 생성
        * 로또 번호는 1~45범위 숫자 중 중복되지 않은 랜덤 숫자 6개로 구성
    * [X] WinningNumber 당첨 번호 생성
        * 6개 숫자로 입력
        * 1~45범위 숫자 중 중복되지 않는다
    * [X] 1장의 LottoTicket에 대해 당첨 결과 구하기 
    * [X] N장의 LottoTicket에 대해 당첨 결과 구하기
    * [X] Lotto 결과에 따른 당첨 금액 구하기
    * [X] Lotto 결과에 따른 수익률 구하기
    
* DOMAIN Detail
    * [X] Rank
      - 로또 당첨 등수와 당첨 금액 정보를 알고 있다.
    * [X] LottoTicket: 로또 티켓 1장
        - [X] 1 ~ 45 범위의 중복되지 않는 숫자 6개로 이뤄진다.
        - [X] 당첨번호와 일치하는 LottoNumber 개수를 알고 있다
    * [x] LottoTickets: 로또 티켓 N장 (일급 컬렉션)
        - [X] LottoTicket N장에 대한 당첨 결과(당첨 등수, 당첨 갯수)를 알고 있다. 
    * [X] LottoShop: 로또 상점
        - [X] 구입 가능한 로또 수를 알고 있다.
        - [X] LottoVendor로 생성된 LottoTickets을 제공한다.
    * [X] LottoVendor
        - [X] N개의 LottoTickets 생성한다.
    * [X] WinningNumbers: 로또 당첨 번호 
        - [X] 1 ~ 45 범위의 중복되지 않는 숫자 6개로 이뤄진다.
        - [X] LottoNumber가 당첨번호인지 알고 있다.
    * [X] BonusNumber: 로또 보너스 번호
    * [X] LottoMatcher: 당첨 결과 계산기
      - [X] N장의 LottoTicket에 대한 당첨 결과(당첨 등수별 당첨 갯수)를 제공한다 
      - [X] N장의 LottoTicket에 대한 당첨 금액을 알고 있다
      - [X] N장의 LottoTicket에 대한 수익률을 알고 있다.
    
## 실행 결과
```
구입금액을 입력해 주세요.
14000
14개를 구매했습니다.
[8, 21, 23, 41, 42, 43]
[3, 5, 11, 16, 32, 38]
[7, 11, 16, 35, 36, 44]
[1, 8, 11, 31, 41, 42]
[13, 14, 16, 38, 42, 45]
[7, 11, 30, 40, 42, 43]
[2, 13, 22, 32, 38, 45]
[23, 25, 33, 36, 39, 41]
[1, 3, 5, 14, 22, 45]
[5, 9, 38, 41, 43, 44]
[2, 8, 9, 18, 19, 21]
[13, 14, 18, 21, 23, 35]
[17, 21, 29, 37, 42, 45]
[3, 8, 27, 30, 35, 44]

지난 주 당첨 번호를 입력해 주세요.
1, 2, 3, 4, 5, 6

보너스 볼을 입력해 주세요.
7

당첨 통계
---------
3개 일치 (5000원)- 1개
4개 일치 (50000원)- 0개
5개 일치 (1500000원)- 0개
5개 일치, 보너스 볼 일치(30000000원) - 0개
6개 일치 (2000000000원)- 0개
총 수익률은 0.35입니다.(기준이 1이기 때문에 결과적으로 손해라는 의미임)
```

## 프로그래밍 요구 사항
* 모든 기능을 TDD로 구현해 단위 테스트가 존재해야 한다. 단, UI(System.out, System.in) 로직은 제외
  * 핵심 로직을 구현하는 코드와 UI를 담당하는 로직을 구분한다.
  * UI 로직을 InputView, ResultView와 같은 클래스를 추가해 분리한다.
* indent(인덴트, 들여쓰기) depth를 2를 넘지 않도록 구현한다. 1까지만 허용한다.
  * 예를 들어 while문 안에 if문이 있으면 들여쓰기는 2이다.
  * 힌트: indent(인덴트, 들여쓰기) depth를 줄이는 좋은 방법은 함수(또는 메서드)를 분리하면 된다.
* 함수(또는 메서드)의 길이가 15라인을 넘어가지 않도록 구현한다.
  * 함수(또는 메서드)가 한 가지 일만 잘 하도록 구현한다.
* 기능을 구현하기 전에 README.md 파일에 구현할 기능 목록을 정리해 추가한다.
* git의 commit 단위는 앞 단계에서 README.md 파일에 정리한 기능 목록 단위로 추가한다.