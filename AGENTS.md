# HealthApp Codex 开发规则

## 开始工作前

1. 本项目固定使用 Java + XML + Android Views + Room，单 `app` module。
2. 先完整阅读 `docs/PRD.md`、`docs/TEAM.md`、`docs/DEVELOPMENT_GUIDE.md` 和 `docs/MEMBER_GUIDE.md`。
3. 确认当前成员、所属 Java 包、XML 前缀和 Git 工作区状态后再修改。

## 架构与范围

- 遵守 `com.example.healthapp` 下已有的公共 Entity、DAO、`AppDatabase`、`HealthRepository`、日期格式和单位。
- 页面使用 `MainActivity` + Fragment；业务逻辑不得堆入 `MainActivity`。
- 不得使用 Kotlin、Jetpack Compose、Flutter 或 React Native 重写项目。
- 不得增加后端、网络服务、云数据库、远程登录或 `INTERNET` 权限。
- 不得自行改造成多 module、增加复杂依赖注入框架或重新设计整个架构。
- 修改尽量限制在当前成员负责的包和资源前缀内；不得未经确认修改其他成员已经完成的业务。

## 公共文件

- `MainActivity.java`、`common/`、`model/`、`database/`、`activity_main.xml`、导航、values、Manifest、Gradle、docs 和本文件是公共内容，原则上由成员 1 维护。
- 不得随意修改 `AppDatabase`、公共 Entity、DAO 或 `HealthRepository` 的方法名、参数、返回类型、字段、单位和空值规则。
- 必须修改公共文件时，先说明原因、数据库版本/迁移、接口兼容性和受影响成员，再取得确认。
- 未经确认不得修改 Gradle、SDK、AGP、依赖版本或 Manifest 权限。

## 数据与异步

- 全 App 只能通过 `AppDatabase.getInstance(context)` 使用一个 `health_app.db`。
- DAO 调用必须在 `DatabaseExecutor` 等后台线程中；禁止 `allowMainThreadQueries()`。
- 跨模块读取优先使用 `HealthRepository`，不得依赖其他模块的 Fragment 或 Adapter。
- 日期用 `yyyy-MM-dd`，完整时刻用 epoch milliseconds；单位遵守开发规范。
- 不得用写死的模拟数据冒充正式结果；无数据和读取失败必须分开处理。

## Git 与交付

- 不得自行执行 `git push`、`git reset`、`git clean`、force push 或可能覆盖共享工作的操作。
- 保留用户和其他成员已有修改，不覆盖、不回退无关内容。
- 每次完成后列出新增/修改/删除文件，说明真实执行的测试和未验证项。
- 未实际执行的构建、测试或模拟器检查，不得描述为已经通过。
- 提交前至少建议执行 `testDebugUnitTest` 和 `assembleDebug`；公共集成由成员 1 负责。
