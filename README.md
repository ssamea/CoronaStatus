# CoronaStatus
공공 API를 활용한 실시간 코로나 현황 검색 모바일 애플리케이션

## 취지
- OpenApi를 능숙하게 다루기 위해 본 프로젝트를 실시하였음.

## 개발 일지
### 2021-06-26
- 파싱이 제대로 안받아와 진다.. 아마 공공 API 사이트에 따르면 최소 1시간부터 어떤 API는 24시간 이후부터 정상적인 이용이 가능하다고 한다.
- 메인 액티비티의 디자인과 생각한 기능을 구현하기 위한 기본적인 위젯과 기능들을 구현함.
<br> ![error](https://user-images.githubusercontent.com/49589578/123546810-32f7c980-d799-11eb-9f63-fdbb1dec3931.JPG)</br>

### 2021-06-27
- 아직도 데이터 요청 에러가 뜸. 인증키를 다시 재발급받아도 도무지 에로 해결이 안됨. open api가 구글링한 결과 인코딩을 한 자체로 배포하여 문제가
  될 때가 많다고 함. 일단 사이트에 문의해둠
 
- 메인 엑티비티 추가 기능 및 애플리케이션 실행 시 첫 액티비티를 애니메이션을 활용(카카오톡처럼)
![main화면](https://user-images.githubusercontent.com/49589578/123546855-62a6d180-d799-11eb-976a-4c6d00f1ea41.JPG)
![start화면](https://user-images.githubusercontent.com/49589578/123546857-633f6800-d799-11eb-800f-639ccd78d322.JPG)


### 2021-06-28
- 드디어 공공데이터 문제를 해결. 원인은 예상한대로 공공데이터 API측 데이터 인증키 동기화 문제였음. 문의해서 해결완료
- Fragment를 이용한 날짜 검색 시 일일 코로나 확진자 정보 기능 V
- Fragment를 이용한 자가 문진표 작성 기능 v
- 기본적인 UI를 좀더 보완해야 함

<img src = "https://user-images.githubusercontent.com/49589578/123602401-a9490a00-d833-11eb-9c29-f8c0ae6b52ff.jpg" width="30%" height="height 30%">

<img src = "https://user-images.githubusercontent.com/49589578/123602408-aa7a3700-d833-11eb-8627-efe74222e550.jpg" width="30%" height="height 30%">


### 2021-06-29 ~ 07-01
- 갑자기 확진자를 구하는 부분에서 잘 되던 부분이 에러가 났다.
- 에러코드는 java.lang.StringIndexOutOfBoundsException: String index out of range: -1
- 정말 아이러니하다.. 분명히 위 사진 처럼 잘 되던 기능이 갑자기 안된다. 구글링을 해본 결과 나와는 좀 다른 상황이지만 대부분 스트링 배열의 제한 용량을
  초과한 에러이다. 하지만 내거는 아닌데..
  
 ### 2021-07-01 ~ 02
 - 혹 에뮬레이터가 이상이 있나 싶어 usb테더링 후 내 스마트폰에다 앱을 설치한 결과 정상으로 다시 출력된다....
 - 왜 그런지 모르겠지만 에뮬레이터에서 실행하면 out of index 에러가 나온다. 다른 스마트폰으로도 테스트해봐도 정상적으로 출력된다. 원인을 좀 더 알아봐야겠음
 - Fragment 액티비티를 활용하여 마켓 기능을 구현 v
 -> URI로 옥션 주소를 뿌려서 마스크와 손세정제 목록을 가져온다. v
 
 - 해야할 것
 -> 뿌려진 리스트에서 구매 버튼을 누르면 bootpay api 를 활용한 기능을 구현해야한다.(boot api 에 대해 좀 구글링하면서 공부중)
 -> 구매 이모지가 짤린다.. 이건 내일 벌써 새벽1시임 저 오류땜에 2일을 버림. 아직도 부족함을 느낀다...
 
 <img src = "https://user-images.githubusercontent.com/49589578/124302242-e5fe6380-db9b-11eb-9f7d-fe8837180a79.jpg" width="30%" height="height 30%">

<img src = "https://user-images.githubusercontent.com/49589578/124302244-e72f9080-db9b-11eb-9bce-93c8fbb6265e.jpg" width="30%" height="height 30%">

### 2021-07-11~12
- bootpay api를 활용하여 실제 결제 기능까지 만들었다. v
- toss, 카드결제를 이용한 구매 기능 v
<img src = "https://user-images.githubusercontent.com/49589578/127087268-b2899d46-b324-402f-87d2-034d71059ad5.JPG" width="30%" height="height 30%">
<img src = "https://user-images.githubusercontent.com/49589578/127087270-642b376f-6678-4526-a229-0bf4be9aaee0.JPG" width="30%" height="height 30%">
