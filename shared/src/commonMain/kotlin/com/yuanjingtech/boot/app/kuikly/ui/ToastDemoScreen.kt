package com.yuanjingtech.boot.app.kuikly.ui

import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tencent.kuikly.compose.foundation.background
import com.tencent.kuikly.compose.foundation.layout.Arrangement
import com.tencent.kuikly.compose.foundation.layout.Column
import com.tencent.kuikly.compose.foundation.layout.fillMaxSize
import com.tencent.kuikly.compose.foundation.layout.fillMaxWidth
import com.tencent.kuikly.compose.foundation.layout.padding
import com.tencent.kuikly.compose.material3.Button
import com.tencent.kuikly.compose.material3.ButtonDefaults
import com.tencent.kuikly.compose.material3.ExperimentalMaterial3Api
import com.tencent.kuikly.compose.material3.OutlinedTextField
import com.tencent.kuikly.compose.material3.Text
import com.tencent.kuikly.compose.ui.Alignment
import com.tencent.kuikly.compose.ui.Modifier
import com.tencent.kuikly.compose.ui.graphics.Color
import com.tencent.kuikly.compose.ui.platform.LocalActivity
import com.tencent.kuikly.compose.ui.text.font.FontWeight
import com.tencent.kuikly.compose.ui.unit.dp
import com.tencent.kuikly.compose.ui.unit.sp
import com.yuanjingtech.boot.app.kuikly.base.toast

/**
 * 示例 Composable - 用于测试和演示 ToastUtil
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ToastDemoScreen() {
    val pager = LocalActivity.current.getPager()
    var toastMessage by remember { mutableStateOf("这是一条提示信息") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Color(0xFFF5F5F5))
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {
        // 标题
        Text(
            text = "ToastUtil 演示",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A1A)
        )

        // 输入框
        OutlinedTextField(
            value = toastMessage,
            onValueChange = { toastMessage = it },
            label = { Text("Toast 消息内容") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            singleLine = false,
            maxLines = 3
        )

        // 显示 Toast 按钮
        Button(
            onClick = {
                if (toastMessage.isNotEmpty()) {
                    pager.toast(toastMessage)
                } else {
                    pager.toast("请输入消息内容")
                }
            },
            modifier = Modifier.padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF34C759)
            )
        ) {
            Text(
                text = "显示 Toast",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // 快捷示例按钮
        Button(
            onClick = {
                pager.toast("操作成功！")
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF007AFF)
            )
        ) {
            Text(
                text = "成功提示示例",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Button(
            onClick = {
                pager.toast("请输入完整信息")
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF9500)
            )
        ) {
            Text(
                text = "警告提示示例",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
