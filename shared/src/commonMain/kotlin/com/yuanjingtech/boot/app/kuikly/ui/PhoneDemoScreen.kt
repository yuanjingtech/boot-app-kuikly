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
import com.yuanjingtech.boot.app.kuikly.base.callPhone
import com.yuanjingtech.boot.app.kuikly.base.toast

/**
 * 示例 Composable - 用于测试和演示 PhoneUtil
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PhoneDemoScreen() {
    val pager = LocalActivity.current.getPager()
    var phoneNumber by remember { mutableStateOf("") }

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
            text = "PhoneUtil 演示",
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1A1A1A)
        )

        // 输入框
        OutlinedTextField(
            value = phoneNumber,
            onValueChange = { phoneNumber = it },
            label = { Text("电话号码") },
            placeholder = { Text("请输入电话号码") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 32.dp),
            singleLine = true
        )

        // 拨打电话按钮
        Button(
            onClick = {
                if (phoneNumber.isNotEmpty()) {
                    pager.callPhone(phoneNumber)
                } else {
                    pager.toast("请输入电话号码")
                }
            },
            modifier = Modifier.padding(top = 24.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF34C759)
            )
        ) {
            Text(
                text = "拨打电话",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        // 快捷示例按钮
        Button(
            onClick = {
                pager.callPhone("10086")
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF007AFF)
            )
        ) {
            Text(
                text = "中国移动客服 (10086)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Button(
            onClick = {
                pager.callPhone("10010")
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFF5856D6)
            )
        ) {
            Text(
                text = "中国联通客服 (10010)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }

        Button(
            onClick = {
                pager.callPhone("110")
            },
            modifier = Modifier.padding(top = 16.dp),
            colors = ButtonDefaults.buttonColors(
                containerColor = Color(0xFFFF3B30)
            )
        ) {
            Text(
                text = "紧急报警 (110)",
                fontSize = 16.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
