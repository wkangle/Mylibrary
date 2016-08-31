# Mylibrary
#整理的开源代码库
###感谢所有的开源代码
####by：kangle
####Email： wkl_2052@qq.com
####weixin: feimeng16



## License


        The MIT License (MIT)

        Copyright (c) 2015-2016 Cleveroad

        Permission is hereby granted, free of charge, to any person obtaining a copy
        of this software and associated documentation files (the "Software"), to deal
        in the Software without restriction, including without limitation the rights
        to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
        copies of the Software, and to permit persons to whom the Software is
        furnished to do so, subject to the following conditions:

        The above copyright notice and this permission notice shall be included in all
        copies or substantial portions of the Software.

        THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
        IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
        FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
        AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
        LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
        OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
        SOFTWARE.
----------


####代码App包说明：程序基于一个MainActivity,根据listView 位置确定启动那个Activity，Activity命名依据其所在listview的位置决定，内部的activity再启动会追加AXXsubXXActivity为命名规则



----------------------------
·新增pickerView
·新增wheelView
2016年8月31日15:31:31
----------------------------

#Module pickerView  *********************start************************:

pickerView 和wheelView，用于选择String数据，可任意设置显示数据，默认位置等

----------
![image](https://github.com/wkangle/Mylibrary/blob/master/pickerview/gif/pickerView.gif )
----------

#Module pickerView  *********************end************************:







----------------------------
·新增自定义加载对话框
·新增自定义吐司
2016年8月31日10:08:01
----------------------------

#Module mydialog  *********************start************************:

##DefineCustomProgressDialog:
如下用法，只需要用静态方法创建一个dialog，并设置要显示的信息，然后显示即可，
不需要再设置dialog的其他通用属性，dialog默认可通过返回键关闭
----------------------------------------------------------
       DefineCustomProgressDialog dialog = DefineCustomProgressDialog.createDialog(this);
              dialog.setMessage("我是自定义加载对话框的信息！");
              dialog.show();

----------------------------------------------------------
![image](https://github.com/wkangle/Mylibrary/blob/master/mydialog/gif/dialog.gif )

2016年8月30日19:34:08




##自定义吐司
~ToastUtils
如下用法：
-----------------------------------------------------------------
       ToastUtils.showMessage("永远相信\n美好的事情即将发生",XXXActivity.this);

-----------------------------------------------------------------

![image](https://github.com/wkangle/Mylibrary/blob/master/mydialog/gif/toast.gif )

只需调用此工具类显示信息即可，在这个类里，全局只维护了唯一的toast ，不会出现多个toast覆盖和长时间显示不消退
2016年8月30日20:09:38

#Module mydialog  ***********************end**********************:



