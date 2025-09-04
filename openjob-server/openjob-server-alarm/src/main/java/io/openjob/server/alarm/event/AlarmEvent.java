package io.openjob.server.alarm.event;

import org.springframework.context.ApplicationEvent;

import io.openjob.server.alarm.dto.AlarmEventDTO;


public class AlarmEvent extends ApplicationEvent {
    public AlarmEvent(AlarmEventDTO alarmEventDTO) {
        super(alarmEventDTO);
    }
}
