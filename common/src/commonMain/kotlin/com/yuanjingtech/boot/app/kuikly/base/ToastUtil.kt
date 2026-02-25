package com.yuanjingtech.boot.app.kuikly.base

import com.tencent.kuikly.core.pager.IPager

fun IPager.toast(content: String) {
    this.bridgeModule().toast(content)
}
