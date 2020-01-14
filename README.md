# Refactoring-Automation-Tool
자바기반의 파이썬 리펙토링 도구                                


## 목표: <br/>
자바 기반의 파이썬 분석 도구를 개발합니다. 
분석 언어는 파이썬이며 파서생성기(Antlr)를 사용해 AST를 구축하며, 최종 기능으로 코드 리펙토링을 위한 솔루션을 제공합니다. 
비슷한 오픈소스로는 Pylint가 있습니다.참고서적은 브렛 슬라킷의 이펙티브 파이썬이며 언어의 스타일에 맞는 리펙토링 가이드를 제공하려고 합니다. 
코드 스멜은 책에 있는 가이드라인을 참고했으며, 이를 발견하면 프로그램은 Console를 통해 보여줍니다.

![image](https://user-images.githubusercontent.com/45285053/72316865-d4d94280-36da-11ea-9c4b-aef50e7fd1a2.png)

-	환경 구성 단계
파이썬 AST를 프로그램내에서 만들 수 있어야 합니다. 이를 위해서 파서생성기 Antlr를 intelliJ와 연동하고 GitHub에서 
파이썬 G4파일을 clone받아 파서생성기를 구축합니다. 
![image](https://user-images.githubusercontent.com/45285053/72316868-d7d43300-36da-11ea-8c6e-67c43c34d375.png)


