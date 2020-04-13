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

public partial class AdminStu1 : System.Web.UI.Page
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
        sql = string.Format("select 学号,姓名,性别,年龄,所在院系,班级名,convert(char(10),入学年份,20) as 入学年份 from 学生信息表");
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
        Response.Redirect("AdminStuAdd.aspx");
    }
    protected void DataGrid1_PageIndexChanged(object source, DataGridPageChangedEventArgs e)
    {
        this.DataGrid1.CurrentPageIndex = e.NewPageIndex;
        GetData();
    }
    protected void DataGrid1_EditCommand(object source, DataGridCommandEventArgs e)
    {
        this.DataGrid1.EditItemIndex = e.Item.ItemIndex;
        GetData();
    }
    protected void DataGrid1_CancelCommand(object source, DataGridCommandEventArgs e)
    {
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void DataGrid1_DeleteCommand(object source, DataGridCommandEventArgs e)
    {
        string sid = e.Item.Cells[0].Text;
        string sql = string.Format("delete 学生信息表 where 学号 = '{0}'", sid);
        ExeSql(sql);
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
        txtAge = (TextBox)e.Item.Cells[3].Controls[0];
        string age = txtAge.Text.ToString();

        TextBox txtS = new TextBox();
        txtS = (TextBox)e.Item.Cells[3].Controls[0];
        string s = txtS.Text.ToString();

        TextBox txtClass = new TextBox();
        txtClass = (TextBox)e.Item.Cells[4].Controls[0];
        string classname = txtClass.Text.ToString();

        string sql = string.Empty;
        sql = string.Format("update 学生信息表 set 姓名='{0}',年龄='{1}',所在院系='{2}',班级名='{3}' where 学号='{4}'", name, age, s, classname, sid);
        ExeSql(sql);
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void DataGrid1_ItemDataBound(object sender, DataGridItemEventArgs e)
    {
        if (e.Item.ItemType == ListItemType.EditItem)
        {
            TextBox t1 = (TextBox)e.Item.Cells[1].Controls[0];
            TextBox t2 = (TextBox)e.Item.Cells[2].Controls[0];
            TextBox t3 = (TextBox)e.Item.Cells[3].Controls[0];
            TextBox t4 = (TextBox)e.Item.Cells[4].Controls[0];

            t1.Width = 1000;
            t2.Width = 10;
            t3.Width = 10;
            t4.Width = 10;
        }
    }
    protected void DataGrid1_ItemCommand(object source, DataGridCommandEventArgs e)
    {
        if (e.Item.ItemType == ListItemType.EditItem)
        {
            TextBox t1 = (TextBox)e.Item.Cells[1].Controls[0];
            //TextBox t2 = (TextBox)e.Item.Cells[2].Controls[0];
            TextBox t3 = (TextBox)e.Item.Cells[3].Controls[0];
            TextBox t4 = (TextBox)e.Item.Cells[4].Controls[0];

            t1.Width = 1000;
            //t2.Width = 10; 
            t3.Width = 10;
            t4.Width = 10;
        }
    }
}