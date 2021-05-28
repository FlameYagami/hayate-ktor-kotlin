package com.hayate.app.model.entity

import com.hayate.app.constant.DbConstant
import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable
import org.jetbrains.exposed.sql.jodatime.datetime

object Users : LongIdTable("t_dab_user") {

    val account = varchar(DbConstant.ACCOUNT, 64)
    val password = varchar(DbConstant.PASSWORD, 64)
    val nickname = varchar(DbConstant.NICKNAME, 64)
    val avatar = varchar(DbConstant.AVATAR, 128)
    val email = varchar(DbConstant.EMAIL, 64)
    val phone = long(DbConstant.PHONE)
    val createDate = datetime(DbConstant.CREATE_DATE)
    val updateDate = datetime(DbConstant.UPDATE_DATE)
    val enabled = varchar(DbConstant.ENABLED, 2)

    override val primaryKey = PrimaryKey(account)
}

class User(id: EntityID<Long>) : LongEntity(id) {
    companion object : LongEntityClass<User>(Users)
    val account = Users.account
    val password = Users.password
    val nickname = Users.nickname
    val avatar = Users.avatar
    val email = Users.email
    val phone = Users.phone
    val createDate = Users.createDate
    val updateDate = Users.updateDate
    val enabled = Users.enabled
}