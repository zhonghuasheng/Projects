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

public partial class AdminTeacher1 : System.Web.UI.Page
{
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
        sql = string.Format("select * from 授课表");
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
    protected void Button1_Click(object sender, EventArgs e)
    {
        Response.Redirect("AdminTeacherAdd.aspx");
    }
    protected void DataGrid1_CancelCommand(object source, DataGridCommandEventArgs e)
    {
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void DataGrid1_DeleteCommand(object source, DataGridCommandEventArgs e)
    {
        string sid = e.Item.Cells[0].Text;
        string sql = string.Format("delete 授课表 where 教师名 = '{0}'", sid);
        ExeSql(sql);
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void DataGrid1_EditCommand(object source, DataGridCommandEventArgs e)
    {
        this.DataGrid1.EditItemIndex = e.Item.ItemIndex;
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

        TextBox txtS = new TextBox();
        txtS = (TextBox)e.Item.Cells[3].Controls[0];
        string s = txtS.Text.ToString();


        string sql = string.Empty;
        sql = string.Format("update 授课表 set 课程号='{0}',学时数='{1}',班级名='{2}' where 教师名='{3}' ", name, age, s, sid);
        ExeSql(sql);
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void DataGrid1_PageIndexChanged(object source, DataGridPageChangedEventArgs e)
    {
        this.DataGrid1.CurrentPageIndex = e.NewPageIndex;
        GetData();
    }
}