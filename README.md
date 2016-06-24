## Тестовое задание для компании "Онтрэвл Солюшенз"

####Консольное приложение
#####Для запуска:
1. Запускаем консоль из папки с файлом Matrix.jar
2. Выполняем команду:
```
java -classpath Matrix.jar matrix.Main
```
####Web-приложение
#####Для запуска:
1. Запускаем консоль из папки с pom.xml и выполняем команды:
  1. mvn package
  2. mysql -uusername -ppassword < db/create-database.sql
  3. mysql -uusername -ppassword < db/insert-data.sql
2. Копируем war-файл из папки target в папку \<TOMCAT_HOME\>/webapps
3. Запускаем сервер томкат
4. Web-приложение будет доступно из браузера по адресу: http://localhost:8080/test 

#####Примечание: Для настройки доступа к бд редактируем файл: src/main/resources/db.properties
