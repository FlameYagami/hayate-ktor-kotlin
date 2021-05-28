package com.hayate.common.config

import com.zaxxer.hikari.HikariConfig
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import javax.sql.DataSource

object DatabaseFactory {

    fun create(): DataSource {
        val config = HikariConfig().apply {
            driverClassName = "com.mysql.jdbc.Driver"
            jdbcUrl = "jdbc:mysql://39.108.79.150:3306/schwertkreuz?useUnicode=true&characterEncoding=utf-8&useSSL=false&serverTimezone=UTC&zeroDateTimeBehavior=convertToNull"
            username = "flame"
            password = "4985216"
            maximumPoolSize = 3
            isAutoCommit = false
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }
        return HikariDataSource(config)
    }

    suspend fun <T> dbQuery(block: suspend () -> T): T = newSuspendedTransaction { block() }

}