package io.openjob.server.scheduler.scheduling;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import io.openjob.server.scheduler.service.ClearService;

/**
 * 时间轮系统的清理类;
 * 负责的是定期清理历史Job instance;
 */
@Component
public class ClearScheduling {
    private final ClearService clearService;

    @Autowired
    public ClearScheduling(ClearService clearService) {
        this.clearService = clearService;
    }

    @Scheduled(cron = "0 0 0 * * ?")
    public void clearData() {
        this.clearService.clearData();
    }
}
