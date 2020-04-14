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

public partial class AdminUrl1111 : System.Web.UI.Page
{
    private SqlConnection conn = new SqlConnection(ConfigurationManager.ConnectionStrings["GradeSys"].ConnectionString);
    protected void Page_Load(object sender, EventArgs e)
    {
        if (!Page.IsPostBack)
        {
            GetUrl();
        }
    }
    private void GetUrl()
    {
        string sql = string.Empty;
        sql = string.Format("select * from AdminUrl");
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
    protected void DataGrid1_PageIndexChanged(object source, DataGridPageChangedEventArgs e)
    {
        this.DataGrid1.CurrentPageIndex = e.NewPageIndex;
        GetUrl();
    }
}