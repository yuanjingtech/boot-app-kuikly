# boot-app-kuikly
版本: 1.0.0-alpha.1
## 因果
问题: kuikly 缺少最佳实践、公共类库、常用框架、支持工具
目标: 简化kuikly app的开发

## 体用
### 关于boot-app-kuikly
结构
```
boot-app-kuikly/
├── androidApp/          # Android 应用入口
├── iosApp/             # iOS 应用入口
├── h5App/              # H5 应用入口
├── miniApp/            # 微信小程序入口
├── ohosApp/            # 鸿蒙应用入口
├── composeApp/         # Compose UI 测试/演示模块
├── shared/              # 跨平台共享代码
└── static_server/       # 静态资源服务器
```

[模块依赖](docs/dependency.plantuml)
用法  如何使用 boot-app-kuikly
1. 产物仓库依赖(待处理)
2. 直接使用github仓库
```kotlin
// 在 shared 模块中添加依赖
implementation("com.yuanjingtech.boot:shared:1.0.0")
```
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
- [x] 新增composeApp 用来编写测试/演示 , 依赖 shared,被 androidApp/h5App/miniApp 依赖

#### toastutil
结构
```
common/src/commonMain/kotlin/com/yuanjingtech/boot/app/kuikly/base/BridgeModule.kt  # toast 方法实现
common/src/commonMain/kotlin/com/yuanjingtech/boot/app/kuikly/base/ToastUtil.kt     # Pager 扩展函数
```
用法
```kotlin
import com.yuanjingtech.boot.app.kuikly.base.toast

// 在 Pager 中显示 Toast 提示
pager.toast("这是一条提示信息")

// 示例：表单验证提示
if (textFieldValue.isEmpty()) {
    localPager.toast("请输入PageName")
}
```

#### phoneutil
结构
```
common/src/commonMain/kotlin/com/yuanjingtech/boot/app/kuikly/base/BridgeModule.kt  # callPhone 方法实现
common/src/commonMain/kotlin/com/yuanjingtech/boot/app/kuikly/base/PhoneUtil.kt     # Pager 扩展函数
```
用法
```kotlin
import com.yuanjingtech.boot.app.kuikly.base.callPhone

// 在 Pager 中拨打电话
pager.callPhone("10086")

// 示例：点击按钮拨打客服电话
Button(onClick = {
    localPager.callPhone("400-123-4567")
}) {
    Text("联系客服")
}
```

