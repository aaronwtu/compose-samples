package com.example.jetcaster.core.data.repository

import com.example.jetcaster.core.data.Dispatcher
import com.example.jetcaster.core.data.JetcasterDispatchers
import com.example.jetcaster.core.data.database.dao.TransactionRunner
import com.example.jetcaster.core.data.network.PodcastsFetcher
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import kotlinx.coroutines.CoroutineDispatcher
import javax.inject.Inject

private var _userInfoCount: Int = -1

fun getUserInfoCount(): Int {
    _userInfoCount += 1
    return _userInfoCount
}

public enum class Gender {
    UNKNOW, MALE, FEMALE
}

public class UserInfo (
    public  var name: String = "Aaron${getUserInfoCount()}",
    var gender: Gender = Gender.MALE
) {
}

public class VipInfo @Inject constructor(
    public var isVip: Boolean = true
) {
}

public class UserInfoProvider @Inject constructor(
    public val userInfo: UserInfo,
    public val vipInfo: VipInfo
) {

}