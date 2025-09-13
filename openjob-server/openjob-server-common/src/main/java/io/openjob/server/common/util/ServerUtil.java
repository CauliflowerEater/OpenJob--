package io.openjob.server.common.util;

import akka.actor.ActorSelection;
import akka.actor.ActorSystem;
import io.openjob.common.OpenjobSpringContext;
import io.openjob.common.constant.AkkaConstant;
import io.openjob.server.common.constant.ServerActorConstant;

public class ServerUtil {

    /**
     * Cluster actor
     *
     * @param address address
     * @return actor
     */
    public static ActorSelection getServerClusterActor(String address) {
        return OpenjobSpringContext
                .getBean(ActorSystem.class)
                .actorSelection(getServerActorPath(address, ServerActorConstant.ACTOR_CLUSTER));
    }

    /**
     * Heart beat actor
     *
     * @param address address
     * @return actor
     */
    public static ActorSelection getServerHeartbeatActor(String address) {
        return OpenjobSpringContext
                .getBean(ActorSystem.class)
                .actorSelection(getServerActorPath(address, ServerActorConstant.ACTOR_HEARTBEAT));
    }

    /**
     * Task master
     *
     * @param address address
     * @return actor
     */
    public static ActorSelection getWorkerTaskMasterActor(String address) {
        return OpenjobSpringContext
                .getBean(ActorSystem.class)
                .actorSelection(getWorkerActorPath(address, AkkaConstant.WORKER_ACTOR_MASTER));
    }

    /**
     * Delay master
     *
     * @param address address
     * @return actor
     */
    public static ActorSelection getWorkerDelayMasterActor(String address) {
        return OpenjobSpringContext
                .getBean(ActorSystem.class)
                .actorSelection(getWorkerActorPath(address, AkkaConstant.WORKER_ACTOR_DELAY_MASTER));
    }


    /**
     * @param address address
     * @param name    actor name
     * @return actor path
     */
    public static String getServerActorPath(String address, String name) {
        return String.format(AkkaConstant.AKKA_PATH_FORMAT, AkkaConstant.SERVER_SYSTEM_NAME, address, name);
    }

    /**
     * @param address address
     * @param name    actor name
     * @return actor path
     */
    public static String getWorkerActorPath(String address, String name) {
        return String.format("akka://%s@%s/user/%s", AkkaConstant.WORKER_SYSTEM_NAME, address, name);
    }
}
