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

public partial class AdminCourse1 : System.Web.UI.Page
{
    //protected System.Web.UI.WebControls.DataGrid DataGrid1;
    //protected System.Web.UI.WebControls.Button Button2;
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            GetData();
        }
    }
    private void GetData()
    {
        string sql = string.Empty;
        sql = string.Format("select * from 课程表");
        SqlDataAdapter da = new SqlDataAdapter(sql, conn);
        DataSet ds = new DataSet();
        try
        {
            da.Fill(ds, "t");
            this.DataGrid1.DataSource = ds.Tables["t"];
            this.DataGrid1.DataBind();
        }
        catch
        { }
    }
    private void ExeSql(string sql)
    {
        SqlCommand cmd = new SqlCommand(sql, conn);
        try
        {
            conn.Open();
            cmd.ExecuteNonQuery();
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
    protected void Button2_Click(object sender, EventArgs e)
    {
        Response.Redirect("AdminCourseAdd.aspx");
    }
    protected void DataGrid1_EditCommand(object source, DataGridCommandEventArgs e)
    {
        this.DataGrid1.EditItemIndex = e.Item.ItemIndex;
        GetData();
    }
    protected void DataGrid1_DeleteCommand(object source, DataGridCommandEventArgs e)
    {
        string sid = e.Item.Cells[0].Text;
        string sql = string.Format("delete 课程表 where 课程号 = '{0}'", sid);
        ExeSql(sql);
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void DataGrid1_CancelCommand(object source, DataGridCommandEventArgs e)
    {
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void DataGrid1_UpdateCommand(object source, DataGridCommandEventArgs e)
    {
        string sid = e.Item.Cells[0].Text;

        TextBox txtName = new TextBox();
        txtName = (TextBox)e.Item.Cells[1].Controls[0];
        string name = txtName.Text.ToString();

        TextBox txtAge = new TextBox();
        txtAge = (TextBox)e.Item.Cells[2].Controls[0];
        string age = txtAge.Text.ToString();


        string sql = string.Empty;
        sql = string.Format("update 课程表 set 课程名='{0}',先修课='{1}' where 课程号='{2}'", name, age, sid);
        ExeSql(sql);
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
}