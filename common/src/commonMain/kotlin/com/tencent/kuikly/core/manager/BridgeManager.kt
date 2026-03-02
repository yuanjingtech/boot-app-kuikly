package com.tencent.kuikly.core.manager

/**
 * Bridge manager for Kuikly.
 * Required by KSP-generated code.
 */
public object BridgeManager {
    public var currentPageId: String = ""
    public fun isDidInit(): Boolean = false
    public fun init() {}
    public fun registerNativeBridge(pageName: String, nativeBridge: Any) {}
    public fun callKotlinMethod(methodId: Int, arg0: Any?, arg1: Any?, arg2: Any?, arg3: Any?, arg4: Any?, arg5: Any?) {}
    public fun registerPageRouter(pageName: String, factory: () -> Any) {}
    public fun callExceptionMethod(message: String) {}
    public fun isPageExist(pageName: String): Boolean = false
}
