freemarker
  是一个模板框架，用于实现页面静态化
 使用步骤:
  1 导入依赖
      <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-freemarker</artifactId>
     </dependency>
  2 在resources/templates目录下创建模板文件
  3 常用指令
 ---------------支付宝---------------------------
 rsa：非对称加密,即加密和解密使用不同的key
 使用步骤:
   1 创建应用
   2 设置rsa密钥
   3 获取支付宝公钥
   4 提交审核

 -----------------MQ：消息中间件(服务器)-----------------------------
    使用场景
        不同系统之间交换数据
 1 ActiveMQ     apache
 2 RocketMQ     ali
 3 RabbitMQ
 4 kafka        apache
 JMS规范:
    java message service
 有两种消息类型:
    1 queue队列
        特点:一对一

    2 topic主题
        特点:一对多






































