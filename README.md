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
![1](https://user-images.githubusercontent.com/49589578/123602401-a9490a00-d833-11eb-9c29-f8c0ae6b52ff.jpg){: width="100" height="100"}
![2](https://user-images.githubusercontent.com/49589578/123602408-aa7a3700-d833-11eb-8627-efe74222e550.jpg){: width="100" height="100"}
