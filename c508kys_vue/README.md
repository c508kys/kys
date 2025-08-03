# 此文件夹存放网站前端的代码
# **一、运行时需要做的准备**
## **1、下载node.js**
### **在nodejs.org网站中下载14.18.0及以上版本的node.js**
## **2、配置镜像**
### 检查是否下载成功
#### 如果显示对应的node版本则下载成功
    node -v
#### 如果显示对应的npm版本则下载成功
    npm -v
#### 配置国内淘宝镜像
    npm config set registry https://registry.npmmirror.com
#### 检查镜像是否配置完成（如果输出 https://registry.npmmirror.com，说明配置成功。）
    npm config get registry
# **二、运行VUE代码**
### 在Visual Studio中打开VUE代码文件夹
### 打开Visual Studio中的终端，确定终端的地址是否为代码文件地址，若不一致则自行调节
#### 项目中通常有 package.json 文件，执行以下命令安装依赖：
    npm install
#### 启动开发服务器
    npm run dev
<img width="364" height="44" alt="image" src="https://github.com/user-attachments/assets/1f0d73fb-e49b-448e-9f69-b9f9a9d92027" />

#### 点击该端口即可查看代码运行结果


