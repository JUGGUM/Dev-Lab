# Dev-Lab 🐇
실무에 도움이 될만한 기능을 실습하고 습득합니다.

## Redis 
- **캐싱** 시간을 설정하여 캐싱 기능을 활성화시킨다.
- **세션 클러스터링**을 구축하여 로그인한 사용자의 정보를 저장한다.
- RDS의 부담도 줄어들고 성능도 크게 향상하게 된다.

## RabbitMQ
- 실습구현화면
![RabbitMQ](./src/main/resources/static/rabbitMQ.png)
- AMQP(Advanced Message Queuing Protocol)를 구현한 오픈소스 메세지 브로커. PRODUCERS에서 CONSUMERS로 메세지(요청)를 전달할때 중간에서 브로커 역할을 한다.
- 해당하는 요청을 다른 API에게 위임하고 빠른 응답을 할 때 많이 사용한다.

## Vmap-Polygon
![Polygon](./src/main/resources/static/polygon.png)
- V-map에서 제공하는 지도오픈API를 사용하여 폴리곤을 생성한다.
- 도로명으로 주소를 검색하여 생성한 폴리곤에 해당 주소가 포함되어지는지 체크한다.

## Scheduler

## OAuth
- WebClient를 이용한 Http통신
- 카카오/네이버/구글/애플 로그인 구현
