# testLJTT
UI Automatic testing,springboot testng selenium

# ˵��
��������ǻ���springboot��dbunit��testng��selenium������һ�ײ��Կ�ܣ�����ubmp�Ľ���UI�Զ���

ʹ�÷�ʽ��
1��check����
2��ʹ��mvn���
3�����а� java -jar testubmp.jar

����˵����
�����̵Ĳ�������ͨ������������Ч������������õ�����
���������վʹ��     --appUrl=http://www.baidu.com
����ʹ�������       --browser=chrome
�������������·��   --dbus=D:/chromedriver.exe
�������ݿ�           --spring.datasource.url=jdbc:mysql://10.28.124.203:3306/iotdmauto?useUnicode=true&characterEncoding=utf-8&serverTimezone=GMT
�������ݿ��û�       --spring.datasource.username=root
�������ݿ�����       --spring.datasource.password=bmeB4000
�������ݿ�����       --spring.datasource.driverClassName=com.mysql.jdbc.Driver
�����Ƿ񱸷����ݿ�   --dbback=false
�������ݿⱸ��·��   --docpath=d:/testcase/doc/


ʹ��ʾ����
java -jar testubmp.jar      ��ʾ����Ĭ�ϵĴ������
java -jar testubmp.jar --appUrl=http://10.28.124.234:18080/ubmp/index.html --dbus=d:/testcase/chromedriver.exe    ��ʾ����234�Ļ�����ʹ�����������Ϊd:/testcase��
