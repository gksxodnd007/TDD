### 로또 게임 기능 구현을 통한 TDD Practice

#### 기능 요구사항
- 로또 게임 기능을 구현
- 로또 당첨 금액은 고정
    - 1등 : 6개 번호 모두 일치 (당첨 금액 : 2,000,000,000원)
    - 2등 : 5개 번호 모두 일치 + 보너스 번호 일치 (당첨 금액 : 30,000,000원)
    - 3등 : 5개 번호 일치 (당첨 금액 : 1,500,000원)
    - 4등 : 4개 번호 일치 (당첨 금액 : 50,000원)
    - 5등 : 3개 번호 일치 (당첨 금액 : 5,000원)
- 로또 구입 금액 입력시 구입 금액에 해당하는 로또 발급
- 로또 1장의 가격은 1000원
- 수익률을 계산해 출력

#### 예외 케이스
- 입력 금액은 1000원 이상이어야 한다. 1000원 단위가 아닌 금액은 버린다. 예를 들어 1500이면 1000 으로 한장만 구매 가능하다.
- 로또 한 장은 6개의 번호여야 한다.
- 6개의 각 숫자는 1에서 45 사이의 값이어야 한다.
- 6개의 값은 중복된 값이 있으면 안된다.
- 당첨 번호의 경우는 보너스 번호가 1에서 45 사이의 값이어야 하여, 보너스 번호는 당첨 번호 6개의 값이 아니어야 한다.

