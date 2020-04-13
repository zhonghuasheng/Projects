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
public partial class AdminGradeAdd1 : System.Web.UI.Page
{
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {
        GetClassName();
        try
        {
            if (Request.QueryString["Action"].ToString() == "Add")
            {
                GetStu();
            }
        }
        catch
        { }
    }
    private void GetClassName()
    {
        string sql = string.Empty;
        sql = string.Format("select 班级名 from 学生信息表 group by 班级名");
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
    private void GetStu()
    {
        string sql = string.Empty;
        sql = string.Format("select 学号,姓名,性别,班级名,所在院系 from 学生信息表 where 班级名='{0}'", Request.QueryString["班级名"].ToString());
        SqlDataAdapter da = new SqlDataAdapter(sql, conn);
        DataSet ds = new DataSet();
        try
        {
            da.Fill(ds, "t");
            this.DataGrid2.DataSource = ds.Tables["t"];
            this.DataGrid2.DataBind();
        }
        catch (Exception ex)
        {
            Response.Write(ex);
        }
    }
    protected void DataGrid1_PageIndexChanged(object source, DataGridPageChangedEventArgs e)
    {
        this.DataGrid1.CurrentPageIndex = e.NewPageIndex;
        GetClassName();
    }
    protected void DataGrid2_PageIndexChanged(object source, DataGridPageChangedEventArgs e)
    {
        this.DataGrid2.CurrentPageIndex = e.NewPageIndex;
        GetStu();
    }
    protected void DataGrid2_SelectedIndexChanged(object sender, EventArgs e)
    {

    }
}