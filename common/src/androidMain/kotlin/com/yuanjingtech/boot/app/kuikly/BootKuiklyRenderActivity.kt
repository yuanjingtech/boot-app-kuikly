package com.yuanjingtech.boot.app.kuikly

import androidx.appcompat.app.AppCompatActivity
import com.tencent.kuikly.core.render.android.IKuiklyRenderExport
import com.tencent.kuikly.core.render.android.expand.KuiklyRenderViewBaseDelegatorDelegate
import com.yuanjingtech.boot.app.kuikly.module.KRBridgeModule

abstract class BootKuiklyRenderActivity : AppCompatActivity(),
    KuiklyRenderViewBaseDelegatorDelegate {
    override fun registerExternalModule(kuiklyRenderExport: IKuiklyRenderExport) {
        super.registerExternalModule(kuiklyRenderExport)
        with(kuiklyRenderExport) {
            moduleExport(KRBridgeModule.MODULE_NAME) {
                KRBridgeModule()
            }
        }
    }
}