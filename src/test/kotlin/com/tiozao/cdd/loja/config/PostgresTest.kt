package com.tiozao.cdd.loja.config

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase
import org.springframework.boot.test.context.SpringBootTest
import java.sql.SQLException
import javax.sql.DataSource


@SpringBootTest
@AutoConfigureTestDatabase
class PostgresTest {

    @Autowired
    lateinit var dataSource: DataSource

    @Test
     fun testSomething() {
        dataSource.getConnection().use { conn ->
            var qtd = conn.createStatement()
                .executeQuery("select * from autor")
                .fetchSize
            assertEquals(qtd, 0)
        }
    }

}