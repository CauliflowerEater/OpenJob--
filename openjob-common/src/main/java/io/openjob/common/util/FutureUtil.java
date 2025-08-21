//@formatter:off
package io.openjob.common.util;

import java.util.concurrent.TimeUnit;

import akka.actor.ActorSelection;
import akka.pattern.Patterns;
import akka.util.Timeout;
import io.openjob.common.response.Result;
import scala.concurrent.Await;
import scala.concurrent.Future;
import scala.concurrent.duration.Duration;

public class FutureUtil {
    private FutureUtil() {

    }

    public static <T> T mustAsk(ActorSelection selection, Object request, Class<T> ignoredType, Long ms) {
        Timeout timeout = new Timeout(Duration.create(ms, TimeUnit.MILLISECONDS));
        Future<Object> future = Patterns.ask(selection, request, timeout);

        String path=selection.pathString();
        String anchor=selection.anchorPath().toString();
        try{
            @SuppressWarnings("unchecked")
            Result<T> result=(Result<T>)Await.result(future, timeout.duration());

            if(!ResultUtil.isSuccess(result)){
                throw new RuntimeException(String.format("Must ask result fail! message=%s path=%s anchor=%s",result.getMessage(),path,anchor));
            }

            return result.getData();
        }catch(Throwable ex){
            throw new RuntimeException(String.format("Must ask fail! path=%s anchor=%s",path,anchor), ex);
        }

    }
}
