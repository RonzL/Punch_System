# Punch_System
一个学生健康信息打卡系统

## 功能介绍
健康信息打卡系统 V 1.0

  * 师生每日可通过系统上报健康信息（包含自动定位信息）
  * 师生可通过系统修改个人信息
  * 可通过系统发送邮件提醒未打卡师生
  * 可通过系统查看师生每日身体状态
  * 可通过系统查看班级打卡状况
  * 由于使用了权限控制，不同权限师生可访问不同的功能
  * 每日 0 点，自动重置数据库中师生的打卡状态
  * 每日 10 点，自动发送邮件提醒未打卡师生
  
## 涉及技术

后端：SSM + Spring Security + Quartz 

前端：JQuery + Ajax + EL + JSTL


## 需要注意的部分

  * 发送邮件工具函数中需要填写自己的邮箱账号和授权码
  * 打卡页面的 ajax 请求中需要填写自己的腾讯地图授权的 key
  
## 我学到的

  * 对于 Ajax 向控制器发送请求，在控制器方法中一定要加上 @ResponseBody注解，以返回 JSON 格式的数据。
  * 使用 Mybatis 框架执行多个参数的插入语句时，一定要使用 @Param 注解指定参数对应的数据库的列。
  * 对于 Spring Security，要想实现对控制器进行方法级权限控制，需要将权限控制注解配置在 SpringMVC 的 XML 配置文件中，而不是 Spring Security 的 XML 配置文件中。
  * 对于跨域请求，默认是不能接收 JSON 数据的，如果想要接收跨域请求的数据，可以指定返回数据格式为 JSONP。