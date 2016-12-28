# JMS

Java Message Service (JMS) API是一个 Java 面向消息中间件的 API，用于两个或者多个客户端之间发送消息。
 
JMS 的目标包括：

* 包含实现复杂企业应用所需要的功能特性；
* 定义了企业消息概念和功能的一组通用集合；
* 最小化这些 Java 程序员必须学习以使用企业消息产品的概念集合；
* 最大化消息应用的可移植性。
 
JMS 支持企业消息产品提供两种主要的消息风格：

* 点对点（Point-to-Point，PTP）消息风格：允许一个客户端通过一个叫“队列（queue）”的中间抽象发送一个消息给另一个客户端。发送消息的客户端将一个消息发送到指定的队列中，接收消息的客户端从这个队列中抽取消息。
* 发布订阅（Publish/Subscribe，Pub/Sub）消息风：则允许一个客户端通过一个叫“主题（topic）”的中间抽象发送一个消息给多个客户端。发送消息的客户端将一个消息发布到指定的主题中，然后这个消息将被投递到所有订阅了这个主题的客户端。

### JMS API

由于历史的原因，JMS 提供四组用于发送和接收消息的接口。

* JMS1.0 定义了两个特定领域相关的API，一个用于点对点的消息处理（queue），一个用于发布订阅的消息处理（topic）。尽管由于向后兼容的理由这些接口一直被保留在 JMS 中，但是在以后的 API 中应该考虑被废弃掉。
* JMS1.1 引入了一个新的统一的一组 API，可以同时用于点对点和发布订阅消息模式。这也被称作标准（standard） API。
* JMS2.0引入了一组简化 API，它拥有标准 API 的全部特性，同时接口更少、使用更方便。

以上每组 API 提供一组不同的接口集合，用于连接到 JMS 提供者、发送和接收消息。因此，它们共享一组代表消息、消息目的地和其他各方面功能特性的通用接口。

下面是使用标准 API 来发送信息的例子：

```java
@Resource(lookup = "jms/connectionFactory ") 
ConnectionFactory connectionFactory;

@Resource(lookup="jms/inboundQueue")
Queue inboundQueue;

public void sendMessageOld (String payload) throws JMSException{
    try (Connection connection = connectionFactory.createConnection()) {
        Session session = connection.createSession();
        MessageProducer messageProducer =
        session.createProducer(inboundQueue);
        TextMessage textMessage =
        session.createTextMessage(payload);
        messageProducer.send(textMessage);
    }
}
```

下面是使用简化 API 来发送信息的例子：

```java
@Resource(lookup = "jms/connectionFactory")
ConnectionFactory connectionFactory;

@Resource(lookup="jms/inboundQueue")
Queue inboundQueue;

public void sendMessageNew (String payload) {
    try (MessagingContext context = connectionFactory.createMessagingContext();){
        context.send(inboundQueue,payload);
    }
}
```

所有的接口都在 [javax.jms](http://docs.oracle.com/javaee/7/api/javax/jms/package-summary.html) 包下。

如果读者想了解更多有关 JMS 的规范，可以在线查阅 <https://java.net/projects/jms-spec/pages/Home> 。