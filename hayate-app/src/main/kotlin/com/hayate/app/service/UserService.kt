package com.hayate.app.service

import com.hayate.app.constant.DbConstant
import com.hayate.app.model.entity.User
import com.hayate.app.model.entity.Users
import org.jetbrains.exposed.sql.and
import org.jetbrains.exposed.sql.select
import org.jetbrains.exposed.sql.update

class UserService {

    // 检测账号是否存在
    suspend fun checkAccountExist(account: String): Boolean {
        return null == findByAccount(account)
    }

    // 通过账户名查询用户
    suspend fun findByAccount(account: String): User? {
        val query = Users.select { Users.account eq account and (Users.enabled eq DbConstant.ENABLE) }
        return User.wrapRows(query).toList().firstOrNull()
    }

    // 修改密码
    suspend fun changePassword(account: String, password: String) {
        Users.update({ Users.account eq account and (Users.enabled eq DbConstant.ENABLE) }) {
            it[Users.password] = password
        }
    }

    // 修改昵称
    suspend fun changeNickname(userId: Long, nickname: String) {
        Users.update({ Users.id eq userId and (Users.enabled eq DbConstant.ENABLE) }) {
            it[Users.nickname] = nickname
        }
    }

    // 修改头像
    suspend fun changeAvatar(userId: Long, avatarPath: String) {
        Users.update({ Users.id eq userId and (Users.enabled eq DbConstant.ENABLE) }) {
            it[avatar] = avatarPath
        }
    }

    // 屏蔽用户
    suspend fun disableUser(userId: Long) {
        Users.update({ Users.id eq userId }) {
            it[enabled] = DbConstant.DISABLE
        }
    }
}