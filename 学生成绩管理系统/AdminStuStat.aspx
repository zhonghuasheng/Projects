<%@ Page Language="C#" AutoEventWireup="true" CodeFile="AdminStuStat.aspx.cs" Inherits="AdminStuStat1" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">

<html xmlns="http://www.w3.org/1999/xhtml">
<head runat="server">
		<title>AdminStuStat</title>
		<meta content="Microsoft Visual Studio .NET 7.1" name="GENERATOR"/>
		<meta content="C#" name="CODE_LANGUAGE"/>
		<meta content="JavaScript" name="vs_defaultClientScript"/>
		<meta content="http://schemas.microsoft.com/intellisense/ie5" name="vs_targetSchema"/>
		<link href="css/style.css" type="text/css" rel="stylesheet"/>
	</head>
	<body>
    <center>
		<form id="Form1" method="post" runat="server">
			课程统计
			<asp:DataGrid id="DataGrid1" runat="server" AllowPaging="True" Width="320px" 
                onpageindexchanged="DataGrid1_PageIndexChanged">
				<headerStyle BackColor="#CCCC66"></headerStyle>
				<PagerStyle NextPageText="下一页" PrevPageText="上一页"></PagerStyle>
			</asp:DataGrid>
		</form>
        </center>
	</body>
</html>
