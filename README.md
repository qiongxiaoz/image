# image
照片同步demo

### 1.开发自己的图片处理逻辑
  如事例中 ImageForward ，接收图片base64后的数据和团队用户信息，将图片保存在本地。
  返回正确的编码
### 2.部署自己的服务，可以外网访问。
### 3.填写图片处理的访问路径。
  第一次填写会发送一条测试数据到服务器，正确返回方可提交。
### 4.保证服务的稳定。
  每次进行转发，如果失败，都会记录失败次数，累计一定次数会自动关闭同步功能。

