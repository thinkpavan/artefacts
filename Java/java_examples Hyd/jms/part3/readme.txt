If messages have been received from a queue but not acknowledged when a session terminates, the JMS provider retains them and redelivers them when a consumer next accesses the queue.


Unacknowledged messages for a nondurable TopicSubscriber are dropped when the session is closed. 


provider also retains unacknowledged messages for a terminated session with a durable TopicSubscriber.

In case of queue or a durable subscription, we can use the Session.recover method to 
stop a nontransacted session and restart it with its first unacknowledged message.

In case of nondurable TopicSubscriber, the provider may drop unacknowledged 
messages when its session is recovered


AUTO_ACK::
--------------------
With a message listener, the automatic acknowledgment happens when the onMessage
method returns.

With a synchronous receive, the acknowledgment happens immediately after the receive call. so what's the problem ????