# Spring CI/CD Pipeline with Docker Hub

이 레포지토리는 GitHub Actions를 통한 Spring Boot 애플리케이션의 CI/CD 파이프라인을 구현한 예제입니다.

- 자동 빌드, 테스트, Docker 이미지 생성 및 Docker Hub로의 푸시와 함께 서버에 배포하는 과정을 자동화.
- **배포**: `CI/CD` 디렉토리 내 스크립트를 통해 서버 머신에서 애플리케이션을 실행 또는 업데이트

## CI/CD 파이프라인 흐름
GitHub Actions 워크플로우 파일(`.github/workflows/CICD_DockerHub.yml`) 은 다음과 같은 흐름으로 진행됩니다:
1. **코드 체크아웃**  
   최신 커밋을 가져옵니다.
2. **빌드 및 테스트**  
   Maven/Gradle 빌드를 수행하고, 테스트를 실행합니다.
3. **Docker 이미지 생성**  
   Dockerfile을 사용하여 애플리케이션의 Docker 이미지를 생성합니다.
4. **Docker Hub 푸시**  
   생성된 이미지를 Docker Hub 레지스트리로 푸시합니다.
5. **배포**  
   `CI/CD` 디렉토리 내의 배포 스크립트를 서버 머신에서 실행하여 애플리케이션을 배포합니다.

## 필수 Secrets 설정
GitHub Actions 워크플로우가 원활하게 실행되기 위해, 아래의 Secrets가 GitHub 레포지토리의 Settings > Secrets 에 반드시 등록되어 있어야 합니다:

- **DOCKER_USERNAME**: Docker Hub 사용자명  
- **DOCKER_PASSWORD**: Docker Hub 비밀번호
- **REMOTE_IP**: 배포 대상 서버의 호스트명 또는 IP 주소  
- **REMOTE_USER**: SSH 접속 시 사용할 사용자명
- **REMOTE_PRIVATE_KEY**: 서버 접속을 위한 SSH 개인 키  
- **REMOTE_SSH_PORT**: 서버 접속을 위한 SSH 포트

> 위 Secrets들이 반드시 존재해야 워크플로우가 정상적으로 실행됩니다.

## CI/CD 디렉토리
`CI/CD` 디렉토리 내 파일들은 **서버 머신에서 실행되어야 하는 배포 스크립트 및 설정 파일**들입니다.
- 애플리케이션 서버의 시작 및 재시작
- 환경 변수 및 기타 서버 관련 설정 적용
- 배포 관련 기타 작업 처리
