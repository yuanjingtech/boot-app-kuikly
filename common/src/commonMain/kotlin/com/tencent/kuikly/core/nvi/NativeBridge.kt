package com.tencent.kuikly.core.nvi

/**
 * Native bridge for Kuikly.
 * Required by KSP-generated code.
 */
public class NativeBridge {
    public var delegate: NativeBridgeDelegate? = null
    public var iosNativeBridgeDelegate: IOSNativeBridgeDelegate? = null

    public companion object {
        @PublishedApi
        internal var ctxThread: Boolean = false

        @PublishedApi
        internal fun setContextThread(value: Boolean) {
            ctxThread = value
        }
    }

    public interface NativeBridgeDelegate {
        public fun callNative(
            methodId: Int,
            arg0: Any?,
            arg1: Any?,
            arg2: Any?,
            arg3: Any?,
            arg4: Any?,
            arg5: Any?
        ): Any?
    }

    public interface IOSNativeBridgeDelegate {
        public fun callNative(
            methodId: Int,
            arg0: Any?,
            arg1: Any?,
            arg2: Any?,
            arg3: Any?,
            arg4: Any?,
            arg5: Any?
        ): Any?
    }
}
