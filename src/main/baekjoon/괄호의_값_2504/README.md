# 문제: 괄호의 값 (골드 5)

📌 [문제 링크](https://www.acmicpc.net/problem/2504)


---

## ▪️ 접근 방법
자료구조 + 스택

---

## ▪️ 예시
```
(()[[]])([])
c: ( / stack: [(]
result: 0 / value: 2

c: ( / stack: [(, (]
result: 0 / value: 4

c: ) / stack: [(]
result: 4 / value: 2

c: [ / stack: [(, []
result: 4 / value: 6

c: [ / stack: [(, [, []
result: 4 / value: 18

c: ] / stack: [(, []
result: 22 / value: 6

c: ] / stack: [(]
result: 22 / value: 2

c: ) / stack: []
result: 22 / value: 1

c: ( / stack: [(]
result: 22 / value: 2

c: [ / stack: [(, []
result: 22 / value: 6

c: ] / stack: [(]
result: 28 / value: 2

c: ) / stack: []
result: 28 / value: 1

28
```
```
(()[[]])
이 부분만 보면 2*(2 + 3*3)로 계산식이 떠오른다.

풀어보면 다음과 같이 될 수 있다. 2*2 + 6*3 
아직 닫히지 않은 괄호는 가중치의 값으로 활용하면 된다. 
```

---

## ▪️ 회고
```
하나하나 따라가면서 이해했다 
이해하기 어려운 문제였다.
```