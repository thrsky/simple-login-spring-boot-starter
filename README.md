# Simple-Login-Spring-Boot-Starter
**基础的登录注册页面** 

## 项目诉求
基本的后台系统都需要登录注册页面，目前Spring体系里基本上都是用 SpringBoot + Shrio 。
Shrio 功能完善体系成熟，但是使用起来有点重 :fearful: ，不太适合个人简单的后台系统权限。
所以想要写一个简单的后台权限控制系统

## 项目使用
利用SpringBoot的starter插件机制，引入一个简单的jar就能使用

## 项目实现
1. spring-boot-autoconfigure
2. 注册servlet进行页面控制
3. 利用SPI，用户可以自定义业务逻辑

## 项目进度
1. autoconfigure框架 :ok_hand:
2. servlet 有点复杂（参考alibaba.durid） :question:
3. html 初始化
4. SPI 尚未进行开发 (参考Dubbo-SPI)