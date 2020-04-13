using System;
using System.Collections.Generic;
using System.ComponentModel;
using System.Data;
using System.Drawing;
using System.Linq;
using System.Text;
using System.Windows.Forms;

namespace 贪吃蛇自练_GDI_
{
    public partial class Form1 : Form
    {
        public Point FoodLct = new Point();//缓存食物的坐标
        public int snakeLen=6;
        public const int SnakeMaxLength = 500;
        public Point[] snakeArr = new Point[SnakeMaxLength];
        public int snakeDrt = 2;
        public bool panDuan = true;

        public Form1()
        {
            InitializeComponent();

            int temp = 0;
            for (int i = snakeLen - 1; i >= 0; i--)
            {
                snakeArr[i].X = temp;
                snakeArr[i].Y = 0;
                temp += 15;
            }
        }

        /// <summary>
        /// 画一个小方块
        /// </summary>
        public void DrawShape(int x, int y)
        {
            Graphics g = this.CreateGraphics();
            Pen pen = new Pen(Color.Blue, 2);
            g.DrawRectangle(pen, x, y, 15, 15);
            g.FillRectangle(Brushes.Green, x, y, 15, 15);
        }

        /// <summary>
        /// 画一个食物
        /// </summary>
        public void DrawFood(int x, int y)
        {
            Graphics g = this.CreateGraphics();
            Pen pen = new Pen(Color.Red, 2);
            SolidBrush brush = new SolidBrush(Color.Green);
            g.DrawRectangle(pen, x, y, 15, 15);
            g.FillRectangle(brush, x, y, 15, 15);
        }

        /// <summary>
        /// 设置Point数组坐标
        /// </summary>
        public void Forward(int drt)
        {
            Point temp = snakeArr[0];

            for (int i = snakeLen-1; i > 0; i--)
            {
                snakeArr[i].X = snakeArr[i - 1].X;
                snakeArr[i].Y = snakeArr[i - 1].Y;
            }
            switch (drt)
            {
                case 1:
                    snakeArr[0].X = temp.X;
                    snakeArr[0].Y = temp.Y - 15;
                    break; //上 
                case 2:
                    snakeArr[0].X = temp.X + 15;
                    snakeArr[0].Y = temp.Y;
                    break; //右 
                case 3:
                    snakeArr[0].X = temp.X;
                    snakeArr[0].Y = temp.Y + 15;
                    break; //下 
                case 4:
                    snakeArr[0].X = temp.X - 15;
                    snakeArr[0].Y = temp.Y;
                    break; //左 
            }
        }

        /// <summary>
        /// 时间事件
        /// </summary>
        private void timer1_Tick(object sender, EventArgs e)
        {
            Graphics g = this.CreateGraphics();
            g.Clear(Color.DarkKhaki);//清除整个画面

            Forward(snakeDrt);
            for (int i = 0; i < snakeLen; i++)
            {
                DrawShape(snakeArr[i].X, snakeArr[i].Y);
            }

            if (panDuan)
            {
                ShowFood();
                //DrawFood(FoodLct.X, FoodLct.Y);
                panDuan = false;
            }

            if (EatedFoot(FoodLct))
            {
                ShowFood();
                DrawFood(FoodLct.X, FoodLct.Y);
            }
            else
            {
                DrawFood(FoodLct.X, FoodLct.Y);
            }

            if (CheckSnakeHeadInSnakeBody() || CheckSnakeBodyInFrm())
            {
                this.timer1.Enabled = false;
                MessageBox.Show("游戏结束！");
            }
        }

        /// <summary>
        /// 按下方向键
        /// </summary>
        private void Form1_KeyDown(object sender, KeyEventArgs e)
        {
            if (e.KeyCode == Keys.Up)
                snakeDrt = 1;
            else if (e.KeyCode == Keys.Down)
                snakeDrt = 3;
            else if (e.KeyCode == Keys.Right)
                snakeDrt = 2;
            else if (e.KeyCode == Keys.Left)
                snakeDrt = 4;
        }

        /// <summary>
        /// 判断是否撞到自己
        /// </summary>
        public bool CheckSnakeHeadInSnakeBody()
        {
            return this.CheckInSnakeBody(this.snakeArr[0].X, this.snakeArr[0].Y, 1);
        }
        /// <summary>
        /// 检查输入的坐标是否在蛇的身上
        /// </summary>
        public bool CheckInSnakeBody(int x, int y, int snkHead)
        {
            for (int i = snkHead; i < snakeLen; i++)
            {
                if (x == this.snakeArr[i].X && y == this.snakeArr[i].Y)
                {
                    return true;
                }
            }
            return false;
        }

        /// <summary>
        /// 判断是否撞墙
        /// </summary>
        /// <returns></returns>
        public bool CheckSnakeBodyInFrm()
        {
            if (this.snakeArr[0].X >= 594 || this.snakeArr[0].Y >= 399 - 32 || this.snakeArr[0].X < 0 || this.snakeArr[0].Y < 0)
                return true;
            else
                return false;
        }

        /// <summary>
        /// 随机显示食物
        /// </summary>
        public void ShowFood()
        {
            Random rmd = new Random();
            int x, y;
            x = rmd.Next(0, this.Width/15)*15;
            y = rmd.Next(0, this.Height/15)*15;
            //while (this.CheckInSnakeBody(x, y, 1))
            //{
            //    x = rmd.Next(0, 32) * 15;
            //    y = 32 + rmd.Next(0, 30) * 15;
            //}
            FoodLct.X = x;
            FoodLct.Y = y;
        }

        /// <summary>
        /// 判断是否吃到食物
        /// </summary>
        public bool EatedFoot(Point FoodLct)
        {
            if (snakeArr[0].X == FoodLct.X && snakeArr[0].Y == FoodLct.Y)
            {
                if (snakeLen < SnakeMaxLength)
                {
                    snakeLen++;
                    snakeArr[snakeLen].X = snakeArr[snakeLen - 1].X;
                    snakeArr[snakeLen].Y = snakeArr[snakeLen - 1].Y;
                }
                return true;
            }
            else
                return false;
        }
    }
}
