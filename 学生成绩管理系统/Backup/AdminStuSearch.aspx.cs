using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;
using System.Configuration;
using System.Data;
using System.Collections;

public partial class AdminStuSearch1 : System.Web.UI.Page
{
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {
        
    }
    protected void btn_Click(object sender, EventArgs e)
    {
        if (this.xuehao.Text.Length!=0)
        {
            if (this.kechenghao.Text.Length!=0)
            {
                string str = string.Format("select 学号,课程号,成绩 from 成绩表 where 学号='{0}' and 课程号='{1}'",this.xuehao.Text,this.kechenghao.Text);
                conn.Open();
                SqlDataAdapter sda = new SqlDataAdapter(str,conn);
                DataSet ds = new DataSet();
                sda.Fill(ds);
                if (ds.Tables.Count == 1 && ds.Tables[0].Rows.Count == 0)
                {
                    Response.Write("<script>alert('查询记录不存在，请重新输入！')</script>");
                }
                else
                {
                    gri.DataSource = ds;
                    gri.DataBind();
                    conn.Close();
                    ds = null;
                }
            }
            else
            {
                string str1 = string.Format("select 学号,课程号,成绩 from 成绩表 where 学号='{0}'",this.xuehao.Text);
                SqlDataAdapter sda1 = new SqlDataAdapter(str1, conn);
                DataSet ds1 = new DataSet();
                sda1.Fill(ds1);
                if (ds1.Tables.Count == 1 && ds1.Tables[0].Rows.Count == 0)
                {
                    Response.Write("<script>alert('查询记录不存在，请重新输入！')</script>");
                }
                else
                {
                    gri.DataSource = ds1;
                    gri.DataBind();
                    conn.Close();
                    ds1 = null;
                }
            }
        }
        else
        {
            Response.Write("<script>alert('请输入学号！')</script>");
        }
    }
}