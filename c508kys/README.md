# 该文件夹中存放着整个若依项目，后续我们也会在此基础上进行二次创作，下面将呈现如何将这个项目配置到本地。

# **一、后端**

1、JDK：

JDK版本需要在1.8以上

2、MySQL：

计算机中先配置MySQL的环境，创建账号密码等之后在项目工程中寻找sql文件夹，这之中有数据库配置脚本，通过idea可一键配置。

![image-20250728154651877](C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728154651877.png)

之后在admin文件中resources下application-druid.yml填写数据库的账号和密码。

![image-20250728155446376](C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728155446376.png)

![image-20250728155422305](C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728155422305.png)



3、Redis：

计算机中需要部署好redis，之后像数据库一样修改账号密码即可，不需要进行其他操作。

文件地址是admin中resources下的application.yml

![image-20250728160315112](C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728160315112.png)![image-20250728160323599](C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728160323599.png)

至此，后端的环境就配好了

在admin中运行RouYiapplication终端会呈现如下结果

![image-20250728160507537](C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728160507537.png)

在rouyi-ui的readme文件中启动服务在网页端会呈现如下结果。![d4b9db3aa4ba539afe0ccf325a92e43](D:\Wechat\WeChat Files\wxid_luryu4nbnv2v22\FileStorage\Temp\d4b9db3aa4ba539afe0ccf325a92e43.png)

# 二、前端

1、你的计算机上需要有node环境，配置好之后再rouyi-ui的readme文件中可以看到配置本项目需要用到的环境，运行它就好，

<img src="C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728160938081.png" alt="image-20250728160938081" style="zoom: 67%;" />

<img src="C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728160952853.png" alt="image-20250728160952853" style="zoom: 80%;" />

现在再启动这个项目就可以看到完整的界面了

![image-20250728161216212](C:\Users\20227\AppData\Roaming\Typora\typora-user-images\image-20250728161216212.png)
