package com.yuanjingtech.boot.app.kuikly.base

import kotlinx.cinterop.*
import platform.posix.*

/**
 * iOS 平台实现
 */
@OptIn(kotlinx.cinterop.ExperimentalForeignApi::class)
actual fun currentTimeMillis(): Long {
    return memScoped {
        val timeVal = alloc<timespec>()
        clock_gettime(CLOCK_REALTIME.convert(), timeVal.ptr)
        (timeVal.tv_sec * 1000L) + (timeVal.tv_nsec / 1_000_000L)
    }
}
