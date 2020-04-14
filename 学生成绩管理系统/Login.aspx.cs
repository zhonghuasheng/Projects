using System;
using System.Collections.Generic;
using System.Linq;
using System.Web;
using System.Web.UI;
using System.Web.UI.WebControls;
using System.Web.UI.HtmlControls;
using System.Data.SqlClient;
using System.Configuration;

public partial class Login1 : System.Web.UI.Page
{
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {

    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        string sql = string.Empty;
        string user = this.txtUsername.Text.Trim();
        string pwd = txtPassword.Text.Trim();
        sql = "select * from Admin where username='"+user+"' and password='"+pwd+"'";
        SqlDataReader dr;
        SqlCommand cmd = new SqlCommand(sql, conn);
        try
        {
            conn.Open();
            dr = cmd.ExecuteReader();
            if (dr.Read())
            {
                Session["username"] = dr["username"].ToString();
                Session["group"] = dr["group"].ToString();
                Response.Redirect("Main.aspx");
            }
            else
            {
                Response.Write("<script>alert('用户名或者密码错误,请重新输入!')</script>");
            }
        }
        catch (Exception ex)
        {
            Response.Write(ex);
        }
        finally
        {
            conn.Close();
        }
    }
}