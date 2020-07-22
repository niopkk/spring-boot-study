
### 本文讲一个spring security自定义filter非常容易出现的一个问题，那就是filter被执行两遍。


在spring容器托管的GenericFilterBean的bean，都会自动加入到servlet的filter chain，
而上面的定义，还额外把filter加入到了spring security的AnonymousAuthenticationFilter之前。
而spring security也是一系列的filter，在mvc的filter之前执行。因此在鉴权通过的情况下，就会先后各执行一次。
原文地址
https://juejin.im/post/5a1b771251882575cb73d102

