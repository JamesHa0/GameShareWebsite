# GameShareWebsite
## ———— 一个简单的大学课程设计Web项目

<strong style="color:#334499">（ 注：README.md于24年8月2日开始更新。）</strong>


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年12月11日
- **更新内容**：
- 修补了评论区分页查询bug，评论区沙发显示bug。
- 前端vue各页面的API风格由选项式API(Options API)统一更换为组合式API (Composition API)。
- vue版本由原来的3.4.38升级到3.5.13。旨在获取该版本增加的下列特性: 访问 defineProps 解构的变量时，Vue 编译器会自动在前面添加 props，意即其值将自动刷新。



<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年12月07日
- **更新内容**： 
- 引入axios的request封装，封装了axios的拦截器，封装了请求api和方法utils。
- 将重写后的download方法挂载到了vue原型链上，方便后续调用。
- 完成了用户订单查询页面。
*  其他：
  1. 更换link图标为自定义的小猪ico（复出！）
  2. 新增依赖：    file-saver（v2.0.5，用于文件下载），js-cookie（v3.0.5，用于操作cookie）。
  3. 调整了前后端部分文件的文件名和代码。
*  经验：
  1. 切记axios配置config的各参数是大小写敏感的，headers易误写成Headers，造成请求头无效的问题。
##### 订单详情页演示如下：
<img src="storage/README_pictures/订单详情页.gif" alt="订单详情页" width="600px">


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年12月05日
- **更新内容**：
  - 模块化了router js代码。
  - 简单增加了登出功能（仅去除了本地存储的Token字段，未涉及后端修改Token过期时间的程序）。
  - 修改文件上传/下载的静态路径为项目相对路径。
  - 补充上一次更新时的遗漏（Token无效时的页面提示优化处理）演示，连同此次登出效果一起演示。
##### 登录状态无效处理演示如下：
<img src="storage/README_pictures/登录状态无效处理演示.gif" alt="登录状态无效处理演示" width="600px">


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年12月04日
- **更新内容**：
  - 数据库新增表sign_in。更新后附在 根目录/storage/sql下。
  - 完成了签到功能。每日可签到一次，获得不同权重下的积分。
##### 跑1000万次循环的实机测试概率图如下：
<img src="storage/README_pictures/新版本签到积分概率实机测试.png" alt="新版本签到积分概率实机测试" width="200px">

##### 签到演示如下：
<img src="storage/README_pictures/新版本签到演示.gif" alt="新版本签到演示" width="600px"></p>


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年11月30日
- **更新内容**：
  - #### !! 此次更新了数据库SQL文件。位于 根目录/storage/sql中。
  - 写好了评论回复功能。用户现在可以对任一合法评论进行回复，回复实时显示；对于已被删除的评论（这类评论标记为删除，但仍保留数据，且评论区不显示原评论内容），其点赞和评论图标变灰且不可点击。
  - 稍微规范了Feedback页的代码。
##### 演示如下：
<img src="storage/README_pictures/评论回复功能.gif" alt="评论回复功能" width="600px">


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年11月29日
- **更新内容**：
  - 写好了评论功能。用户现在可以发表一级评论；评论回复功能尚未完成。具体细节为：
  1，修改了game_comment表的表结构。最终持久层的字段数为9个，供给前端的字段数为12个；主要的修改是：cpath字段由持久层字段改为了临时字段，由查询SQL临时生成。
  2，多出的字段属CTE（Common Table Expressions，公用表表达式，是用于递归查询的SQL表达式）生成的临时字段，用于前端页面显示等。
##### 演示如下：
<img src="storage/README_pictures/评论功能.gif" alt="评论区功能" width="600px">


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年11月24日
- **更新内容**：
  - 写好了评论点赞功能。具体细节为：
  1，给某一评论点赞，会实时显示赞数和亮灭图标的变化；
  2，用户评论点赞记录持久化记忆。用户进入某一游戏页面后，缓存中会存有过去的评论点赞数据，由此会正确显示评论点赞情况，即点赞图标的亮灭。
##### 演示如下：
<img src="storage/README_pictures/评论点赞演示.gif" alt="评论区分页" width="600px">


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年11月22日
- **更新内容**：
  - 新增springdoc文档，并配置了可以在文档页的请求发送时，携带jwt于header中。
  - 依赖结构变换为DependencyManagement的风格，统一管理子模块依赖版本。
##### springdoc文档页演示如下：
<img src="storage/README_pictures/springdoc文档界面.png" alt="评论区分页" width="600px">


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年11月19日
- **更新内容**：
  - 项目结构变换为Spring boot + Vue。翻新了部分代码。
  - detail页游戏评论区新增分页功能。前端使用element-plus的分页组件，后端使用MyBatisPlus的Page插件。
##### 评论区分页模块演示如下：
<img src="storage/README_pictures/评论区分页.gif" alt="评论区分页" width="600px">


<br><br><br><br><br>
> ### 更新日志
- **更新日期**：2024年8月13日
- **更新内容**：
  - 修好了轮播图显示异常的bug。
  - 增加了点击指定图片跳转的功能。
##### 轮播图模块演示如下：
<img src="storage/README_pictures/轮播图演示.gif" alt="轮播图演示" width="600px" >


<br><br><br><br><br>
>### 更新日志
- **更新日期**：2024年8月11日
- **更新内容**：
  - 新增签到功能。
  - 增加了弹窗处理。
  - 引入了tld自定义标签和函数功能。
##### 未限制前的签到演示如下：
<img src="storage/README_pictures/未限制前的签到演示.gif" alt="签到演示" width="600px" >

##### 限制后的签到演示如下：
<img src="storage/README_pictures/限制后的签到演示.gif" alt="签到演示" width="600px" >

##### 签到获得的积分各数量的大约概率如下：
<img src="storage/README_pictures/签到积分概率示意图.png" alt="概率示意图" width="300px" >


<br><br><br><br><br>
>### 更新日志
- **更新日期**：2024年8月9日
- **更新内容**：
  - 修剪了部分网页的html结构。
  - 嵌入了小猪loading加载动画。
##### 小猪loading示例如下：
![小猪loading演示](storage/README_pictures/小猪loading演示.gif)


<br><br><br><br><br>
>### 更新日志
- **更新日期**：2024年8月8日
- **更新内容**：
  - 完善了评论功能的全部内容，包括游戏评论、评论点赞、评论回复。
  - 优化了评论区的排版和显示。
##### 评论功能演示：
<img src="storage/README_pictures/评论功能演示.gif" alt="评论演示" width="400" >


<br><br><br><br><br>
>### 更新日志
- **更新日期**：2024年8月2日
- **更新内容**：
  - 优化了评论区的排版方式，尽管仍需进一步改进。
  - 排版规律为：一级评论按点赞量高低排序，多级评论同级间有相同缩进且始终按时间先后顺序排序。
  - 剩余功能正在完善中。
##### 优化后的评论区排版示例：
<img src="storage/README_pictures/层级评论区示意图.png" alt="Alt text" width="300px" />











<br><br><br><br><br>
**注意**：以上内容仅为示例，具体细节和功能应参照实际项目情况。