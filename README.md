# docker部署

```bash
mvn clean package -Dmaven.test.skip=true


docker build -t articletomk -f DockerfileYq .

docker build -t articletomk17 -f DockerfileYq .
```

## 构建过程

提示：

1. 需要登录账户

   ![image-20241114113341278](https://biliww.github.io/imgs/md202411/image-20241114113341278.png)

2. 翻墙没有任何问题，



```bash
wangpenglong@bogon toMarkdownServer % docker build -t articleToMk -f DockerfileYq .
[+] Building 0.0s (0/0)                                                                                                                                                               docker:desktop-linux
ERROR: invalid tag "articleToMk": repository name must be lowercase
wangpenglong@bogon toMarkdownServer % clear
wangpenglong@bogon toMarkdownServer % docker build -t articletomk -f DockerfileYq .
[+] Building 56.3s (4/4) FINISHED                                                                                                                                                     docker:desktop-linux
 => [internal] load build definition from DockerfileYq                                                                                                                                                  0.0s
 => => transferring dockerfile: 223B                                                                                                                                                                  0.0s
 => [internal] load .dockerignore                                                                                                                                                                     0.0s
 => => transferring context: 2B                                                                                                                                                                       0.0s
 => ERROR [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                   56.2s
 => [auth] library/openjdk:pull token for registry-1.docker.io                                                                                                                                        0.0s
------
 > [internal] load metadata for docker.io/library/openjdk:8:
------
ERROR: failed to solve: Canceled: context canceled
wangpenglong@bogon toMarkdownServer % 
wangpenglong@bogon toMarkdownServer % clear                                      
wangpenglong@bogon toMarkdownServer % docker build -t articletomk -f DockerfileYq .
[+] Building 91.4s (7/7) FINISHED                                                                                                                                                     docker:desktop-linux
 => [internal] load .dockerignore                                                                                                                                                                     0.0s
 => => transferring context: 2B                                                                                                                                                                       0.0s
 => [internal] load build definition from DockerfileYq                                                                                                                                                  0.0s
 => => transferring dockerfile: 223B                                                                                                                                                                  0.0s
 => [internal] load metadata for docker.io/library/openjdk:8                                                                                                                                          2.7s
 => [1/2] FROM docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                                   88.1s
 => => resolve docker.io/library/openjdk:8@sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8                                                                                    0.0s
 => => sha256:53ff4b6f85a89d88a34a0e8a00f1df940d15aee8cc1c717f919cc368ece0218e 1.79kB / 1.79kB                                                                                                        0.0s
 => => sha256:114ba63dd73a866ac1bb59fe594dfd218f44ac9b4fa4b2c68499da5584fcfa9d 53.68MB / 53.68MB                                                                                                     17.0s
 => => sha256:bc0b8a8acead4d7bf71c232054b2a0a8e08eb3e1e2cf46f9f3dba68723e88c85 5.15MB / 5.15MB                                                                                                       15.8s
 => => sha256:a4ea641ee67989acdb6af3d8b9b984ecd751a2a83c3b7ce071542b31c9ac1304 10.66MB / 10.66MB                                                                                                     15.4s
 => => sha256:86e863cc57215cfb181bd319736d0baf625fe8f150577f9eb58bd937f5452cb8 1.04kB / 1.04kB                                                                                                        0.0s
 => => sha256:6fbf41d7a67939f45a51bc0b3eda2eaaeee12d24a72c5e65208d811d380604f0 7.83kB / 7.83kB                                                                                                        0.0s
 => => sha256:04e9e95aca686baf2f9b88f3822104381dc1cd0e2bd6dc105b7468059336dbab 54.68MB / 54.68MB                                                                                                     77.3s
 => => sha256:433ac3e3efadde585bc509037327e11be53d7d8149e5e51663a30fe5f575222a 5.42MB / 5.42MB                                                                                                       22.8s
 => => sha256:ebf67a66d14c803e6358ab87df767805d434d009359b3618e81f9282441cff18 212B / 212B                                                                                                           17.8s
 => => extracting sha256:114ba63dd73a866ac1bb59fe594dfd218f44ac9b4fa4b2c68499da5584fcfa9d                                                                                                             3.9s
 => => sha256:ddc1237578660234ed25021536c3a0ff5f7e9cdff6ccadf04ae92399a421fa79 104.93MB / 104.93MB                                                                                                   87.0s
 => => extracting sha256:bc0b8a8acead4d7bf71c232054b2a0a8e08eb3e1e2cf46f9f3dba68723e88c85                                                                                                             0.3s
 => => extracting sha256:a4ea641ee67989acdb6af3d8b9b984ecd751a2a83c3b7ce071542b31c9ac1304                                                                                                             0.1s
 => => extracting sha256:04e9e95aca686baf2f9b88f3822104381dc1cd0e2bd6dc105b7468059336dbab                                                                                                             3.6s
 => => extracting sha256:433ac3e3efadde585bc509037327e11be53d7d8149e5e51663a30fe5f575222a                                                                                                             0.1s
 => => extracting sha256:ebf67a66d14c803e6358ab87df767805d434d009359b3618e81f9282441cff18                                                                                                             0.0s
 => => extracting sha256:ddc1237578660234ed25021536c3a0ff5f7e9cdff6ccadf04ae92399a421fa79                                                                                                             1.0s
 => [internal] load build context                                                                                                                                                                     0.1s
 => => transferring context: 3.00MB                                                                                                                                                                   0.0s
 => [2/2] COPY ./target/article_to_markdown.jar /article_to_markdown.jar                                                                                                                              0.5s
 => exporting to image                                                                                                                                                                                0.0s
 => => exporting layers                                                                                                                                                                               0.0s
 => => writing image sha256:84c83e222c29909e423b66a4ddda72a1a99ed671eb026a87a3e46526aac81714                                                                                                          0.0s
 => => naming to docker.io/library/articletomk                                                                                                                                                        0.0s

View build details: docker-desktop://dashboard/build/desktop-linux/desktop-linux/ji9fyctv90jwihaki8dp72jnn

What's Next?
  View a summary of image vulnerabilities and recommendations → docker scout quickview
wangpenglong@bogon toMarkdownServer % 

```

```bash
wangpenglong@localhost dockerfiles % docker images
REPOSITORY                        TAG           IMAGE ID       CREATED              SIZE
articletomk                       latest        84c83e222c29   About a minute ago   523MB
```



# 运行本地镜像

```bash
# --name指定容器名字 -v目录挂载 -p指定端口映射  -e设置mysql参数 -d后台运行
docker run -p 9998:9998 --name articletomk \
-v /Users/wangpenglong/dockerMounts/tomarkdown/pics:/Users/wangpenglong/dockerMounts/tomarkdown/pics \
-v /Users/wangpenglong/dockerMounts/tomarkdown/mds:/Users/wangpenglong/dockerMounts/tomarkdown/mds \
-d articletomk:latest
####
-v 将对应文件挂载到主机
-e 初始化对应
-p 容器端口映射到主机的端口
-d images名字 我们可以过 -d 指定容器的后台运行模式。


# --name指定容器名字 -v目录挂载 -p指定端口映射  -e设置mysql参数 -d后台运行
docker run -p 9997:9998 --name articletomk17 \
-v /Users/wangpenglong/dockerMounts/tomarkdown/pics:/Users/wangpenglong/dockerMounts/tomarkdown/pics \
-v /Users/wangpenglong/dockerMounts/tomarkdown/mds:/Users/wangpenglong/dockerMounts/tomarkdown/mds \
-d articletomk:latest


```



![image-20240904162118819](https://biliww.github.io/imgs/md/202409041621864.png)



![image-20240904162057145](https://biliww.github.io/imgs/md/202409041620273.png)



容器内文件创建成功

![image-20240904162211082](https://biliww.github.io/imgs/md/202409041622128.png)



# 推送镜像

```bash
docker tag articletomk:latest biliw/articletomarkdown:1.0.0


wangpenglong@localhost dockerfiles % docker push biliw/articletomarkdown:1.0.0
The push refers to repository [docker.io/biliw/articletomarkdown]
c322a65937f3: Pushed 
df0ca509f290: Mounted from library/openjdk 
89273ea6b11f: Mounted from library/openjdk 
ee9872ea8036: Mounted from library/openjdk 
b7b6064a28a9: Mounted from library/openjdk 
8874c5d5df1a: Mounted from library/openjdk 
595a656dd8ef: Mounted from library/openjdk 
bd245ec49ee5: Mounted from library/openjdk 
1.0.0: digest: sha256:50fd6de63414bf2cbf13cbb06510d033ecf01f615c2f28fe75fbaefa1ac64c08 size: 2007
```

Dockerhub 查看 https://hub.docker.com/

![image-20240904164244586](https://biliww.github.io/imgs/md/202409041642672.png)



# selenium
