cd %userprofile%
call mvn validate compile test allure:report -f .\Desktop\IdeaProjects\UI_autotests\pom.xml -P FailedTests