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

public partial class AdminStuAdd1 : System.Web.UI.Page
{
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    private void Add()
    {
        string sql1 = string.Empty;
        string sql2 = string.Empty;
        string sid = this.txtsid.Text.ToString();
        string name = this.txtname.Text.ToString();
        string sex = string.Empty;
        if (this.rbman.Checked)
        {
            sex = "男";
        }
        else
        {
            sex = "女";
        }
        int age = Convert.ToInt32(this.txtage.Text.ToString());
        string s = this.txts.Text.ToString();
        string classname = this.txtclassname.Text.ToString();
        string years = this.txtyear.Text.ToString();

        sql1 = string.Format("insert into 学生信息表(学号,姓名,性别,年龄,所在院系,班级名,入学年份 ) values('{0}','{1}','{2}',{3},'{4}','{5}','{6}')", sid, name, sex, age, s, classname, years);
        sql2 = string.Format("insert into Admin(username,password,[group]) values('{0}','{1}','学生用户组')", sid, sid);
        conn.Open();
        SqlCommand cmd1 = new SqlCommand(sql1, conn);
        SqlCommand cmd2 = new SqlCommand(sql2, conn);
        SqlTransaction stn = conn.BeginTransaction();
        cmd1.Transaction = stn;
        cmd2.Transaction = stn;
        try
        {
                cmd1.ExecuteNonQuery();
                cmd2.ExecuteNonQuery();
                stn.Commit(); 
                Response.Write("<script>alert('学生信息添加成功!')</script>");
                
            //}
            //catch//(Exception ex)
            //{
            //    //Response.Write(ex);
            //    Response.Write("<script>alert('该学号已经存在,添加失败!')</script>");
            //}
        }
        catch
        {
            Response.Write("<script>alert('该学号已经存在,添加失败!')</script>");
            stn.Rollback();
        }
        finally
        {
            conn.Close();
        }
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        Add();
    }
    protected void Button2_Click(object sender, EventArgs e)
    {
        Response.Redirect("AdminStu.aspx");
    }
}