package io.openjob.server.common.actor;

import org.springframework.context.ApplicationContext;

import akka.actor.Actor;
import akka.actor.IndirectActorProducer;

public class ActorProducer implements IndirectActorProducer {
    private final ApplicationContext context;
    private final String beanName;

    public ActorProducer(ApplicationContext context, String beanName) {
        this.context = context;
        this.beanName = beanName;
    }

    @Override
    public Actor produce() {
        return (Actor) context.getBean(beanName);
    }

    @Override
    public Class<? extends Actor> actorClass() {
        return (Class<? extends Actor>) context.getBean(beanName);
    }
}
