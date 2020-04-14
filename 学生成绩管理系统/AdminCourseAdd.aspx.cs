using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;
using System.Configuration;
public partial class AdminCourseAdd1 : System.Web.UI.Page
{
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    private void Add()
    {
        string sql = string.Empty;
        sql = string.Format("insert into 课程表(课程号,课程名,先修课) values('{0}','{1}','{2}')", this.txtid.Text, this.txtname.Text, this.txtpre.Text);
        SqlCommand cmd = new SqlCommand(sql, conn);
        try
        {
            conn.Open();
            cmd.ExecuteNonQuery();
            Response.Write("<script>alert('课程信息添加成功!')</script>");
        }
        catch//(Exception ex)
        {
            //Response.Write(ex);
            Response.Write("<script>alert('课程信息添加失败!')</script>");
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
        Response.Redirect("AdminCourse.aspx");
    }
}