# Branroom

[![Build Status](https://travis-ci.org/BranSummer/branroom.svg?branch=master)](https://travis-ci.org/BranSummer/branroom)

## Instruction
This is a simple online chat site example, based on Websocket implementation, with basic user management capabilities.  
This project is completed in my java web learning process, may be low and simple, but in the future of learning, I will continue to improve the site and add functionality

## Basis
* Language: Java  
* Framework:Spring+Spring MVC+mybatis
* Front-end:Bootstrap
* DBMS:MySQL
* IDE:eclipse

## 网站模块
我的网站从功能上总共划分为用户模块 , 博客模块 , 在线聊天模块  

* 用户模块 :
其实用户系统对于个人网站来说是一块鸡肋,大多数的个人网站目前来说很少有用户功能的 , 毕竟很少有人会为了看几篇文章而专门为了一个小网站而去注册用户的 , 这样会损失很多的网站流量 , 得不偿失 . 然而我建设网站的初衷毕竟是为了学习,而且此网站**并非是个人博客网站,而是一个博客平台** , 是面向用户发布博客的,而且另外一个在线聊天系统也需要依托用户系统的实现 , 因此用户模块是必要的 .
* 博客模块 : 博客模块的重点在于前端实现 , 现阶段后台对于blog的处理还只是简单的CURD(今后会添加更多的功能和实现性能上的优化) , blog模块实现了网站的前后台分离 , 客户端通过ajax发起请求 , 服务端接受请求并返回json格式的报文 , 有客户端渲染生成页面 . blog的前台主要应用bootstarp,jquery等框架实现 , 特别地,网站blog支持markdown文档编写,主要应用了editor.md这个插件.
* 在线聊天模块 :这个模块是独立于其他的web模块的,因为在线聊天是基于websocket来实现的 , websocket是独立于HTTP之外的TCP协议 . 在这个模块之中 , 接入一个图灵机器人的API , 做成了一个与可以机器人对话的窗口 .
## 技术架构

### 项目架构图
![](https://github.com/BranSummer/Resources/blob/master/branroom/branrooma%E6%9E%B6%E6%9E%84.png)
### 运行流程分析
以加载一个blog页面为例  

1. 首先用户发送请求——>DispatcherServlet，前端控制器收到请求后自己不进行处理，而是委托给其他的解析器进行处理，作为统一访问点，进行全局的流程控制；
2.  DispatcherServlet——>HandlerMapping， HandlerMapping将会把请求映射为HandlerExecutionChain对象（包含一个Handler处理器（页面控制器）对象、多个HandlerInterceptor拦截器）对象，通过这种策略模式，很容易添加新的映射策略；
3.   DispatcherServlet——>HandlerAdapter，HandlerAdapter将会把处理器包装为适配器，从而支持多种类型的处理器，即适配器设计模式的应用，从而很容易支持很多类型的处理器；
4.  HandlerAdapter——>处理器功能处理方法的调用，HandlerAdapter将会根据适配的结果调用真正的处理器的功能处理方法，完成功能处理；并返回一个ModelAndView对象（包含模型数据、逻辑视图名）；
5.  ModelAndView的逻辑视图名——> ViewResolver， ViewResolver将把逻辑视图名解析为具体的View，通过这种策略模式，很容易更换其他视图技术；
6.   View——>渲染，View会根据传进来的Model模型数据进行渲染，此处的Model实际是一个Map数据结构，因此很容易支持其他视图技术；
7.   返回控制权给DispatcherServlet，由DispatcherServlet返回响应给用户，到此一个流程结束。

## Web View
### profile page
![](https://github.com/BranSummer/Resources/blob/master/branroom/webview1.jpg)

### chat page
![](https://github.com/BranSummer/Resources/blob/master/branroom/webview2.jpg)

### blog post
![](https://github.com/BranSummer/Resources/blob/master/branroom/webviewBlog1.jpg)

### blog home
![](https://github.com/BranSummer/Resources/blob/master/branroom/webviewBlog2.jpg)

## Update History

* 2017-11-12 15:28:56   
Complete this document
* 2017-11-24 14:11:49   
Add emoji picker
* 2018-4-27 21:56:34   
add blog module(supoting markdown)  
call turing robot API on chatting module