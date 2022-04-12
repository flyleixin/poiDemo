# poiDemo
居于POI的一个考勤表格，用于腾讯会议导出的数据进行考勤.

## 需求背景
以下是具体要求：
(1) 能读取听课记录（可导出为csv文件）和班级信息在线文档（可导出为csv文件）中的数据；
(2) 根据听课记录和班级信息，自动生成一个csv格式的考勤记录文件，该文件中包括所有学员的学号、姓名、学习方向、专业、电话信息，同时还有若干列，每列是一次课的出勤情况。列标题为“主题_日期”（theme_yyyymmdd格式，主题为software、hardware、algorithm中的一项）。列内容为1，表示出勤，为0.5，表示半勤，为0，表示未出勤；
(3) 参加了课程且在有效时间内的时长超过1小时20分钟算有效出勤，有效时长在50分钟至1小时20分钟之间的算半勤，其余算缺勤；
(4) 每次运行该文件，都会判断待核查的主题及日期其考勤记录是否在考勤记录文件中，如果不在，则增加一列，记录新一次课程的考勤信息。

## 实现
居于这个要求，通过了解JAVA对Excel的操作，所以开发了这个小项目

## 技术难点
1. 若干列考勤数据，一开始比较纠结，后来通过给对象添加了一个ArrayList，这样就实现了基本的功能。
2. 给人员添加考勤数据，不知道怎么定位，后来在室友的指导下，先给每一个List添加数据，然后再修改。
![image](https://user-images.githubusercontent.com/46413271/162891851-64e963fe-fd04-42da-b1ac-7a1852add5e4.png)
3. 这里有一个Bug，cell的setCellValue()方法，传一个Interger过去，数据会自己变成Double，这里需要用tostring转成String.

