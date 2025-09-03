package io.openjob.server.repository;

import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.jdbc.SqlMergeMode;
import org.springframework.transaction.annotation.Transactional;

import io.openjob.server.repository.config.H2Config;


@SpringBootTest(classes = {H2Config.class, RepositoryApplication.class})
@Transactional
@SqlMergeMode(SqlMergeMode.MergeMode.MERGE)
public class RepositoryTest {
}
