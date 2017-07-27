# StudyForOpenCV
本项目是用来学习OpenCV使用的代码，使用Android ndk 和 OpenCV提供的接口。

# 灰度图片
![pic](https://github.com/ForgetAll/StudyForOpenCV/blob/master/screenshot/gray.png)

# 模糊
![pic](https://github.com/ForgetAll/StudyForOpenCV/blob/master/screenshot/blur.png)

处理图片极有可能引发oom，所以资源一定要及时回收，避免不必要的大内存分配。我这个项目添加了这个属性：largeHead="true"，请求更大的内存。当然，当你选择用手机处理图片时，最好不要处理原图，处理缩略图最好。
