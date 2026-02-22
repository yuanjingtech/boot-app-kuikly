package com.yuanjingtech.boot.app.kuikly.base

import com.tencent.kuikly.core.pager.IPager

/**
 * 日历日期时间工具类
 * 使用 expect/actual 模式实现跨平台兼容
 */

/**
 * 获取当前时间戳（毫秒）
 */
internal expect fun currentTimeMillis(): Long
fun IPager.currentTimeMillis(): Long {
    return currentTimeMillis()
}


fun IPager.dateFormatter(timestamp: Long, format: String): String {
    return Utils.bridgeModule(this).dateFormatter(timestamp, format)
}

