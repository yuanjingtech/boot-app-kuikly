package com.yuanjingtech.boot.app.kuikly.ui


import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableLongStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.tencent.kuikly.compose.foundation.background
import com.tencent.kuikly.compose.foundation.layout.Arrangement
import com.tencent.kuikly.compose.foundation.layout.Column
import com.tencent.kuikly.compose.foundation.layout.fillMaxSize
import com.tencent.kuikly.compose.foundation.layout.padding
import com.tencent.kuikly.compose.material3.Button
import com.tencent.kuikly.compose.material3.ButtonDefaults
import com.tencent.kuikly.compose.material3.Text
import com.tencent.kuikly.compose.ui.Alignment
import com.tencent.kuikly.compose.ui.Modifier
import com.tencent.kuikly.compose.ui.graphics.Color
import com.tencent.kuikly.compose.ui.platform.LocalActivity
import com.tencent.kuikly.compose.ui.text.font.FontWeight
import com.tencent.kuikly.compose.ui.unit.dp
import com.tencent.kuikly.compose.ui.unit.sp
import com.yuanjingtech.boot.app.kuikly.base.currentTimeMillis
import com.yuanjingtech.boot.app.kuikly.base.dateFormatter

/**
 * 示例 Composable - 用于测试和演示 ClockUtil
 */
@Composable
fun DemoScreen() {
    val pager = LocalActivity.current.getPager()
    var timestamp by remember { mutableLongStateOf(0L) }
    var formattedDate by remember { mutableStateOf("") }

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
            text = "ClockUtil 演示",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A1A)
        )

        // 时间戳显示
        Text(
            text = "当前时间戳: $timestamp ms",
            fontSize = 16.sp,
            color = Color(0xFF666666),
            modifier = Modifier.padding(top = 24.dp)
        )

        // 格式化日期显示 (使用 ClockUtil.dateFormatter)
        if (formattedDate.isNotEmpty()) {
            Text(
                text = "格式化时间: $formattedDate",
                fontSize = 16.sp,
                color = Color(0xFF007AFF),
                fontWeight = FontWeight.Medium,
                modifier = Modifier.padding(top = 8.dp)
            )
        }

        // 获取时间戳按钮
        Button(
            onClick = {
                // 使用 ClockUtil 获取当前时间戳
                timestamp = pager.currentTimeMillis()
                formattedDate = pager.dateFormatter(timestamp, "yyyy-MM-dd HH:mm:ss")
            },
            modifier = Modifier.padding(top = 32.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF007AFF)
            )
        ) {
            Text(
                text = "获取当前时间",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
