using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;
using System.Configuration;
public partial class AdminGradeAddNext1 : System.Web.UI.Page
{
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    private void Add()
    {
        string sql = string.Empty;
        //sql="insert into 成绩表(学号,课程号,成绩) values('"+Request.QueryString["学号"].ToString()+"','"+txtcid.Text+"','"+txtgrade.Text+"') ";
        sql = string.Format("insert into 成绩表(学号,课程号,成绩) values('{0}','{1}',{2})", Request.QueryString["学号"].ToString(), this.txtcid.Text.ToString(), this.txtgrade.Text.ToString());
        SqlCommand cmd = new SqlCommand(sql, conn);
        try
        {
            conn.Open();
            cmd.ExecuteNonQuery();
            Response.Write("<script>alert('成绩添加成功!')</script>");
        }
        catch//(Exception ex)
        {
            //Response.Write(ex);
            Response.Write("<script>alert('成绩添加失败!')</script>");
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
}