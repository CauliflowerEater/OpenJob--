package io.openjob.server.alarm.channel;

import io.openjob.server.alarm.dto.AlarmDTO;
import io.openjob.server.repository.constant.AlertMethodEnum;


public interface AlarmChannel {

    /**
     * Send
     *
     * @param alarmDTO alarmDTO
     */
    void send(AlarmDTO alarmDTO);

    /**
     * Channel type.
     *
     * @return AlertMethodEnum
     */
    AlertMethodEnum channel();
}
