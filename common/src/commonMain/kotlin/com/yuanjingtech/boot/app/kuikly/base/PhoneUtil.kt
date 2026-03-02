package com.yuanjingtech.boot.app.kuikly.base

import com.tencent.kuikly.core.pager.IPager

fun IPager.callPhone(phoneNumber: String) {
    this.bridgeModule().callPhone(phoneNumber)
}
