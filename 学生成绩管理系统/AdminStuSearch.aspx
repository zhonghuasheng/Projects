<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminStuSearch.aspx.cs" Inherits="AdminStuSearch1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminStuSearch</title>
		<meta name="GENERATOR" content="Microsoft Visual Studio .NET 7.1"/>
		<meta name="CODE_LANGUAGE" content="C#"/>
		<meta name="vs_defaultClientScript" content="JavaScript"/>
		<meta name="vs_targetSchema" content="http://schemas.microsoft.com/intellisense/ie5"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
        <table border="1">
          <tr>
            <td>请输入学号：<asp:TextBox ID="xuehao" runat="server"></asp:TextBox></td>
            <td></td>
          </tr>
          <tr>
            <td>输入课程号：<asp:TextBox ID="kechenghao" runat="server"></asp:TextBox></td>
            <td><asp:Button ID="btn" runat="server" Text="搜索" onclick="btn_Click" /></td>
          </tr>
        </table><br /><br /><br />
            <asp:GridView ID="gri" runat="server" AutoGenerateColumns="false" Width="267px">
              <HeaderStyle BackColor="#CCCC66" />
              <Columns>
                <asp:BoundField DataField="学号" HeaderText="学号" />
                <asp:BoundField DataField="课程号" HeaderText="课程号" />
                <asp:BoundField DataField="成绩" HeaderText="成绩" />
              </Columns>
            </asp:GridView>
		</form>
        </center>
	</body>
</html>
