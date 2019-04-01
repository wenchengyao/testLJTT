# testLJTT
UI Automatic testing,springboot testng selenium

# 说明
这个工程是基于springboot、dbunit、testng和selenium构建的一套测试框架，用于ubmp的界面UI自动化

使用方式：
1、check代码
2、使用mvn打包
3、运行包 java -jar testubmp.jar

参数说明：
本工程的参数可以通过命令配置生效，满足服务配置的需求
定义访问网站使用     --appUrl=http://www.baidu.com
定义使用浏览器       --browser=chrome
定义浏览器驱动路径   --dbus=D:/chromedriver.exe
定义数据库           --spring.datasource.url=jdbc:mysql://10.28.124.203:3306/iotdmauto?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT
定义数据库用户       --spring.datasource.username=root
定义数据库密码       --spring.datasource.password=bmeB4000
定义数据库驱动       --spring.datasource.driverClassName=com.mysql.jdbc.Driver
定义是否备份数据库   --dbback=false
定义数据库备份路径   --docpath=d:/testcase/doc/


使用示例：
java -jar testubmp.jar      表示测试默认的打包环境
java -jar testubmp.jar --appUrl=http://10.28.124.234:18080/ubmp/index.html --dbus=d:/testcase/chromedriver.exe    表示测试234的环境，使用浏览器驱动为d:/testcase的
