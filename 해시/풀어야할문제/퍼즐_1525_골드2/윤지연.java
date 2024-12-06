package 해시.풀어야할문제.퍼즐_1525_골드2;

public class 윤지연 {
    /*최소한의 이동으로 목표상태를 만들자
    * 상하좌우 이동하여 0과 숫자 자리 바꿈
    * 이동방향
    * 상 -3, 하 +3, 좌 -1, 우 +1
    * 입력처리
    * 3*3 퍼즐 문자열 처리 "103425786" (예제입력1번 기준)
    * 탐색
    * 시작 상태를 큐에 넣고, 방문 집합에 기록
    * 큐에서 상태를 꺼내 0 위치를 찾는다.
    * 0을 상하좌우로 이동시켜 새로운 상태를 만든다.
    * 새로운 상태가 목표 상태이면 이동 횟수를 출력한다.
    * 새로운 상태가 방문하지 않은 상태라면 큐에 추가한다.
    * 종료조건
    * 큐가 비었는데도 목표 상태를 찾지 못하면 -1을 출력한다.
    *
    * 주의사항
    * 경계처리: 0이 퍼즐 경계를 벗어나지 않도록 방향을 제한해야 한다.
    * 시간 복잡도: 가능한 모든 상태를 탐색하므로 9!(362,880) 상태를 탐색할 수 있다.
    * */
}
