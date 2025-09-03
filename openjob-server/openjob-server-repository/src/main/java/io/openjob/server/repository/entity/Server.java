package io.openjob.server.repository.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

import lombok.Data;


@Data
@Entity
@Table(name = "`server`")
public class Server {
    @Id
    @Column(name = "`id`")
    @GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
    @GenericGenerator(name = "native", strategy = "native", parameters = {@Parameter(name = "sequence_name", value = "server_id")})
    private Long id;

    /**
     * Server IP
     */
    @Column(name = "`ip`")
    private String ip;

    /**
     * Server address
     */
    @Column(name = "`akka_address`")
    private String akkaAddress;

    /**
     * Server status
     */
    @Column(name = "`status`")
    private Integer status;

    @Column(name = "`deleted`")
    private Integer deleted;

    /**
     * Delete time
     */
    @Column(name = "`delete_time`")
    private Long deleteTime;

    /**
     * Create time
     */
    @Column(name = "`create_time`")
    private Long createTime;

    /**
     * Update time
     */
    @Column(name = "`update_time`")
    private Long updateTime;

    @Override
    public String toString() {
        return "Server{"
                + "id="
                + id
                + ", akkaAddress='" + akkaAddress + '\''
                + '}';
    }
}
