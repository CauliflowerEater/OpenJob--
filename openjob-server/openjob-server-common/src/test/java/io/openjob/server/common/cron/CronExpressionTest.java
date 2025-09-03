package io.openjob.server.common.cron;

import java.text.ParseException;
import java.util.Date;

import org.junit.jupiter.api.Test;


public class CronExpressionTest {
    @Test
    public void testExpression() throws ParseException {
        CronExpression cronExpression = new CronExpression("*/30 * * * * ?");
        String cronExpression1 = cronExpression.getCronExpression();
        cronExpression.getNextValidTimeAfter(new Date());
    }
}
