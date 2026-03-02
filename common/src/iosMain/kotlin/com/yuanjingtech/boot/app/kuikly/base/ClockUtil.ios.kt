package com.yuanjingtech.boot.app.kuikly.base

import kotlinx.cinterop.ExperimentalForeignApi
import kotlinx.cinterop.alloc
import kotlinx.cinterop.convert
import kotlinx.cinterop.memScoped
import kotlinx.cinterop.ptr
import platform.posix.CLOCK_REALTIME
import platform.posix.clock_gettime
import platform.posix.timespec

/**
 * iOS 平台实现
 */
@OptIn(ExperimentalForeignApi::class)
actual fun currentTimeMillis(): Long {
    return memScoped {
        val timeVal = alloc<timespec>()
        clock_gettime(CLOCK_REALTIME.convert(), timeVal.ptr)
        (timeVal.tv_sec * 1000L) + (timeVal.tv_nsec / 1_000_000L)
    }
}
