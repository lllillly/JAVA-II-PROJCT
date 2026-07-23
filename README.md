# Seal Breakers

Java Swing으로 만든 2D 플랫폼 어드벤처 팀 프로젝트입니다. 캐릭터를 선택해 스테이지를 탐험하고 봉인된 마법석을 해제하는 게임과, 제작에 사용한 그래픽 도구를 함께 담고 있습니다.

## 구동 화면

### 게임 플레이

![Seal Breakers 게임 플레이 화면](docs/images/seal-breakers-gameplay.png)

### 시작 화면

![Seal Breakers 시작 화면](docs/images/seal-breakers-launcher.png)

## 주요 기능

- 캐릭터 선택 후 진행하는 2D 플랫폼 스테이지
- 스테이지 클리어 화면과 게임 진행 UI
- 회원가입·로그인과 MySQL 기반 사용자 관리
- DB 연결 없이 바로 체험할 수 있는 게스트 모드
- 이미지 분할·맵 오브젝트 편집 등 게임 제작 보조 도구

## 실행 방법

Java 17이 필요합니다.

```bash
./gradlew run
```

첫 화면에서 **게스트로 게임 시작**을 선택하면 DB 없이 실행됩니다.
