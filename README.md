# 河北北方学院 信息科学与工程学院

# c508科研室网站（开发版本）

# 目录

- [1.常用的git命令](#常用的git命令)


## 1.常用的git命令

| 命令 | 解释 | 示例 | 适用场景 |
|------|------|:----:|----------|
| `git init` | 初始化本地 Git 仓库，生成 `.git` 目录 | `git init` | 新建项目时，将普通文件夹转为 Git 可管理的仓库 |
| `git add <文件路径>` | 将指定文件添加到暂存区 | `git add README.md` <br> `git add src/index.js` | 单个或多个文件修改后，准备提交前执行 |
| `git add .` | 将当前目录所有修改/新增文件添加到暂存区 | `git add .` | 批量提交多个文件修改时快速使用 |
| `git commit -m "提交说明"` | 将暂存区文件提交到本地仓库，`-m` 后为提交信息 | `git commit -m "修复登录页面按钮样式"` <br> `git commit -m "新增用户注册功能"` | 完成一批修改后，记录变更（信息需清晰具体） |
| `git status` | 查看工作区、暂存区的文件状态 | `git status` | 提交前确认待提交文件，或检查是否有未跟踪文件 |
| `git remote add origin <远程地址>` | 关联本地仓库与远程仓库 | `git remote add origin https://github.com/c508kys/kys.git` | 首次将本地项目连接到 GitHub 等远程仓库时 |
| `git remote set-url origin <新地址>` | 修改已关联的远程仓库地址 | `git remote set-url origin git@github.com:c508kys/kys.git` | 从 HTTPS 协议切换为 SSH 协议时 |
| `git push -u origin <分支名>` | 将本地分支推送到远程仓库，`-u` 绑定默认推送分支 | `git push -u origin main` <br> `git push -u origin dev` | 首次推送分支，后续可简化为 `git push` |
| `git pull origin <分支名>` | 拉取远程分支最新代码并合并到本地 | `git pull origin main` <br> `git pull origin dev` | 多人协作时，同步他人提交的最新代码 |
| `git branch` | 查看本地所有分支，当前分支前有 `*` 标记 | `git branch` | 确认当前所在分支，或查看已有分支列表 |
| `git checkout <分支名>` | 切换到指定分支 | `git checkout dev` <br> `git checkout feature/login` | 切换到其他分支进行开发或修改 |
| `git checkout -b <新分支名>` | 创建并切换到新分支 | `git checkout -b feature/payment` <br> `git checkout -b bugfix/error` | 新建功能分支或修复分支时 |
| `git rm <文件路径>` | 从暂存区和工作区删除文件 | `git rm logs/old.log` <br> `git rm "docs/说明(1).md"` | 删除文件后，同步到版本控制时 |
| `git log` | 查看提交历史记录 | `git log` <br> `git log --oneline`（简洁显示） | 追溯过往修改记录，查看提交人及时间 |
| `git mv <旧路径> <新路径>` | 重命名文件或移动文件位置 | `git mv logs/old.md logs/new.md` <br> `git mv src/utils.js src/tools/utils.js` | 修改文件名并让 Git 识别为更名（而非删除+新增） |
| `git restore <文件路径>` | 丢弃工作区的修改，恢复到最近一次提交状态 | `git restore app.js` <br> `git restore css/style.css` | 误修改文件后，想撤销未提交的变更 |
| `git clone <远程仓库地址>` | 从远程仓库复制完整项目到本地 | `git clone https://github.com/c508kys/kys.git` | 首次获取远程已有项目（如克隆开源项目） |