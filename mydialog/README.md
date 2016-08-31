#自定义对话框及吐司library


#DefineCustomProgressDialog:
如下用法，只需要用静态方法创建一个dialog，并设置要显示的信息，然后显示即可，
不需要再设置dialog的其他通用属性，dialog默认可通过返回键关闭
----------------------------------------------------------
       DefineCustomProgressDialog dialog = DefineCustomProgressDialog.createDialog(this);
              dialog.setMessage("我是自定义加载对话框的信息！");
              dialog.show();

----------------------------------------------------------
![image](https://github.com/wkangle/Mylibrary/blob/master/mydialog/gif/dialog.gif )   

2016年8月30日19:34:08




#自定义吐司
~ToastUtils
如下用法：
-----------------------------------------------------------------
       ToastUtils.showMessage("永远相信\n美好的事情即将发生",XXXActivity.this);

-----------------------------------------------------------------

![image](https://github.com/wkangle/Mylibrary/blob/master/mydialog/gif/toast.gif )   

只需调用此工具类显示信息即可，在这个类里，全局只维护了唯一的toast ，不会出现多个toast覆盖和长时间显示不消退
2016年8月30日20:09:38

