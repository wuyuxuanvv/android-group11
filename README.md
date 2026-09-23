# HealthApp — Personal Health Management System

### City University of Hong Kong | EE5415 Course Project

**Group 11 · Android Application Development**

[English](#english) | [简体中文](#简体中文)

---

# English

## 1. Project Overview

HealthApp is a personal health management Android application developed as a group course project for **EE5415 at the City University of Hong Kong (CityUHK)**.

The project is developed by Group 11, a team of six students, with the aim of creating a simple and accessible application that helps users manage their daily exercise, dietary intake, and sleep habits.

By integrating exercise tracking, dietary management, sleep recording, and personal health statistics into a single application, HealthApp provides users with a convenient way to monitor their daily activities and track their progress toward personal health goals.

The application is designed to operate offline, with user data stored locally on the Android device.

**Project Information**

| Item | Description |
|---|---|
| Institution | City University of Hong Kong (CityUHK) |
| Course | EE5415 |
| Project | Personal Health Management Android Application |
| Group | Group 11 |
| Team Size | 6 Members |
| Platform | Android |
| Development Language | Java |
| UI Development | XML |
| Local Database | Room (SQLite) |
| Development Environment | Android Studio |
| Version Control | Git & GitHub |

> **Project Status:** Under Development
>
> The initial Android project and shared development framework have been established. Individual functional modules are being developed and integrated by the team.

---

## 2. Key Features

HealthApp is designed around five primary functional modules.

### 2.1 Personal Profile

Users can create and manage their personal health profiles.

Planned features include:

- Personal information management, including age, gender, height, and weight.
- Weekly exercise goal configuration.
- Daily calorie intake target.
- Daily sleep duration target.
- Local storage and modification of personal information.

Personal information will be used to support exercise calorie estimation, goal tracking, and health statistics.

### 2.2 Exercise Management

The exercise module allows users to record daily physical activities and manage weekly exercise plans.

Planned features include:

- Exercise library with visual demonstrations.
- Exercise selection and duration recording.
- Estimated calorie expenditure based on exercise type, duration, and body weight.
- Weekly exercise plan creation and management.
- Exercise completion tracking.
- Exercise history.

Calorie expenditure is calculated using a simplified MET-based estimation method.

The calculated values are intended for general reference rather than precise physiological measurement.

### 2.3 Dietary Management

The dietary module helps users monitor their daily food consumption and nutritional intake.

Planned features include:

- Built-in food database with nutritional information.
- Food search and selection.
- Food intake recording by weight.
- Meal categorization: breakfast, lunch, dinner, and snacks.
- Daily calorie and macronutrient calculations.
- Comparison between actual calorie intake and daily calorie targets.
- Dietary history.

Nutritional information is calculated based on the recorded food quantities and the corresponding values in the food database.

### 2.4 Sleep Management

The sleep module provides a simple way to record sleeping habits and monitor sleep duration.

Planned features include:

- Manual recording of bedtime and wake-up time.
- Automatic calculation of total sleep duration.
- Support for sleep sessions spanning midnight.
- Sleep history.
- Comparison between actual sleep duration and personal sleep goals.
- Simple rule-based sleep feedback.

The application does not require wearable devices or external sleep monitoring equipment.

### 2.5 Dashboard and Health Statistics

The dashboard integrates information from the exercise, dietary, and sleep modules.

Planned features include:

- Daily exercise completion statistics.
- Daily calorie intake summary.
- Recent sleep duration.
- Personal goal tracking.
- Historical records.
- Weekly activity and health trends.
- Simple rule-based feedback based on recorded data.

The dashboard provides a centralized overview of users' daily health management activities.

---

## 3. Technology Stack

HealthApp is developed as a native Android application.

| Component | Technology |
|---|---|
| Programming Language | Java |
| User Interface | XML / Android Views |
| Development Environment | Android Studio |
| Database | Room (SQLite) |
| Application Architecture | Activity + Fragment |
| Data Visualization | Android UI Components |
| Version Control | Git |
| Collaboration Platform | GitHub |

The application follows a modular development approach.

Each team member is responsible for a designated functional module, while shared database structures, navigation components, and development interfaces are maintained within the common project framework.

### Offline-First Design

HealthApp is designed to operate without a backend server.

User profiles, exercise records, dietary records, and sleep records are stored locally using Room.

The project does not require cloud storage, online accounts, or external AI services for its core functionality.

---

## 4. Project Structure

The Android project is organized into functional packages to support collaborative development.

```text
android-group11/
│
├── app/
│   └── src/main/
│       │
│       ├── java/
│       │   └── com/example/healthapp/
│       │       │
│       │       ├── MainActivity.java
│       │       │
│       │       ├── common/
│       │       ├── database/
│       │       ├── model/
│       │       ├── profile/
│       │       ├── exercise/
│       │       ├── diet/
│       │       ├── sleep/
│       │       ├── home/
│       │       └── extra/
│       │
│       └── res/
│           ├── layout/
│           ├── drawable/
│           └── values/
│
├── docs/
│   ├── PRD.md
│   ├── TEAM.md
│   ├── DEVELOPMENT_GUIDE.md
│   └── MEMBER_GUIDE.md
│
├── AGENTS.md
│
└── README.md
```

The structure separates shared infrastructure from individual functional modules.

Each team member develops their assigned functionality within the corresponding package while following the shared development guidelines.

---

## 5. Team Collaboration

HealthApp is developed collaboratively by six students from Group 11.

| Member | Responsibilities |
|---|---|
| Member 1 | Project framework, database infrastructure, navigation, personal profile, and final integration |
| Member 2 | Exercise tracking, calorie estimation, weekly exercise plans, and exercise records |
| Member 3 | Food database, dietary recording, nutritional calculations, and calorie target management |
| Member 4 | Sleep recording, duration calculation, and sleep feedback |
| Member 5 | Dashboard, health statistics, historical records, and trend visualization |
| Member 6 | Goal recommendations, reminders, data management, and application testing |

All team members work within the same Android project and follow a unified database and interface specification.

Individual development takes place on dedicated Git branches, with completed functionality integrated into the main branch through Pull Requests.

---

## 6. Getting Started

### Requirements

- Android Studio
- Android SDK
- Git
- Android emulator or a physical Android device

### Installation

**Step 1: Clone the repository**

Clone the project using GitHub or Android Studio's version control functionality.

```bash
git clone <REPOSITORY_URL>
```

Replace `<REPOSITORY_URL>` with the actual URL of this repository.

**Step 2: Open the project**

Open Android Studio and select the cloned project directory.

**Step 3: Synchronize Gradle**

Allow Android Studio to complete Gradle synchronization and download the required dependencies.

**Step 4: Run the application**

Select an Android emulator or connect a physical Android device.

Click **Run 'app'** in Android Studio to build and launch the application.

> The repository is private. Access is restricted to authorized project collaborators.

---

## 7. Development Documentation

The following documents provide detailed specifications and development instructions.

| Document | Description |
|---|---|
| `docs/PRD.md` | Product requirements and functional specifications |
| `docs/TEAM.md` | Team responsibilities and module assignments |
| `docs/DEVELOPMENT_GUIDE.md` | Project architecture, database structures, shared interfaces, and coding conventions |
| `docs/MEMBER_GUIDE.md` | Individual development instructions and GitHub collaboration guidelines |
| `AGENTS.md` | Development instructions for AI-assisted coding tools |

**All team members should read the relevant documentation before modifying the project.**

Changes to shared database structures, public interfaces, or core project configurations should be coordinated with the project integration maintainer.

---

## 8. Project Scope

This application is developed for educational purposes as part of the EE5415 course project at City University of Hong Kong.

HealthApp is intended to support general health habit tracking and personal activity management.

It is not designed to provide medical diagnoses, clinical assessments, or professional medical advice.

Exercise calorie expenditure and nutritional calculations are estimates based on predefined reference data.

---

# 简体中文

## 1. 项目简介

HealthApp 是一款个人健康管理安卓应用，由**香港城市大学（City University of Hong Kong，CityUHK）EE5415 课程第 11 小组**开发，属于本课程的六人合作课程设计项目。

本项目旨在开发一款简单、直观且易于使用的健康管理应用，帮助用户记录日常运动、饮食和睡眠情况，并通过数据统计和目标管理，了解个人健康习惯的变化。

应用将运动记录、饮食管理、睡眠管理和健康数据统计整合在同一平台中，使用户能够便捷地记录日常活动、查看历史数据，并追踪个人健康管理目标的完成情况。

本项目采用 Android 原生开发技术，使用 Java 编写程序逻辑，XML 构建用户界面，Room 数据库实现本地数据持久化。

应用采用离线优先设计，核心功能无需依赖服务器或互联网连接。

**项目基本信息**

| 项目 | 内容 |
|---|---|
| 所属院校 | 香港城市大学（CityUHK） |
| 所属课程 | EE5415 |
| 项目名称 | 个人健康管理安卓应用 |
| 开发小组 | Group 11 |
| 小组人数 | 6 人 |
| 目标平台 | Android |
| 开发语言 | Java |
| 界面技术 | XML |
| 本地数据库 | Room（SQLite） |
| 开发工具 | Android Studio |
| 版本管理 | Git & GitHub |

> **当前状态：开发中**
>
> 项目初始工程及公共开发框架已搭建完成，各成员正在按照分工逐步开发和集成具体功能模块。

---

## 2. 主要功能

HealthApp 主要包含个人资料、运动管理、饮食管理、睡眠管理和健康数据统计五个功能模块。

### 2.1 个人资料管理

用户可以在首次使用应用时填写个人基本信息，并设置健康管理目标。

主要功能包括：

- 年龄、性别、身高和体重管理。
- 每周运动目标次数设置。
- 每日摄入热量目标设置。
- 每日睡眠时长目标设置。
- 个人信息的本地保存与修改。

用户的个人资料将用于运动热量估算、目标完成情况统计及其他相关功能。

### 2.2 运动管理

运动模块用于记录用户的日常运动情况，并帮助用户制定和执行每周运动计划。

主要功能包括：

- 内置运动动作库及动作演示。
- 运动动作选择和运动时长记录。
- 根据运动类型、运动时长和用户体重估算运动消耗热量。
- 每周运动计划制定。
- 运动计划打卡。
- 运动历史记录查询。

运动热量采用基于 MET（代谢当量）的简化计算方法进行估算。

计算结果仅供参考，不代表精确的实际能量消耗。

### 2.3 饮食管理

饮食模块用于记录用户的日常饮食，并统计热量及主要营养素摄入情况。

主要功能包括：

- 内置食物数据库及营养信息。
- 食物搜索与选择。
- 根据食物重量记录实际摄入量。
- 早餐、午餐、晚餐和加餐分类记录。
- 每日热量及宏量营养素计算。
- 实际摄入热量与每日热量目标对比。
- 饮食历史记录查询。

用户可以通过输入食物摄入重量，获取对应的热量和营养素估算结果。

### 2.4 睡眠管理

睡眠模块用于记录用户的睡眠时间，并统计睡眠时长。

主要功能包括：

- 手动记录入睡时间和起床时间。
- 自动计算总睡眠时长。
- 支持跨午夜睡眠记录。
- 睡眠历史记录查询。
- 实际睡眠时长与个人目标对比。
- 基于固定规则生成简单睡眠反馈。

本项目第一版不接入智能手表等穿戴设备，也不涉及复杂的睡眠阶段分析。

### 2.5 首页与健康数据统计

首页负责整合运动、饮食和睡眠三个模块的数据，为用户提供统一的健康管理概览。

主要功能包括：

- 当日运动完成次数统计。
- 当日摄入热量汇总。
- 最近一晚睡眠时长展示。
- 个人健康目标完成情况。
- 历史记录查询。
- 每周数据变化趋势。
- 基于实际记录的简单目标反馈。

通过统一的数据统计页面，用户可以了解自己的日常健康管理情况，并追踪个人目标的完成进度。

---

## 3. 技术架构

本项目采用 Android 原生开发方案。

| 技术领域 | 技术选型 |
|---|---|
| 编程语言 | Java |
| 用户界面 | XML / Android Views |
| 开发环境 | Android Studio |
| 本地数据库 | Room（SQLite） |
| 页面管理 | Activity + Fragment |
| 版本管理 | Git |
| 团队协作 | GitHub |

项目采用模块化开发方式。

运动、饮食、睡眠、首页及个人资料等功能模块分别由不同成员负责，各模块通过统一的数据库结构和公共接口实现数据交互。

### 离线设计

本项目不开发远程后端服务。

用户的个人资料、运动记录、饮食记录和睡眠记录均保存在设备本地。

核心功能无需依赖云端数据库、在线账号系统或外部 AI 服务。

---

## 4. 项目结构

项目采用统一的 Android 工程，各成员在对应的功能模块中独立开发。

主要目录包括：

- `common/`：公共接口及工具类。
- `database/`：Room 数据库基础配置和数据访问接口。
- `model/`：公共数据模型。
- `profile/`：个人资料模块。
- `exercise/`：运动管理模块。
- `diet/`：饮食管理模块。
- `sleep/`：睡眠管理模块。
- `home/`：首页与数据统计模块。
- `extra/`：扩展功能模块。
- `docs/`：项目需求、分工及开发规范文档。

详细目录结构及代码使用方式请参考：

`docs/DEVELOPMENT_GUIDE.md`

---

## 5. 团队分工

本项目由 Group 11 六名成员合作开发。

| 成员 | 负责内容 |
|---|---|
| 成员 1 | 公共代码框架、数据库基础结构、页面导航、个人资料及最终项目集成 |
| 成员 2 | 运动记录、热量估算、每周运动计划与打卡 |
| 成员 3 | 食物数据库、饮食记录、营养计算及热量目标管理 |
| 成员 4 | 睡眠记录、睡眠时长计算及睡眠评价 |
| 成员 5 | 首页、每日及每周统计、历史记录与趋势展示 |
| 成员 6 | 目标推荐、每日提醒、数据管理及应用测试 |

所有成员使用同一个 Android 项目进行开发，并遵循统一的数据结构、模块接口及代码管理规范。

各成员在独立的 Git 分支中完成对应功能，通过 Pull Request 将代码合并至主分支。

---

## 6. 项目运行

### 环境要求

- Android Studio
- Android SDK
- Git
- Android 模拟器或安卓实体设备

### 运行步骤

**第一步：获取项目**

通过 GitHub 下载或克隆本仓库。

```bash
git clone <REPOSITORY_URL>
```

将 `<REPOSITORY_URL>` 替换为当前仓库的实际地址。

**第二步：打开项目**

在 Android Studio 中打开克隆后的项目根目录。

**第三步：同步 Gradle**

等待 Android Studio 完成 Gradle Sync，并下载所需依赖。

**第四步：运行应用**

启动 Android 模拟器或连接安卓实体设备。

点击 Android Studio 中的 **Run 'app'**，编译并运行应用。

> 本仓库为私有仓库，仅向获得授权的项目组成员开放访问权限。

---

## 7. 开发文档

项目提供以下文档，供小组成员查阅。

| 文档 | 主要内容 |
|---|---|
| `docs/PRD.md` | 产品需求及功能说明 |
| `docs/TEAM.md` | 六人分工及模块开发任务 |
| `docs/DEVELOPMENT_GUIDE.md` | 项目架构、数据库结构、公共接口及代码规范 |
| `docs/MEMBER_GUIDE.md` | 各成员负责的代码文件、开发指引及 GitHub 操作说明 |
| `AGENTS.md` | AI 辅助编程工具需要遵守的项目开发规范 |

**所有成员在开始开发前，应先阅读相关开发文档。**

如需修改公共数据库结构、统一接口或核心工程配置，应提前与负责项目集成的成员沟通，避免影响其他模块的正常运行。

---

## 8. 项目声明

本项目为**香港城市大学 EE5415 课程设计（Course Project）**，由 Group 11 六名学生合作开发，主要用于安卓应用开发、软件工程实践及课程学习。

HealthApp 旨在提供一般性的健康习惯记录和个人活动管理功能，不提供医疗诊断、临床评估或专业医疗建议。

应用中的运动热量估算及饮食营养计算基于预设参考数据，仅供一般健康管理参考。

---

**City University of Hong Kong · EE5415 · Group 11**

*HealthApp — Track Your Habits, Build a Healthier Life.*
