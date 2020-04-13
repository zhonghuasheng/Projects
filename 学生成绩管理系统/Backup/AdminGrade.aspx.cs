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
public partial class AdminGrade1 : System.Web.UI.Page
{
    public string button;
    //System.Text.StringBuilder sb = new System.Text.StringBuilder();
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {
    }
    private void GetData()
    {
        string sql = string.Empty;
        string yuanxi = txt1.Text.Trim();
        string banji = txt2.Text.Trim();
        sql = string.Format("select 成绩表.学号,姓名,课程号,成绩,性别,班级名 from 成绩表,学生信息表 where 成绩表.学号=学生信息表.学号 and 所在院系='{0}' and 班级名='{1}'",yuanxi,banji);
        SqlDataAdapter da = new SqlDataAdapter(sql, conn);
        DataSet ds = new DataSet();
        try
        {
            da.Fill(ds, "t");
            this.DataGrid1.DataSource = ds.Tables["t"];
            this.DataGrid1.DataBind();
        }
        catch (Exception ex)
        {
            Response.Write(ex);
        }
    }
    protected void Button1_Click(object sender, EventArgs e)
    {
        Response.Redirect("AdminGradeAdd.aspx");
    }
    protected void DataGrid1_EditCommand(object source, DataGridCommandEventArgs e)
    {
        this.DataGrid1.EditItemIndex = e.Item.ItemIndex;
        GetData();
    }
    protected void DataGrid1_UpdateCommand(object source, DataGridCommandEventArgs e)
    {
        string number = e.Item.Cells[0].Text;
        string kechenghao = e.Item.Cells[2].Text;

        TextBox txtName = new TextBox();
        txtName = (TextBox)e.Item.Cells[3].Controls[0];
        string grade = txtName.Text.ToString();

        string sql = string.Empty;
        sql = string.Format("update 成绩表 set 成绩='{0}' where 学号='{1}' and 课程号='{2}'",grade,number,kechenghao);
        ExeSql(sql);
        this.DataGrid1.EditItemIndex = -1;
        GetData();
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
    protected void DataGrid1_CancelCommand(object source, DataGridCommandEventArgs e)
    {
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void DataGrid1_DeleteCommand(object source, DataGridCommandEventArgs e)
    {
        string number = e.Item.Cells[0].Text;
        string kechenghao = e.Item.Cells[2].Text;
        string sql = string.Format("delete from 成绩表 where 学号 = '{0}' and 课程号='{1}'",number,kechenghao);
        ExeSql(sql);
        this.DataGrid1.EditItemIndex = -1;
        GetData();
    }
    protected void search_Click(object sender, EventArgs e)
    {
        GetData();
        System.Text.StringBuilder sb = new System.Text.StringBuilder();
        sb.Append("<a target=\"main\" href=\"AdminGradeAdd.aspx\">学生成绩录入</a>");
        button = sb.ToString();
    }
}