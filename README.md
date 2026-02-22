# boot-app-kuikly
版本: 1.0.0-alpha.1
## 因果
问题: kuikly 缺少最佳实践、公共类库、常用框架、支持工具
目标: 简化kuikly app的开发

## 体用
### 常用公共类库
#### 日历日期时间 ClockUtil
结构
```
shared/src/commonMain/kotlin/com/yuanjingtech/boot/app/kuikly/base/ClockUtil.kt          # expect 声明
shared/src/androidMain/kotlin/com/yuanjingtech/boot/app/kuikly/base/ClockUtil.android.kt # Android 实现
shared/src/iosMain/kotlin/com/yuanjingtech/boot/app/kuikly/base/ClockUtil.ios.kt        # iOS 实现
```
用法
```kotlin
import com.yuanjingtech.boot.app.kuikly.base.currentTimeMillis

// 获取当前时间戳（毫秒）
val timestamp = currentTimeMillis()
println("当前时间戳: $timestamp")
```
进度
- [x] 参考 zhuanzhuli-app-kuikly 的 TimeUtil 实现 ClockUtil.DateTime
- [] 

