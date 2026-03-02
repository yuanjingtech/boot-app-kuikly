package com.tencent.kuikly.core

/**
 * Kuikly core entry interface.
 * Required by KSP-generated code.
 */
public interface IKuiklyCoreEntry {
    public var delegate: Delegate?

    public fun callKotlinMethod(
        methodId: Int,
        arg0: Any?,
        arg1: Any?,
        arg2: Any?,
        arg3: Any?,
        arg4: Any?,
        arg5: Any?
    ): Unit

    public fun triggerRegisterPages(): Unit

    public interface Delegate {
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
