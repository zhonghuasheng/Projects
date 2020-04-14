using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Text;
using System.Windows.Forms;
using XdictGrb;                 //金山词霸组件
using System.Runtime.InteropServices;


namespace WinApp2005
{
    [DllImport("XdictGrb.dll")];
    public partial class Form1 : System.Windows.Forms.Form, IXDictGrabSink
    {
        public Form1()
        {
            InitializeComponent();
            GrabProxy gp = new GrabProxy();
            gp.GrabInterval = 20;                            //取词时间间隔
            gp.GrabMode = XDictGrabModeEnum.XDictGrabMouse;  //设定取词的属性
            gp.GrabEnabled = true;                           //取词
            gp.AdviseGrab(this);
        }
        //接口的实现
        int IXDictGrabSink.QueryWord(string WordString, int lCursorX, int lCursorY, string SentenceString, ref int lLoc, ref int lStart)
        {
            this.textBox1.Text = SentenceString;            //鼠标附近语句
            this.textBox2.Text = "X = " + lCursorX.ToString();           //鼠标坐标
            this.textBox3.Text = "Y = " + lCursorY.ToString();
            return 1;
        }

        private void textBox1_TextChanged(object sender, EventArgs e)
        {
           
        }

        private void textBox3_TextChanged(object sender, EventArgs e)
        {

        }
    }

}